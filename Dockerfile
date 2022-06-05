FROM 484726675287.dkr.ecr.eu-central-1.amazonaws.com/openjdk:11.0-jre

ARG JAR_FILE=build/libs/conference-backend-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
