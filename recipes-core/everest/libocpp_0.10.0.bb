LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libocpp.git;branch=main;protocol=https"

inherit cmake

S = "${WORKDIR}/git"

# tag 0.10.0
SRCREV = "e1ae0bcdb7d4bbfc980f3056f91b8e129147c204"

DEPENDS = "\
    everest-cmake \
    boost \
    sqlite3 \
    openssl \
    websocketpp \
    nlohmann-json \
    json-schema-validator \
    libfsm \
    liblog \
    libtimer \
    libevse-security \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
