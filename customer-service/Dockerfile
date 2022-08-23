FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/customer-service

COPY ${JAR_FILE} /opt/customer-service/customer-service.jar

ENTRYPOINT ["java","-jar","/opt/customer-service/customer-service.jar"]