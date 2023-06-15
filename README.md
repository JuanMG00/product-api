# inditex-product-api

Una API integral para acceder a información de productos, precios de Inditex

Acepta como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena. Devuelve
como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y
precio final.

- ###### La aplicación usa java 17 y springboot 3.1.0 gestionado con gradle
- Se ha utilizado una arquitectura hexagonal para desacoplar el dominio y el negocio.
- Se ha agregado una bbdd h2 con flyway para gestionar las tablas y la estructura de datos de la bbdd. 
- El script de creacion de la tabla prices añade una constraint para que no se pueda repetir un precio a un mismo producto 
  con fechas solapadas y mismo valor de prioridad 
- La configuración se hace en el application.properties
- Se ha utilizado spring data rest para simplificar la aplicación accediendo directamente a un endpoint expuesto en el repositorio.
- Existe un controller advice para capturar las excepciones generadas en el api y traducir la respuesta.

Existen test de integración como unitarios para probar el api.
Los test de integración replican el contexto levantando una instancia nueva de la bbdd 
de la api apuntando al application-it.properties 

end point generado es http://localhost:8080/prices/search/applicable-price
debe tener estos parámetros para poder filtrar el resultado deseado:

**projection=priceProjection**: La proyección en la que se devuelve el resultado de búsqueda. Está creada para priceProjection.

**brandId**: Integer representando el id de la bbdd de la brand

**applicationDate**: LocalDateTime que tiene que estar en rango del priceList deseado. El formato tiene que
ser `yyyy-MM-dd HH:mm:ss`

**productId**: Integer representando el id de la bbdd del producto

- ejemplo de una llamada
válida: http://localhost:8080/prices/search/applicable-price?projection=priceProjection&productId=35455&applicationDate=2020-06-14 00:00:00&brandId=1

