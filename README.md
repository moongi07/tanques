# Proyecto de Gasolinera - Spring Boot

## Introducción

Este proyecto es una aplicación web desarrollada con Spring Boot para gestionar la información de una gasolinera. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar y Borrar) sobre distintas entidades que representan la estructura y funcionamiento de la gasolinera, como precios de productos, tanques, surtidores y suministros.

---

## Entidades del proyecto
**Precio**
**Producto**
**Suministro**
**Surtidor**
**SurtidorProducto**
**Tanque**
---
## Operaciones CRUD por entidad

Estas operaciones están definidas para cada entidad y permiten gestionar su información:

### Ejemplo:
```java
// Lectura de todos los precios
public List<Precio> getPrecio();

// Alta de un nuevo precio
public void savePrecio(Precio precio);

// Baja de un precio por ID
public void deletePrecio(int id);

// Lectura de un precio específico por ID
public Precio findPrecioById(int id);

// Modificación de un precio existente
public void editPrecio(int id_original, int id_nuevo, Producto producto, Date fecha_inicio_nueva, Date fecha_fin_nueva, BigDecimal precio_por_filtro_nuevo);
```

---

## Tecnologías utilizadas

El proyecto está desarrollado usando las siguientes tecnologías:

- **Spring Boot**: Framework principal para el desarrollo de la aplicación.
- **Spring Data JPA**: Para manejar las operaciones CRUD sobre la base de datos.
- **H2 Database**: Base de datos en memoria utilizada para pruebas y desarrollo.
- **Java 17** (o cualquier versión compatible con Spring Boot).

  [Despliegue en render](https://practica-8296.onrender.com)
