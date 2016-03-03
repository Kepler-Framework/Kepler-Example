#!/bin/bash
java -server -Xmx1G -Xms1G -XX:+PrintGCDetails -classpath pressure.jar main.Client
