# Etapa 1: build do Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /build

# Copia o pom.xml e o código fonte
COPY pom.xml .
COPY src ./src

# Compila o projeto, gerando o JAR
RUN mvn clean package -DskipTests

# Etapa 2: imagem final leve
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copia o JAR gerado da etapa anterior
COPY --from=builder /build/target/*.jar app.jar

# Exponha a porta do Spring Boot
EXPOSE 8080

# Define como executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
