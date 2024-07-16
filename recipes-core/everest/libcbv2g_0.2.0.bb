LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libcbv2g.git;branch=main;protocol=https \
           "

inherit cmake

S = "${WORKDIR}/git"

# tag 0.2.0
SRCREV = "ec437e6060e30bfa2850139c87a10c3f61f546a0"

DEPENDS = "\
    everest-cmake \
"

# FILES:${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON -DCB_V2G_INSTALL=ON -DCB_V2G_BUILD_TESTS=OFF"
