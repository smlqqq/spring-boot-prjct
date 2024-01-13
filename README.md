# Spring Boot Application

## О проекте

Это простое веб-приложение, которое использует Spring Boot, Spring Data JPA, Spring Security, Thymeleaf и PostgreSQL для реализации функционала базы данных о пациентах больницы. Приложение позволяет входить в систему. Приложение также поддерживает роли пользователей (администратор,пользователь) и разграничение доступа к различным страницам и действиям в зависимости от роли.

## Стэк Технологии

- Spring Boot 2.5.6
- Spring Data JPA
- Spring Security
- Thymeleaf
- PostgreSQL
- Bootstrap
- Maven
- Prometheus
- Grafana
- Docker

## Запуск приложения

Для запуска приложения вам понадобится:

- Java 11 или выше
- PostgreSQL 13 или выше
- Maven 3.8.3 или выше

Перед запуском приложения вам нужно создать базу данных в PostgreSQL с именем `spring_boot_prjct` и пользователем `postgres` с паролем `postgres`. Вы можете изменить эти настройки в файле `src/main/resources/application.properties`.

Для запуска приложения выполните следующие команды в терминале:

```shell
git clone https://github.com/smlqqq/spring-boot-prjct.git
cd spring-boot-prjct
mvn spring-boot:run

После запуска приложения вы можете открыть его в браузере по адресу: http://localhost:8081/








