FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/transfer-service-1.0.0.jar transfer-service.jar
ENTRYPOINT ["java","-jar","/transfer-service.jar"]