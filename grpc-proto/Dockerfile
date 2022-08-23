FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

RUN mkdir /opt/grpc-proto

COPY ${JAR_FILE} /opt/grpc-proto/grpc-proto.jar

ENTRYPOINT ["java","-jar","/opt/grpc-proto/grpc-proto.jar"]