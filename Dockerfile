# Используем образ с Java 17
FROM eclipse-temurin:17-jdk-alpine

# Создаем директорию для приложения
WORKDIR /app

# Копируем исходный код в образ
COPY src ./src
COPY pom.xml .

# Собираем приложение с помощью Maven
RUN ./mvnw clean package

# Копируем собранный jar-файл в образ
COPY target/*.jar app.jar

# Открываем порт 8081
EXPOSE 8081

# Запускаем приложение с помощью Java
ENTRYPOINT ["java","-jar","/app.jar"]