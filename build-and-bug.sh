#!/usr/bin/env bash

set -ex

./gradlew clean test build --info

# Start Server
java -jar build/libs/bug-demo-0.1-all.jar --server

# Send Request
java -jar build/libs/bug-demo-0.1-all.jar test
