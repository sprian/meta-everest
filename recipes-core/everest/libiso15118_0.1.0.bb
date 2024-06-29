LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libiso15118.git;branch=preparation_core_release;protocol=https \
           file://0001-Add-INSTALL-option.patch"

inherit cmake pkgconfig

S = "${WORKDIR}/git"

# SRCREV = "e8ac9f2a9a88ce6551f131967a40b39680dd22b6"
SRCREV = "e8ac9f2a9a88ce6551f131967a40b39680dd22b6"

DEPENDS = "\
    everest-cmake \
    libfsm \
    libcbv2g \
    evcli-native \
"

# Yocto disables network features after do_fetch, so force using them in subsequent tasks
do_configure[network] = "1"
do_compile[network] = "1"
do_install[network] = "1"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"

do_install:prepend() {
    # this "hack" fixes an error regarding the fetched MbedTLS 3.5, not recommended
    git config --global --add safe.directory '*'
}

do_install:append() {
    # libiso15118 depends "privately" on MbedTLS 3.5, so theoritcally everest-core, which depends on libiso15118, should not look for
    # MbedTLS 3.5 and should not try linking to it. However, this is not the case, as everest-core and while building the D20Evse module
    # in Yocto tries to find the components mbedtls*_custom. So install these libraries for everest-core to find them.
    install -d ${D}${libdir}
    install -m 0644 ${WORKDIR}/build/3rd_party/mbedtls/custom_mbedtls-build/library/libmbedtls.a ${D}${libdir}/libmbedtls_custom.a
    install -m 0644 ${WORKDIR}/build/3rd_party/mbedtls/custom_mbedtls-build/library/libmbedcrypto.a ${D}${libdir}/libmbedcrypto_custom.a
    install -m 0644 ${WORKDIR}/build/3rd_party/mbedtls/custom_mbedtls-build/library/libmbedx509.a ${D}${libdir}/libmbedx509_custom.a
}
