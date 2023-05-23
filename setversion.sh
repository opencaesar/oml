#!/bin/bash
if [[ $# -eq 0 ]]; then
  echo "Usage: $0 <version>"
  exit 1
fi

version="$1"

printf $version > version.txt
mvn org.eclipse.tycho:tycho-versions-plugin:2.7.5:set-version -DnewVersion=$1
sed -i '' "s/Title: Ontological Modeling Language.*/Title: Ontological Modeling Language $version/" io.opencaesar.oml.specification/src/index.bs