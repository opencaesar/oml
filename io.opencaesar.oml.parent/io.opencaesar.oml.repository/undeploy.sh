#!/bin/bash
#Sample Usage: deleteUpdateSiteFromBintray.sh version
API=https://api.bintray.com
BINTRAY_OWNER=opencaesar
BINTRAY_REPO=p2
PCK_NAME=oml
PCK_VERSION=$1
TARGET_PATH=oml/releases
CURRENT_PATH=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
PATH_TO_REPOSITORY=${CURRENT_PATH}/target/repository

function main() {
	if [ ! -d $PCK_VERSION ]; then
		deploy_updatesite
	else
		echo "Usage: ./undeploy.sh <version>"
	fi
}

function deploy_updatesite() {
	echo "${BINTRAY_USER}"
	echo "${BINTRAY_API_KEY}"
	echo "${BINTRAY_OWNER}"
	echo "${BINTRAY_REPO}"
	echo "${PCK_NAME}"
	echo "${PCK_VERSION}"
	echo "${PATH_TO_REPOSITORY}"
	
	if [ ! -z "$PATH_TO_REPOSITORY" ]; then
	   cd $PATH_TO_REPOSITORY
	   if [ $? -ne 0 ]; then
	     #directory does not exist
	     echo $PATH_TO_REPOSITORY " does not exist"
	     exit 1
	   fi
	fi
	
	
	FILES=./*
	PLUGINDIR=./plugins/*
	FEATUREDIR=./features/*
	
	for f in $FILES;
	do
	if [ ! -d $f ]; then
	  echo "Deleting $f file..."
	  curl -X DELETE -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${TARGET_PATH}/${PCK_VERSION}/$f
	  echo ""
	fi
	done
	
	echo "Processing features dir $FEATUREDIR file..."
	for f in $FEATUREDIR;
	do
	  echo "Deleting feature: $f file..."
	  curl -X DELETE -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${TARGET_PATH}/${PCK_VERSION}/$f
	  echo ""
	done
	
	echo "Processing plugin dir $PLUGINDIR file..."
	for f in $PLUGINDIR;
	do
	   # take action on each file. $f store current file name
	  echo "Deleting plugin: $f file..."
	  curl -X DELETE -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${TARGET_PATH}/${PCK_VERSION}/$f
	  echo ""
	done

	echo "Deleting version: ${PCK_VERSION}"
	curl -X DELETE -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/packages/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/versions/${PCK_VERSION}
}

main "$@"