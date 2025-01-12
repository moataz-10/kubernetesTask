# Use a valid OpenJDK base image
FROM openjdk:17-slim-bullseye

# Set the working directory inside the container
WORKDIR /app

# Copy all project files to the container
COPY . .

# Compile the Java application during the build stage
RUN javac src/Main.java

# Set the default command to run the Java application
CMD ["java", "-cp", "src", "Main"]
