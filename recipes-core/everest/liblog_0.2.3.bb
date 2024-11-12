LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/liblog.git;branch=main;protocol=https"

inherit cmake

DEPENDS = "\
    everest-cmake \
    boost \
"

S = "${WORKDIR}/git"

SRCREV = "763a56a4bf194e7cf1cab7446e993c376ce933fa"

FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += " \
    -DCMAKE_POSITION_INDEPENDENT_CODE=ON \
"
