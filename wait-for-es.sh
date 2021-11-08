#!/bin/sh
# wait-for-es.sh

set -e
  
until curl -u $ES_USER:$ES_PASSWORD $ES_HOST:$ES_PORT ; do
  >&2 echo "elastic search is unavailable - sleeping"
  sleep 1
done
  
>&2 echo "Elastic search is up - executing command"
exec "$@"