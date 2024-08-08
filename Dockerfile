# Usa la imagen base de OpenJDK 22
FROM openjdk:22-jdk

# Configura el directorio de trabajo en el contenedor
WORKDIR /app



# Expone el puerto en el que la aplicación estará escuchando
EXPOSE 50600

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "ms-dockerization-2.jar"]
