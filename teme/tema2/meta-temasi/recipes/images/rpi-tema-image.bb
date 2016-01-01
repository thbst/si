require recipes-core/images/rpi-basic-image.bb


IMAGE_INSTALL += "avahi-daemon hello lsof libpcap tcpdump scripts mailx"

inherit extrausers
EXTRA_USERS_PARAMS = "usermod -P labsi root;"

hostname_pn-base-files = "temasi"
