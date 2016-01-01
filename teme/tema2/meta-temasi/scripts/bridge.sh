#/bin/bash

if [ `whoami` != "root" ]
	then
	echo "user is not root"
	exit
fi

brctl addbr virbr0
brctl addif virbr0 eth0
ifconfig eth0 0.0.0.0
dhclient virbr0
if [ "`grep -q virbr0 /etc/qemu/bridge.conf; echo $?i`" == "1" ] 
	then
	echo "allow virbr0" >> /etc/qemu/bridge.conf
fi
