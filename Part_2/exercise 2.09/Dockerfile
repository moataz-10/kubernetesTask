# Use Alpine Linux as the base image
FROM alpine:latest

# Install required tools: curl and bash
RUN apk add --no-cache curl bash

# Copy the script to the container
COPY script.sh /script.sh

# Ensure the script has executable permissions
RUN chmod +x /script.sh

# Set the script as the default entrypoint
ENTRYPOINT ["/script.sh"]
