FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/product-service

COPY ${JAR_FILE} /opt/product-service/product-service.jar

ENTRYPOINT ["java","-jar","/opt/product-service/product-service.jar"]