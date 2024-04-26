LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libocpp.git;branch=main;protocol=https \
           file://0001-Install-3rd-party-headers.patch \
           "

inherit cmake

S = "${WORKDIR}/git"

# tag 0.11.0
SRCREV = "c0f942ee267e1cac92ff4ce162384afdee01e977"

DEPENDS = "\
    everest-cmake \
    boost \
    sqlite3 \
    openssl \
    libwebsockets \
    nlohmann-json \
    json-schema-validator \
    libfsm \
    liblog \
    libtimer \
    libevse-security \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
