#!/bin/bash

# Get the current path
CURRENT_PATH=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )
echo $CURRENT_PATH

# Get the deploy key by using Travis's stored variables to decrypt deploy_key.enc
ENCRYPTED_KEY_VAR="encrypted_${ENCRYPTION_LABEL}_key"
ENCRYPTED_IV_VAR="encrypted_${ENCRYPTION_LABEL}_iv"
ENCRYPTED_KEY=${!ENCRYPTED_KEY_VAR}
ENCRYPTED_IV=${!ENCRYPTED_IV_VAR}
openssl aes-256-cbc -K $ENCRYPTED_KEY -iv $ENCRYPTED_IV -in ${CURRENT_PATH}/deploy_key.enc -out ${CURRENT_PATH}/deploy_key -d
chmod 600 ${CURRENT_PATH}/deploy_key
eval `ssh-agent -s`
ssh-add ${CURRENT_PATH}/deploy_key

# Now that we're all set up, we can push.
mvn deploy -Prelease-composite