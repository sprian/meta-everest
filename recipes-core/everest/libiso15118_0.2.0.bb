LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libiso15118.git;branch=main;protocol=https \
           "

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "15bd77c324f17512bbb74d8dd26748229951e263"

DEPENDS = "\
    everest-cmake \
    libcbv2g \
    libfsm \
"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON"
