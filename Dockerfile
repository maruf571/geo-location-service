FROM openjdk:8-jdk-alpine
COPY target/*.jar /opt/app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=prod", "-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]
