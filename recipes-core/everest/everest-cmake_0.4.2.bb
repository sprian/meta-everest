LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-cmake.git;branch=main;protocol=https"

SRCREV = "d8d5e37d3f4a21ff136cc640ca68da2a5c8b62bc"

S = "${WORKDIR}/git"

do_install() {
    install -d ${D}/usr/lib/cmake/everest-cmake
    cp -a --no-preserve=ownership ${S}/*.cmake ${D}/usr/lib/cmake/everest-cmake/
    cp -a --no-preserve=ownership ${S}/3rd_party ${D}/usr/lib/cmake/everest-cmake/
    cp -a --no-preserve=ownership ${S}/assets ${D}/usr/lib/cmake/everest-cmake/
}
