FROM openjdk:11
EXPOSE 8080
WORKDIR application
ARG JAR_FILE=target/*.jar
ADD ${JAR_FILE} application.jar
ENTRYPOINT ["java","-jar","application.jar"]
