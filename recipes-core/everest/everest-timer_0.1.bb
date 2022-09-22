LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libtimer.git;protocol=https;branch=main"

inherit cmake

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
PV = "0.1+git${SRCPV}"

DEPENDS = "\
    everest-cmake \
    boost \
    date \
"

EXTRA_OECMAKE += " \
    -DDISABLE_EDM=ON \
    -DBUILD_EXAMPLES=OFF \
"
