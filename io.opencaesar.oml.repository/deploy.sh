#!/bin/bash

git config user.name "Travis CI"
git config user.email "melaasar@gmail.com"

# Now that we're all set up, we can push.
mvn deploy -Prelease-composite -Dgithub-update-repo=https://x-access-token:${GITHUB_API_KEY}@github.com/opencaesar/oml-p2