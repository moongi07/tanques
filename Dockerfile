FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/practica-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_practica.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app_practica.jar"]