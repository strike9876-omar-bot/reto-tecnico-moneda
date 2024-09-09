Para presentar adecuadamente la información sobre cómo construir y ejecutar tu aplicación usando Maven y Docker en un archivo `README.md` de GitHub, es crucial estructurar el contenido de manera clara y legible. Aquí te muestro cómo podrías redactar y formatear tu `README.md` para que sea más amigable para los usuarios:

---

# ms-prueba-tecnica

Este repositorio contiene una aplicación de ejemplo que se ejecuta localmente en el puerto 8080 y puede ser contenerizada usando Docker.

## Requisitos
Antes de comenzar, asegúrate de tener instalado lo siguiente:
- Java 8 o superior
- Maven
- Docker

## Construcción del Proyecto

Para construir el proyecto y generar el archivo JAR, utiliza el siguiente comando Maven en la raíz del proyecto:

```bash
mvn clean package
```

Este comando limpiará el proyecto (eliminando compilaciones anteriores) y empaquetará la aplicación en un archivo JAR ubicado en el directorio `target/`.

## Construcción de la Imagen Docker

Una vez que el JAR ha sido generado, puedes construir la imagen Docker con el siguiente comando:

```bash
docker build -t my-application:1.0 .
```

Este comando construye una imagen Docker etiquetada como `my-application:1.0` utilizando el `Dockerfile` en el directorio raíz del proyecto.

## Ejecución del Contenedor Docker

Para ejecutar la aplicación dentro de un contenedor Docker, utiliza el siguiente comando:

```bash
docker run -p 8080:8080 my-application:1.0
```

Este comando ejecutará el contenedor Docker mapeando el puerto 8080 del host al puerto 8080 del contenedor, permitiendo acceder a la aplicación desde el navegador en `http://localhost:8080`.

---

## Prueba Local

Puedes acceder a la aplicación localmente visitando `http://localhost:8080` en tu navegador después de iniciar el servidor Java o el contenedor Docker.

---

Este formato proporciona una estructura clara y directa que ayuda a los usuarios a entender cómo construir, desplegar y acceder a la aplicación. También es una buena práctica incluir secciones adicionales en el `README.md` como 'Pruebas', 'Desarrollo', y 'Contribución' si el proyecto es colaborativo o más complejo.