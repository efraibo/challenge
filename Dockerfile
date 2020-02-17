FROM java:8
LABEL maintainer=“efraibo@gmail.com”
WORKDIR /app
COPY target/challenge-0.0.1-SNAPSHOT.jar /app/challenge.jar
ENTRYPOINT ["java","-jar","challenge.jar"]