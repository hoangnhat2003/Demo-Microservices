FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/warehouse-service

COPY ${JAR_FILE} /opt/warehouse-service/warehouse-service.jar

ENTRYPOINT ["java","-jar","/opt/warehouse-service/warehouse-service.jar"]