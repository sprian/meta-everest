SUMMARY = "packaging: Core utilities for Python packages"

HOMEPAGE = "https://github.com/pypa/packaging"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=faadaedca9251a90b205c9167578ce91"

SRC_URI[sha256sum] = "dd47c42927d89ab911e606518907cc2d3a1f38bbd026385970643f9c5b8ecfeb"

PYPI_PACKAGE = "packaging"

inherit pypi setuptools3
