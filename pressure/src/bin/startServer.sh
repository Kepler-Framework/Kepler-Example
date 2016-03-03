#!/bin/bash
if test ! -e sid ; then
echo $HOSTNAME`pwd` | md5sum | awk '{print $1}' > sid;
fi
java -server -Xmx1G -Xms1G -XX:+PrintGCDetails -Dcom.kepler.host.impl.serverhost.sid=`cat sid` -classpath pressure.jar main.Server
