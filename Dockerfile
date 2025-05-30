# Usar Java 21 (compatible con tu pom.xml)
FROM openjdk:21-jdk-slim

# Instalar herramientas necesarias
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

WORKDIR /app

# Copiar archivos de Maven wrapper
COPY mvnw .
COPY .mvn/ .mvn/

# Copiar pom.xml para descargar dependencias primero (cache layer)
COPY pom.xml .

# Dar permisos ejecutables al wrapper
RUN chmod +x ./mvnw

# Descargar dependencias (esto se cachea si pom.xml no cambia)
RUN ./mvnw dependency:go-offline -B

# Copiar código fuente
COPY src/ ./src/

# Compilar la aplicación
RUN ./mvnw clean package -DskipTests -B

# Exponer el puerto 8080 (puerto por defecto de Spring Boot)
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "target/Vuelos-0.0.1-SNAPSHOT.jar"]