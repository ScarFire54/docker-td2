FROM openjdk:20-slim

# Copiez le fichier de construction Gradle et les dépendances
COPY build.gradle gradlew gradlew.bat app/
COPY gradle app/gradle
COPY src app/src


WORKDIR /app

RUN apt-get update && \
    apt-get install dos2unix && \
    apt-get clean
RUN dos2unix gradlew
RUN chmod +x gradlew
RUN ./gradlew build

EXPOSE 8081

RUN rm -rf build/libs/*.original


FROM eclipse-temurin:17-jre-ubi9-minimal

COPY --from=0 /app/build/libs/app-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

CMD ["java", "-jar", "app.jar"]