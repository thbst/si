#!/bin/bash
if [ `whoami` != "root" ]
	then
	echo "[ERROR] user is not root, please run again this script as root"
	exit
fi

qemu-system-arm -machine versatilepb -cpu arm1176 -kernel /home/user/poky/meta-temasi/kernel/zImage -append "root=/dev/sda rw console=ttyAMA0 console=tty1" -serial stdio -net nic,model=smc91c111,netdev=net0 -netdev bridge,br=virbr0,id=net0 -hda /home/user/poky/build/tmp/deploy/images/raspberrypi/rpi-tema-image-raspberrypi.ext3

