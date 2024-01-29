FROM openjdk:17-jdk
ARG JAR_FILE=builds/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "app.jar"]