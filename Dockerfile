FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#FROM java:8
#LABEL maintainer=“efraibo@gmail.com”
#WORKDIR /app
#COPY target/challenge-0.0.1-SNAPSHOT.jar /app/challenge.jar
#ENTRYPOINT ["java","-jar","challenge.jar"]

FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8082
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/challenge-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]