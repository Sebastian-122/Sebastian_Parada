# 🧑‍💻 CRUD de Personas – Spring Boot & MySQL

Proyecto **CRUD básico y funcional** desarrollado en **Java con Spring Boot**, que permite **registrar, listar, editar y eliminar personas**, validando que **no se repitan correos ni números de celular** y mostrando **mensajes de éxito y error** al usuario.

Este proyecto fue realizado como práctica académica y base para portafolio.

---

## 🚀 Funcionalidades

- ✅ Registrar personas
- ✅ Listar personas registradas
- ✅ Editar información de personas
- ✅ Eliminar personas con confirmación previa
- ❌ No permite correos duplicados
- ❌ No permite números de celular duplicados
- 📢 Mensajes de:
  - Registro exitoso
  - Eliminación exitosa
  - Error por correo o celular repetido
- 🔄 Persistencia automática en base de datos MySQL

---

## 🛠️ Tecnologías utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Validation**
- **Thymeleaf**
- **MySQL**
- **Maven**
- **HTML5 / CSS3**

---

## 🔧 Requisitos del entorno

- **Java JDK 21** (versión utilizada para el desarrollo y pruebas)
- **MySQL**
- **Maven** (incluido mediante Maven Wrapper)
- Un IDE compatible con Java y Spring Boot

### IDEs compatibles
- ✅ NetBeans (**IDE utilizado durante el desarrollo**)
- ✅ IntelliJ IDEA
- ⚠️ Visual Studio Code (requiere extensiones de Java y Spring Boot)

> 📌 Nota:  
> El proyecto fue **desarrollado y probado con Java 21**.  
> Otras versiones de Java pueden funcionar, pero **no están garantizadas**.

---

## 🗄️ Base de datos

- Base de datos: `crud_java`
- Motor: **MySQL**
- Las tablas se generan automáticamente gracias a JPA (`ddl-auto=update`).

Ejemplo de configuración (no incluida por seguridad):

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/crud_java
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password
📁 Estructura del proyecto
css
Copiar código
src/
 └── main/
     ├── java/
     │   └── com.crud.registro
     │       ├── controller
     │       ├── service
     │       ├── repository
     │       └── model
     └── resources/
         ├── templates
         ├── static/css
         └── application.properties
▶️ Cómo ejecutar el proyecto
Clona el repositorio:

bash
Copiar código
git clone https://github.com/tu-usuario/tu-repositorio.git
Abre el proyecto en tu IDE favorito

Configura tu base de datos MySQL

Ejecuta la clase:

Copiar código
RegistroApplication.java
Abre en el navegador:

bash
Copiar código
http://localhost:8080/personas
📸 Capturas de pantalla
Las capturas del funcionamiento del sistema se encuentran en la carpeta:

bash
Copiar código
/screenshots
(Registro, listado, edición, eliminación y mensajes del sistema)

📌 Estado del proyecto
✔ Proyecto finalizado
✔ Funcional
✔ Listo para uso académico y portafolio
✔ Base sólida para futuras mejoras (diseño, seguridad, roles, etc.)

👤 Autor
Sebastian Parada
Aprendiz SENA – Análisis y Desarrollo de Software (ADSO)