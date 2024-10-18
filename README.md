# Registro de Usuario

Este es un servicio de gestión de usuarios desarrollado con Spring Boot. Permite registrar usuarios con múltiples teléfonos y validar correos electrónicos y contraseñas según reglas configurables.

## Características

- Registro de usuarios
- Validación de correos electrónicos
- Validación de contraseñas con expresiones regulares configurables
- Soporte para múltiples números de teléfono

## Requisitos

- Java 11 o superior
- Maven

## Instalación

1. Clona el repositorio:
   ```bash
   git clone https://github.com/brianberrocal/user.git

2. Navega al directorio del proyecto:
   ```bash
   cd user
   
3. Compila el proyecto:
   ```bash
    mvn clean install
   
4. Ejecuta la aplicación:
    ```bash
   mvn spring-boot:run

## Uso
##    Endpoints
##   Registrar un usuario
   - Método: POST
    
   - URL: /user
    
     - Cuerpo de la solicitud:

       {
           "name": "Juan Rodriguez",
           "email": "juan@dominio.cl",
           "password": "Bnn%8nkn",
           "phones": [
               {
               "number": "1234567"",
               "citycode": "1",
               "contrycode": "57"
               }
           ]
       }
   - Respuesta:
     -  200 OK
     -  400 Bad Request
     -  400-1 Bad Request
     -  400-2 Bad Request

## Collection del Servicio - POSTMAN:

- Ingresar a la siguiente ruta dentro del proyecto donde se encuentran el collection llamado "BCI.postman_collection":
    - user\src\main\resources\Collection

## Evidencias de pruebas del servicio:

- Ingresar a la siguiente ruta dentro del proyecto donde se encuentran adjuntas imagenes de las pruebas:
  - user\src\main\resources\Evidencias

## Diagrama de la Solucion:
### Opcion #1
- Ingresar a la siguiente ruta dentro del proyecto donde se encuentran el archivo llamado "Diagrama_solucion_User" que se puede abrir con la herramienta Drawio web:
  - Ruta del archivo: user\src\main\resources\Diagrama-Solucion
  - Link de la herramienta drawio : https://www.drawio.com/

### Opcion #2

Ingresar a la siguiente ruta dentro del proyecto donde se encuentran el archivo llamado "Diagrama_solucion_User.jpg":
- Ruta del archivo: user\src\main\resources\Diagrama-Solucion

## Contrato OpenApi del Servicio:

- Ingresar a la siguiente ruta dentro del proyecto donde se encuentran archivo llamado OpenApi-User.yml que se puede abrir con la herramienta swagger Editor web:
    - user\src\main\resources\OpenApi
- Link de la herramienta drawio : https://editor.swagger.io/
