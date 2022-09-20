FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/finance-service

COPY ${JAR_FILE} /opt/finance-service/finance-service.jar

ENTRYPOINT ["java","-jar","/opt/finance-service/finance-service.jar"]