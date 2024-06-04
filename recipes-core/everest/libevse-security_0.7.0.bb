LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libevse-security.git;branch=main;protocol=https \
           "

inherit cmake

S = "${WORKDIR}/git"

# tag 0.7.0
SRCREV = "1ee9a962c49d22ea4a46c84ab9d51ebf80345e6e"

DEPENDS = "\
    date \
    everest-cmake \
    liblog \
    libtimer \
    openssl \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DEVSE_SECURITY_INSTALL=ON -DLIBEVSE_SECURITY_BUILD_TESTING=OFF"
