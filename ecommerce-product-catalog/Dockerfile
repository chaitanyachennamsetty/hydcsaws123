# -------- Build stage --------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy pom.xml and download dependencies
COPY app/pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code and build
COPY app/src ./src
RUN mvn clean package -DskipTests

# -------- Runtime stage --------
FROM eclipse-temurin:17-jre
WORKDIR /opt/app

# Copy fat JAR (executable Spring Boot jar)
COPY --from=build /app/target/catalog-1.0.0.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

