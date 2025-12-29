🧑‍💻 Portafolio de Proyectos – Java & Desarrollo Web

Este repositorio reúne proyectos desarrollados como práctica académica y portafolio personal, enfocados en el aprendizaje y aplicación de Java, bases de datos y desarrollo web.

Los proyectos aquí presentados demuestran habilidades en:

Programación orientada a objetos

Desarrollo backend con Java y Spring Boot

Integración con bases de datos MySQL

Desarrollo frontend básico (HTML y CSS)

Uso de Git y GitHub como control de versiones

📂 Proyectos incluidos
📌 1. CRUD de Personas – Spring Boot & MySQL

Aplicación web desarrollada en Java con Spring Boot, que permite registrar, listar, editar y eliminar personas, validando reglas de negocio como la no repetición de correos electrónicos ni números de celular.

🚀 Funcionalidades

✅ Registrar personas

✅ Listar personas registradas

✅ Editar información

✅ Eliminar personas con confirmación

❌ No permite correos duplicados

❌ No permite números de celular duplicados

📢 Mensajes de éxito y error al usuario

🔄 Persistencia automática en base de datos MySQL

🛠️ Tecnologías utilizadas

Java 21

Spring Boot

Spring Data JPA

Spring Validation

Thymeleaf

MySQL

Maven

HTML5 / CSS3

📸 Capturas de pantalla

Las imágenes del funcionamiento del CRUD se encuentran en la carpeta:

/screenshots


Incluyen:

Registro de personas

Listado

Edición

Eliminación

Mensajes del sistema

👉 Ejemplos:

Registro de personas

Listado de personas

Inicio del sistema

Base de datos

🌐 2. Página Web – HTML & CSS

Página web estática desarrollada como práctica de estructura HTML y estilos CSS, enfocada en reforzar conceptos de maquetación, organización visual y presentación de información.

🛠️ Tecnologías utilizadas

HTML5

CSS3

📸 Capturas de pantalla

Las capturas de esta página web también se encuentran en la carpeta:

/screenshots

🔧 Requisitos del entorno (Proyecto Java)

Java JDK 21 (versión utilizada para el desarrollo y pruebas)

MySQL

Maven (incluido mediante Maven Wrapper)

Un IDE compatible con Java y Spring Boot

IDEs compatibles

✅ NetBeans (IDE utilizado durante el desarrollo)

✅ IntelliJ IDEA

⚠️ Visual Studio Code (requiere extensiones de Java y Spring Boot)

📌 Nota:
El proyecto fue desarrollado y probado con Java 21.
Versiones superiores o inferiores pueden funcionar, pero no están garantizadas.

🗄️ Base de datos (Proyecto Java)

Base de datos: crud_java

Motor: MySQL

Las tablas se generan automáticamente gracias a JPA (ddl-auto=update)

Ejemplo de configuración (no incluida por seguridad):

spring.datasource.url=jdbc:mysql://localhost:3306/crud_java
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

▶️ Cómo ejecutar el proyecto CRUD

Clona el repositorio:

git clone https://github.com/Sebastian-122/Sebastian_Parada.git


Abre el proyecto en tu IDE

Configura la base de datos MySQL

Ejecuta la clase:

RegistroApplication.java


Abre en el navegador:

http://localhost:8080/personas

📌 Estado del repositorio

✔ Proyectos funcionales

✔ Uso académico y de portafolio

✔ Código organizado y documentado

✔ Base sólida para futuras mejoras

👤 Autor

Sebastian Parada
Aprendiz SENA – Análisis y Desarrollo de Software (ADSO)

📎 Portafolio en construcción – nuevos proyectos serán añadidos progresivamente.
