FROM openjdk:17-jdk-slim
WORKDIR /app
COPY build/libs/account-app.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]docker