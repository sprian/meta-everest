LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libocpp.git;branch=main;protocol=https \
           "

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "77f5b2a6181d94c2e94af790e4c5e61435f0b919"

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
