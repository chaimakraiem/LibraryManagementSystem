# Use an official Ubuntu image as a base
FROM ubuntu:20.04

# Label the author of the image
LABEL maintainer="chaimakraiem <chaima.kraiem@polytechnicien.tn>"

# Install .NET SDK
RUN apt-get update \
    && apt-get install -y --no-install-recommends \
       wget \
       software-properties-common \
    && wget https://packages.microsoft.com/config/ubuntu/20.04/packages-microsoft-prod.deb -O packages-microsoft-prod.deb \
    && dpkg -i packages-microsoft-prod.deb \
    && apt-get update \
    && apt-get install -y --no-install-recommends \
       apt-transport-https \
       dotnet-sdk-3.1 \
    && rm -rf /var/lib/apt/lists/* \
    && rm packages-microsoft-prod.deb

# Install other dependencies
RUN apt-get update \
    && apt-get install -y --no-install-recommends \
       logrotate

# Create a directory for your application
WORKDIR /app

# Copy the application files into the container
COPY . /app

# Expose the port on which your application will run
EXPOSE 80

