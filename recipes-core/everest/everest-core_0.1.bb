LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-core.git;protocol=https;branch=main \
           file://0001-disable-ocpp.patch \
           file://0004-disable-js-modules.patch \
           file://0008-disable-persistent-store.patch \
           "

inherit cmake

DEPENDS = " \
    everest-cmake \
    boost \
    sigslot \
    pugixml \
    evcli-native \
    rsync-native \
    nodejs-native \
    everest-framework \
    everest-fsm \
    everest-log \
    everest-modbus \
    everest-sunspec \
    everest-slac \
    everest-timer \
"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"
PV = "0.1+git${SRCPV}"

INSANE_SKIP_${PN} = "already-stripped useless-rpaths arch file-rdeps"

FILES_${PN} += "${datadir}/everest/*"

EXTRA_OECMAKE += "-DDISABLE_EDM=ON "
