FROM openjdk:25-slim-bullseye

EXPOSE 8080
WORKDIR /app

# Add the application JAR
ADD target/logapp-0.0.1-SNAPSHOT.jar /app/app.jar

# Create the 'shared' directory and the 'information.txt' file inside it
RUN mkdir -p /app/shared
RUN touch /app/shared/information.txt

# Set the entry point for the application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
