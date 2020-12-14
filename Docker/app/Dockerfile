FROM openjdk:11
ARG JAR_FILE=target/*.jar
COPY *.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
