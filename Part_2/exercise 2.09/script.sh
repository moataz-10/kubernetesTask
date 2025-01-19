#!/bin/sh

URL=$(curl -s -I https://en.wikipedia.org/wiki/Special:Random | grep -i location | awk '{print $2}' | tr -d '\r')

# Send the task to the backend
curl -X POST "$BACKEND_URL" \
  -H "Content-Type: text/plain" \
  -d "Read $URL"

