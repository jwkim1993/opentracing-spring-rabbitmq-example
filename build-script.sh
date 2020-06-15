#!/bin/bash

if [ $# -ne 1 ]; then
  echo 'Usage: ./build-script.sh {image-version}'
fi

./gradlew build

if [ $? -ne 0 ]; then
  echo 'Build failed\n'
  exit $?
fi

docker build -t ${REGISTRY_ADDR}/rabbitmq-consumer:$1 rabbitmq-consumer/. --no-cache
docker build -t ${REGISTRY_ADDR}/rabbitmq-producer:$1 rabbitmq-producer/. --no-cache

docker push ${REGISTRY_ADDR}/rabbitmq-consumer:$1
docker push ${REGISTRY_ADDR}/rabbitmq-producer:$1
