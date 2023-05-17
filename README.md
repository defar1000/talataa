
#Prueba técnica  Ingeniero de Desarrollo de Software JAVA

Introducción:
A continuación están las instrucciones de la prueba técnica para Ingeniero de desarrollo JAVA, el plazo máximo de entrega se especifica en el correo electrónico, quedo atento a cualquier duda.
Por favor leer atentamente cada punto.
1. Utilizando JAVA y spring boot se requiere la construcción de una RESTful API donde se consuma los servicios provee la api de The Movie database.                                                                                                             2. Crear Endpoints donde exponga la data ya procesada (Incluir métodos POST, PUT, DELETE, UPDATE).
3. Las respuestas de los endpoints deben estar estandarizadas para una mayor legibilidad.
4. no mostrar más 20 películas en la carga inicial, Construir un paginador para controlar la cantidad de data          proveniente de la API (GET)
5. Construir endpoint de detalle de cada película usando toda la información que ofrece la Api (GET por ID).
6. El proyecto se debe subir a un repositorio Público en GitHub o GitLab, se debe compartir el link del proyecto a este mismo correo.
7. Desplegar proyecto en cualquier tipo de nube (AWS, AZURE).
   Aspectos a evaluar:
1. Semántica.
2. Patrones de Diseño.
3. DRY (Don't repeat yourself).
4. Organización y legibilidad.
5. Documentación en readme.

Se Considera un Plus:
1. Arquitectura orientada al dominio (DDD).
2. Unit Testing.
3. Uso de Swagger.
4. Uso en Docker.
   
Recursos:
1. API : https://www.themoviedb.org/documentation/api

##Resolución

Proyecto con implementación de clean architecture, POO, programación funcional, programación reactiva y patrones de diseño

- Alojado en GitHub, repositorio publico https://github.com/defar1000/talataa/tree/master
- Desplegado por pipelines de CI/CD por medio de AzureDevOps
- Desplegado por medio de imagen de docker (archivo docker file en el proyecto)  
- Corriendo en una instacia de Amazon EC2, ip de acceso  3.129.43.184 ó el DNS ec2-3-129-43-184.us-east-2.compute.amazonaws.com

##Rutas del apiRest

###Ruta Base: http://3.129.43.184/api

### * Consultar todas las peliculas por paginador

- ruta: /movie
- Method Get
- Como parametros opcionales se pueden enviar todos los permitidos por el api original
   - Principalmente se usara el paametro page para la paginación '?page=xx' (Nota: el api original limita este paginador a 500 o inferior)

### * Consultar detallers de pilucula por ID
- ruta /movie/{id}
- Method Get
- Recibe el id en la ruta, como query parameter

### * Consultar detalle de una lista de peliculas
- ruta /list/{id}/details
- Method Get
- Recibe el id de la lista en la ruta, como query parameter

### * Eliminar una pelicula de una lista especifica
- ruta /list/{id}/remove_item
- Method Delete
- Recibe el id de la lista en la ruta, como query parameter
- Recibe la pelicula que se desea elimnar por medio del body como json

### * Añadir una pelicula a una lista especifica
- ruta /list/{id}/add_item
- Method Put
- Recibe el id de la lista en la ruta, como query parameter
- Recibe la pelicula que se desea añadir por medio del body como json

### * Actualizar listado de peliculas en una lista especifica
- ruta /list/{id}/update_items
- Method Patch
- Recibe el id de la lista en la ruta, como query parameter
- Recibe el listado de peliculas que se desea dejar en la lista por medio del body como json

### * Limpiar las peliculas de una lista especifica
- ruta /list/{id}/clear
- Method Post
- Recibe el id de la lista en la ruta, como query parameter

---
####Notas adicionales
- No logre acer pruebas unitarias por falta de tiempo
- Nunca he usado swager y no tuve tiempo de consultarlo, por lo tanto no se implemento
- Los 4 ultimos endpoint no estan funcionales, ya que no logre encontrar la forma que debia tener el body para funcionar y el api de origen no tenia documentación al respecto



---

# Proyecto Base Implementando Clean Architecture

## Antes de Iniciar

Empezaremos por explicar los diferentes componentes del proyectos y partiremos de los componentes externos, continuando con los componentes core de negocio (dominio) y por último el inicio y configuración de la aplicación.

Lee el artículo [Clean Architecture � Aislando los detalles](https://medium.com/bancolombia-tech/clean-architecture-aislando-los-detalles-4f9530f35d7a)

# Arquitectura

![Clean Architecture](https://miro.medium.com/max/1400/1*ZdlHz8B0-qu9Y-QO3AXR_w.png)

## Domain

Es el módulo más interno de la arquitectura, pertenece a la capa del dominio y encapsula la lógica y reglas del negocio mediante modelos y entidades del dominio.

## Usecases

Este módulo gradle perteneciente a la capa del dominio, implementa los casos de uso del sistema, define lógica de aplicación y reacciona a las invocaciones desde el módulo de entry points, orquestando los flujos hacia el módulo de entities.

## Infrastructure

### Helpers

En el apartado de helpers tendremos utilidades generales para los Driven Adapters y Entry Points.

Estas utilidades no están arraigadas a objetos concretos, se realiza el uso de generics para modelar comportamientos
genéricos de los diferentes objetos de persistencia que puedan existir, este tipo de implementaciones se realizan
basadas en el patrón de diseño [Unit of Work y Repository](https://medium.com/@krzychukosobudzki/repository-design-pattern-bc490b256006)

Estas clases no puede existir solas y debe heredarse su compartimiento en los **Driven Adapters**

### Driven Adapters

Los driven adapter representan implementaciones externas a nuestro sistema, como lo son conexiones a servicios rest,
soap, bases de datos, lectura de archivos planos, y en concreto cualquier origen y fuente de datos con la que debamos
interactuar.

### Entry Points

Los entry points representan los puntos de entrada de la aplicación o el inicio de los flujos de negocio.

## Application

Este módulo es el más externo de la arquitectura, es el encargado de ensamblar los distintos módulos, resolver las dependencias y crear los beans de los casos de use (UseCases) de forma automática, inyectando en éstos instancias concretas de las dependencias declaradas. Además inicia la aplicación (es el único módulo del proyecto donde encontraremos la función 'public static void main(String[] args)'.

**Los beans de los casos de uso se disponibilizan automaticamente gracias a un '@ComponentScan' ubicado en esta capa.**
