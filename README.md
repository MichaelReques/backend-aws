# 🚀 Backend Spring Boot con CI/CD automatizado en AWS EC2 & Docker

Este repositorio contiene el código fuente de una aplicación backend desarrollada con **Spring Boot** y **PostgreSQL**, implementada con un flujo de **CI/CD automatizado mediante GitHub Actions** sobre una instancia de **AWS EC2 (Ubuntu)** usando contenedores Docker.

---

## 🛠️ Tecnologías y Herramientas Utilizadas

* **Backend:** Java 21, Spring Boot, Spring Data JPA, Maven.
* **Base de Datos:** PostgreSQL.
* **Contenedorización & Orquestación:** Docker, Docker Compose (con soporte para perfiles).
* **Infraestructura & Cloud:** AWS EC2 (Ubuntu), Nginx (opcional como proxy inverso), Git/GitHub.
* **CI/CD:** GitHub Actions (automatización de despliegues mediante SSH).

---

## 📂 Arquitectura del Proyecto

El proyecto está estructurado mediante contenedores aislados gestionados por Docker Compose:
1. **`backend-app`**: Contenedor con la aplicación de Spring Boot empaquetada en un JAR ejecutable sobre una imagen ligera de Eclipse Temurin Java 21.
2. **`postgres-db` / `db-nube`**: Contenedores de base de datos PostgreSQL encargados de persistir la información de la aplicación (`tienda_db`).

---

## 🔄 Flujo de CI/CD (GitHub Actions)

El pipeline de integración y despliegue continuo está configurado en `.github/workflows/deploy.yml`. Su funcionamiento es el siguiente:

1. **Trigger:** Cada vez que se realiza un `git push` a la rama `main`, el workflow se dispara automáticamente.
2. **Conexión SSH:** GitHub Actions se conecta de forma segura a tu servidor AWS EC2 utilizando secretos cifrados (`SSH_PRIVATE_KEY`, `SSH_HOST`, `SSH_USER`).
3. **Actualización de Código:** Ejecuta un `git pull` dentro del directorio del proyecto en el servidor (`~/proyecto-backend`).
4. **Despliegue con Docker Compose:** Ejecuta la reconstrucción y el levantamiento de los contenedores optimizados para producción utilizando perfiles de Docker (`docker compose --profile prod up -d --build`).

---

## 🚀 Guía de Pruebas en Postman

Los endpoints principales de la API se pueden consumir directamente apuntando a la IP pública del servidor AWS en el puerto `8080`:

* **URL Base:** `http://77.113.246.209:8080/api/productos`

### 1. Listar Productos (GET)
* **Método:** `GET`
* **URL:** `http://77.113.246.209:8080/api/productos`

### 2. Registrar Producto (POST)
* **Método:** `POST`
* **URL:** `http://77.113.246.209:8080/api/productos`
* **Headers:** `Content-Type: application/json`
* **Body (JSON):**
```json
{
  "nombre": "Laptop Gamer",
  "descripcion": "Lenovo LOQ con RTX",
  "precio": 3500.00,
  "stock": 10,
  "activo": true
}
