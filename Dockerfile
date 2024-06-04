#Build stage
FROM ringcentral/maven:4.0.0-jdk17 as build
COPY . .
RUN mvn clean package
#Package
FROM eclipse-temurin:17-jfk-alpine
COPY --from=build target/oceanguard-0.0.1-snapshot.jar /opt/oceanguard.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/opt/oceanguard.jar"]