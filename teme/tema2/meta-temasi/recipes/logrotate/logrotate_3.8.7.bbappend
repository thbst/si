FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
hostname="tema2.local"

SRC_URI += "file://ids"

RDEPENDS_${PN}="logrotate"

do_install_append () {
    install -m 0644 ${WORKDIR}/ids ${D}${sysconfdir}/logrotate.d/ids
}
