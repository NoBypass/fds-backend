FROM openjdk:17-jdk-slim

WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY gradlew .
COPY gradle/ gradle/

COPY src/ src/

RUN ./gradlew build

COPY build/libs/fds.jar .

EXPOSE 8080:8080

ENTRYPOINT ["java", "-jar", "fds.jar"]
