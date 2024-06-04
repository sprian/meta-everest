LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libocpp.git;branch=main;protocol=https \
           "

inherit cmake

S = "${WORKDIR}/git"

# tag 0.12.0
SRCREV = "9a19d29bd780d65c3ff15951427bf53e8fe33b88"

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
