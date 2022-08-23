FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/order-service

COPY ${JAR_FILE} /opt/order-service/order-service.jar

ENTRYPOINT ["java","-jar","/opt/order-service/order-service.jar"]