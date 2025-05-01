# Etapa de build com Java 21
FROM eclipse-temurin:21-jdk AS builder

WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa de execução com Java 21 (JRE)
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
