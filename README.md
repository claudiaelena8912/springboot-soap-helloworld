#springboot-soap-helloworld
La aplicación "springboot-soap-helloworld" es una implementación básica de un servicio web SOAP utilizando el framework Spring Boot.
 
Este proyecto tiene como objetivo mostrar lo minimo necesario para exponer un servicio web SOAP incluyendo: la definición del XSD, la definición del contrato del servicio mediante WSDL, la implementación del servicio en sí, y la configuración necesaria de Spring Boot para publicar el servicio web y hacerlo accesible a los clientes SOAP.

Este proyecto sirve como punto de partida para aquellos que buscan entender cómo desarrollar y exponer servicios web SOAP en aplicaciones Java.
 
 
##Tecnologías utilizadas##
- Spring Boots 3.2.4
- Java 11
- Database H2 (base de datos en memoria)
- Maven 3.9.6
- wsdl4j (publicar WSDL)
- jaxb2-maven-plugin (generar de código)


##Diseño de la solución##
La solución cuenta con los siguientes componentes:

- SOAP Webservice Endpoint: maneja las solicitudes entrantes/salientes del servicio y delega la logica del servicio web al componente Service (TaskEndpoint.java)

- Service: implementa la lógica de negocios y maneja el acceso a los DataAccessObjects. (TaskService.java y TaskServiceImpl.java)

- DataAccessObjects: interfaz para la base de datos, inserta, actualiza, elimina y lee objetos de la base de datos. (TaskRepository.java)

- DomainObjects: objetos funcionales que pueden persistir en la base de datos. (Task.java)


##Uso##
Ejecuta directamente con el plugin SpringBoot: `mvn spring-boot:run`

**NOTA:** El WSDL de la aplicación estará disponible en la siguiente URL: `http://localhost:8080/ws/tasks.wsdl`


##Base de datos##
La consola de h2 estará disponible en la siguiente URL: `http://localhost:8080/h2-ui` 

Datos de interés: 
- url= jdbc:h2:file:./testdb
- username=sa
- password=



** Autora**
- **Claudia Castro** - [klaudia-dev-22](https://github.com/klaudia-dev-22)