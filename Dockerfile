
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/EstetiTurnos-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} EstetiTurnos.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","EstetiTurnos.jar"]