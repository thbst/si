DESCRIPTON = "Startup scripts"
#LICENSE = "MIT"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
hostname="tema2.local"



RDEPENDS_${PN}="libpcap tcpdump logrotate"
PR = "r0"

SRC_URI = "              \
   file://startup-script \
   file://run-script     \
   file://support-script \
   "

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -d ${D}${sysconfdir}/rcS.d
    install -d ${D}${sysconfdir}/rc1.d
    install -d ${D}${sysconfdir}/rc2.d
    install -d ${D}${sysconfdir}/rc3.d
    install -d ${D}${sysconfdir}/rc4.d
    install -d ${D}${sysconfdir}/rc5.d
    install -d ${D}${sbindir}

    install -m 0755 ${WORKDIR}/startup-script  ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/run-script      ${D}${sysconfdir}/init.d/
    install -m 0755 ${WORKDIR}/support-script  ${D}${sbindir}/

    ln -sf ../init.d/startup-script  ${D}${sysconfdir}/rcS.d/S90startup-script
    ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc1.d/K90run-script
    ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc2.d/K90run-script
    ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc3.d/K90run-script
    ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc4.d/K90run-script
    ln -sf ../init.d/run-script      ${D}${sysconfdir}/rc5.d/S90run-script
}
