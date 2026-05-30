# TiendaApp - Gestión de Usuarios con Arquitectura Hexagonal

## Descripción del Proyecto

TiendaApp es una aplicación web desarrollada con Spring Boot que implementa la Arquitectura Hexagonal (Ports and Adapters) para la gestión de usuarios dentro de una tienda.

El sistema permite registrar usuarios y asignarles diferentes roles dentro de la organización:

* Administrador
* Vendedor
* Bodeguero

La aplicación está diseñada siguiendo principios de separación de responsabilidades, desacoplamiento entre capas y buenas prácticas de desarrollo de software, facilitando su mantenimiento, escalabilidad y evolución futura.

Actualmente el sistema permite:

* Registro de usuarios.
* Almacenamiento de usuarios en base de datos MySQL.
* Gestión de roles.
* Visualización de usuarios registrados.
* Arquitectura Hexagonal.
* Integración con Spring Data JPA.
* Interfaz web desarrollada con HTML, CSS, JavaScript y Bootstrap.

---

# Arquitectura Utilizada

El proyecto implementa la Arquitectura Hexagonal (Ports and Adapters), organizada en las siguientes capas:

```text
src/main/java/com/tienda/api

├── application
│   ├── dto
│   └── usecase
│
├── domain
│   ├── model
│   ├── ports
│   │   ├── input
│   │   └── output
│   └── service
│
└── infrastructure
    ├── adapters
    │   ├── input
    │   └── output
    │
    ├── config
    └── security
```

---

# Tecnologías Utilizadas

## Backend

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* Hibernate
* Maven

## Base de Datos

* MySQL

## Frontend

* HTML5
* CSS3
* JavaScript
* Bootstrap 5

## Herramientas de Desarrollo

* IntelliJ IDEA
* MySQL Workbench
* Git
* GitHub
* Postman

---

# Configuración de Base de Datos

Antes de ejecutar el proyecto, crear la base de datos:

```sql
CREATE DATABASE tienda;
```

Configurar el archivo:

```text
src/main/resources/application.properties
```

Contenido:

```properties
spring.application.name=tienda-api

spring.datasource.url=jdbc:mysql://localhost:3306/tienda
spring.datasource.username=tu_usuario   
spring.datasource.password=tu_contraseña

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

spring.jpa.open-in-view=false
```


# Ejecución del Proyecto

## Opción 1: Ejecutar desde IntelliJ IDEA

1. Abrir el proyecto.
2. Esperar que Maven descargue las dependencias.
3. Verificar que MySQL esté en ejecución.
4. Abrir la clase:

```text
TiendaApplication.java
```

5. Ejecutar mediante el botón Run.

La aplicación iniciará en:

```text
http://localhost:8080
```

---

## Opción 2: Ejecutar desde Terminal

Ubicarse en la raíz del proyecto:

```bash
cd tienda-api
```

Compilar el proyecto:

```bash
mvn clean install
```

Ejecutar la aplicación:

```bash
mvn spring-boot:run
```

También es posible ejecutar el archivo JAR generado:

```bash
java -jar target/tienda-api.jar
```

---

# Acceso a la Aplicación

Una vez iniciada correctamente:

```text
http://localhost:8080
```

Desde esta dirección será posible acceder al sistema web de gestión de usuarios.


# Autor

Lee Torralvo
Ingeniero de Software


Proyecto desarrollado como práctica académica de Ingeniería de Software aplicando Arquitectura Hexagonal, Spring Boot y buenas prácticas de desarrollo backend.
