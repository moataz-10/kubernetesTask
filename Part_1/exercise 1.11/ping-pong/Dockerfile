FROM openjdk:25-slim-bullseye
EXPOSE 8080

WORKDIR /app

ADD target/ping-pong-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java","-jar", "/app/app.jar"]