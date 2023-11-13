# Utilisez une image de base avec Java 17
FROM adoptopenjdk/openjdk17:latest

# Copiez le fichier de construction Gradle et les dépendances
COPY backend/build.gradle settings.gradle /backend/
COPY backend/gradle /app/gradle
COPY backend/src /backend/src

# Définissez le répertoire de travail
WORKDIR /backend

# Exécutez la construction Gradle
RUN ./gradlew build

# Exposez le port sur lequel votre application Spring Boot fonctionne (par exemple, 8080)
EXPOSE 8080

# Commande pour lancer l'application
CMD ["java", "-jar", "build/libs/backend.jar"]