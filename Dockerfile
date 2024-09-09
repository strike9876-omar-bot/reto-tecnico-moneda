# Establece la imagen base de Java
FROM openjdk:17-jdk

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de la aplicación al contenedor
COPY target/prueba-0.0.1-SNAPSHOT.jar .

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "prueba-0.0.1-SNAPSHOT.jar"]