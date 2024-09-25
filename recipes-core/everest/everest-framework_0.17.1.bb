LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-framework.git;branch=main;protocol=https \
           file://0001-Set-PYTHON_MODULE_EXTENSION-to-.so-to-avoid-pollutin.patch \
           "

inherit python3native
inherit cmake
inherit pkgconfig

S = "${WORKDIR}/git"

SRCREV = "12e1cc974b6fc9a9e58760605a55f5dd72f816d2"

# FIXME (aw): due to nodejs dependency
do_configure[network] = "1"

DEPENDS = "\
    everest-cmake \
    boost \
    websocketpp \
    nlohmann-json \
    json-schema-validator \
    mqttc \
    liblog \
    fmt \
    date \
    catch2 \
    nodejs-native \
    rapidyaml \
    libwebsockets \
    python3-pybind11 \
    python3-pybind11-json \
    libcap \
"

FILES:${PN} += "${libdir}/everest/* ${datadir}/everest/*"

EXTRA_OECMAKE += "\
    -DDISABLE_EDM=ON \
    -DNO_FETCH_CONTENT=ON \
    -DPYTHON_MODULE_EXTENSION=.so \
    -DPYBIND11_PYTHONLIBS_OVERWRITE=OFF \
    -DEVEREST_INSTALL_ADMIN_PANEL=OFF \
"
