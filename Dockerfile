# Usamos una imagen oficial de OpenJDK 21 ligera basada en Alpine
FROM eclipse-temurin:21-jdk-alpine AS build

# Establecemos el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos los archivos de Maven/Gradle y el código fuente
COPY . .

# Empaquetamos la aplicación usando Maven (saltándonos las pruebas para agilizar)
RUN ./mvnw clean package -DskipTests

# Creamos la imagen final más ligera solo para ejecutar el .jar
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiamos el archivo .jar generado desde la fase de construcción
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto 8080 donde corre Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación cuando encienda el contenedor
ENTRYPOINT ["java", "-jar", "app.jar"]