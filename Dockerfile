FROM eclipse-temurin:11-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "target/journalApp-0.0.1-SNAPSHOT.jar"]