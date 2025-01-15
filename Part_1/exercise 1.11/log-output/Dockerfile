FROM openjdk:25-slim-bullseye
EXPOSE 8080
WORKDIR /app

ADD target/log-output-0.0.1-SNAPSHOT.jar /app/app.jar

RUN mkdir -p shared && touch shared/file.txt


ENTRYPOINT ["java","-jar", "/app/app.jar"]