FROM openjdk:8-jre-alpine

EXPOSE 8080

WORKDIR /app

COPY target/user-data-operator-application-0.0.1-SNAPSHOT.jar .

ENTRYPOINT [ "java", "-jar", "user-data-operator-application-0.0.1-SNAPSHOT.jar" ]