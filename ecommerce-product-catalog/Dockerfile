FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY app/pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY app/src ./src
RUN mvn -q -DskipTests package

FROM eclipse-temurin:17-jre
WORKDIR /opt/app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
