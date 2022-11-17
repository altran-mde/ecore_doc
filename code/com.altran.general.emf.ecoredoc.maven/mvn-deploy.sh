#!/bin/bash

BASE_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

IFS=$'\n'
for POM_FILE in $(find "${BASE_DIR}/repository" -name "*.pom"); do
    POM_DIR=$(dirname "${POM_FILE}")
    POM_NAME=$(basename "${POM_FILE}" ".pom")
    echo "Deploying ${POM_NAME}"
done