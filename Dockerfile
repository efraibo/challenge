FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM java:8
LABEL maintainer=“efraibo@gmail.com”
WORKDIR /app
COPY target/challenge-0.0.1-SNAPSHOT.jar /app/challenge.jar
ENTRYPOINT ["java","-jar","challenge.jar"]