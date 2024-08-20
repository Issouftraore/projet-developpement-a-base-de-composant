# Étape 1 : Construire l'application
FROM maven:3.8.5-openjdk-17 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

# Étape 2 : Construire l'image finale
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/projectDABC-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
