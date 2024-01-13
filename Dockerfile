# FROM eclipse-temurin:17-jdk-alpine
# VOLUME /tmp
# COPY target/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]
# EXPOSE 8081



FROM openjdk:11-jre-slim


WORKDIR /app


COPY target/*.jar app.jar


EXPOSE 8081

CMD ["java", "-jar", "app.jar"]
