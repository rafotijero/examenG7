# ExamenG7 - Gestor de Personas, Direcciones y Pedidos

Este proyecto proporciona una API RESTful para gestionar direcciones, pedidos y personas. Permite a los usuarios crear, actualizar, eliminar y recuperar datos relacionados con estas entidades, asegurando la integridad y validación de los datos.

## Características

- **Gestión de Personas**
  - Crear, actualizar y eliminar personas.
  - Recuperar personas por ID o número de documento.
  - Listar todas las personas con estado activo.

- **Gestión de Pedidos**
  - Crear, actualizar y eliminar pedidos asociados a personas.
  - Recuperar pedidos por ID o estado.
  - Listar todos los pedidos con un estado específico.

- **Gestión de Direcciones**
  - Asociar direcciones con personas.

## Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL (o cualquier otra base de datos compatible)

## Cómo Empezar

### Requisitos Previos

- JDK 17
- Maven
- Base de Datos MySQL

### Instalación

1. Clona el repositorio:
   ```bash
   git clone <url-del-repositorio>
   cd <directorio-del-proyecto>

2. Actualiza application.properties con tus configuraciones de base de datos.

## Endpoints de la API

Personas
- Crear Persona: ```POST /personas/v1/crearPersona```
- Obtener Todas las Personas: ```GET /personas/v1/buscarTodos```
- Obtener Persona por Número de ID: ```GET /personas/v1/buscarPersonaXnumDocumento?numDocumento={idNumber}```
- Actualizar Persona: PUT ```/personas/v1/actualizarPersona/{id}```
- Eliminar Persona: DELETE ```/personas/v1/eliminarPersona/{id}```

Pedidos
- Crear Pedido: ```POST /pedidos/v1/crearPedido/persona/{idPerson}```
- Obtener Todos los Pedidos por Estado: ```GET /pedidos/v1/buscarTodos?estado={estado}```
- Obtener Pedidos por Parámetro: ```GET /pedidos/v1/buscarPedidoPorParametro?id={id}&estado={estado}```
- Actualizar Pedido: ```PUT /pedidos/v1/actualizarPedido/{id}/persona/{idPerson}```
- Eliminar Pedido: ```DELETE /pedidos/v1/eliminarPedido/{id}```

## Manejo de Errores
- Estados inválidos
- Entidades no encontradas
   
