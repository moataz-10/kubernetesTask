# Use a valid OpenJDK base image
FROM openjdk:17-slim-bullseye

# Set the working directory inside the container
WORKDIR /app

# Copy all project files to the container
COPY . .

ADD /shared/timestamp.txt /shared/timestamp.txt

# Compile the Java application
RUN javac src/Main.java

# Set the default command to run the Java application
CMD ["java", "-cp", "src", "Main"]
