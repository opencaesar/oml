#!/bin/bash
printf $1 > version.txt
mvn org.eclipse.tycho:tycho-versions-plugin:set-version -DnewVersion=$1