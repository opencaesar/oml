#!/bin/bash
#Sample Usage: pushUpdateSiteToBintray.sh version
API=https://api.bintray.com
CURRENT_PATH=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
BINTRAY_OWNER=opencaesar
BINTRAY_REPO=p2
PCK_NAME=oml
PCK_VERSION=$(cat ${CURRENT_PATH}/../version.txt)
TARGET_PATH=oml/releases
PATH_TO_REPOSITORY=${CURRENT_PATH}/target/repository

function main() {
	deploy_updatesite
}

function deploy_updatesite() {
	echo "${BINTRAY_OWNER}"
	echo "${BINTRAY_REPO}"
	echo "${PCK_NAME}"
	echo "${PCK_VERSION}"
	echo "${TARGET_PATH}"
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
	  echo "Processing $f file..."
	  echo "Uploading p2 metadata file directly to the repository"
	  curl -X PUT -T $f -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${TARGET_PATH}/${PCK_VERSION}/$f;publish=1
	  echo ""
	fi
	done
	
	echo "Processing features dir $FEATUREDIR file..."
	for f in $FEATUREDIR;
	do
	  echo "Processing feature: $f file..."
	  curl -X PUT -T $f -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/${PCK_VERSION}/${TARGET_PATH}/${PCK_VERSION}/$f;publish=1
	  echo ""
	done
	
	echo "Processing plugin dir $PLUGINDIR file..."
	
	for f in $PLUGINDIR;
	do
	   # take action on each file. $f store current file name
	  echo "Processing plugin: $f file..."
	  curl -X PUT -T $f -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/${PCK_VERSION}/${TARGET_PATH}/${PCK_VERSION}/$f;publish=1
	  echo ""
	done
	
	#echo "Publishing the new version"
	#curl -X POST -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/${PCK_VERSION}/publish -d "{ \"discard\": \"false\" }"
}


main "$@"
