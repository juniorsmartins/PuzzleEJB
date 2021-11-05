#!/bin/sh
mvn clean package && docker build -t br.com/PuzzleEjb .
docker rm -f PuzzleEjb || true && docker run -d -p 9080:9080 -p 9443:9443 --name PuzzleEjb br.com/PuzzleEjb