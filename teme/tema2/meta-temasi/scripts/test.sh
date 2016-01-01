#!/bin/bash

tcpdump -ni any > /var/log/temasi.log | tail -f /var/log/temasi.log | egrep "^[0-9][0-9]" | /home/user/poky/meta-temasi/recipes/scripts/scripts/support-script
