LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/libcbv2g.git;protocol=https;branch=main \
           "

# Modify these as desired
PV = "0.1.0+git${SRCPV}"
SRCREV = "ec437e6060e30bfa2850139c87a10c3f61f546a0"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS = "everest-cmake"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
# EXTRA_OECMAKE = ""

