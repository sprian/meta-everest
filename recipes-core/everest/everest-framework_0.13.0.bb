LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/EVerest/everest-framework.git;branch=main;protocol=https"

inherit python3native
inherit cmake
inherit pkgconfig

S = "${WORKDIR}/git"

# tag v0.13.0
SRCREV = "d4ca48fe2aa22611183aed03c4843def4343c748"

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

# we need to set PYTHON_INCLUDE_DIRS explicity, otherwise the host python is found
EXTRA_OECMAKE += "\
    -DDISABLE_EDM=ON \
    -DNO_FETCH_CONTENT=ON \
    -DPYTHON_MODULE_EXTENSION=.so \
    -DPYBIND11_PYTHONLIBS_OVERWRITE=OFF \
    -DEVEREST_INSTALL_ADMIN_PANEL=OFF \
    -DPYTHON_INCLUDE_DIRS="${STAGING_INCDIR}/${PYTHON_DIR}${PYTHON_ABI}" \
"
