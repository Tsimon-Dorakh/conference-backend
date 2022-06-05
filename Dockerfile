FROM openjdk:11.0-jre

ARG JAR_FILE=build/libs/conference-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
