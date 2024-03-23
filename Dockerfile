FROM eclipse-temurin:17

WORKDIR /app

COPY build.gradle .
COPY settings.gradle .
COPY gradle ./gradle
COPY gradlew .

COPY src ./src

ENV DOCKER_ENV true
ENV GRADLE_OPTS="-Dorg.gradle.daemon.id=hot-reload-docker"

CMD ["./gradlew", "bootRun", "--no-daemon"]
