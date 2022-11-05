#!/bin/bash
printf $1 > version.txt
mvn org.eclipse.tycho:tycho-versions-plugin:2.7.5:set-version -DnewVersion=$1