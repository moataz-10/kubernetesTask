FROM openjdk:25-slim-bullseye
EXPOSE 8080

WORKDIR /app

ADD target/pingpong-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java","-jar", "/app/app.jar"]