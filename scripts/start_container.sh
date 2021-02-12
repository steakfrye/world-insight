#!/usr/bin/env bash

set -e

/usr/local/bin/docker-compose -f docker-compose-aws.yml up -d > /dev/null 2> /dev/null < /dev/null &