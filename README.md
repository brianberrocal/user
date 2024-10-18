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
   git clone https://github.com/tu_usuario/user-management-service.git

2. Navega al directorio del proyecto:
   ```bash
   cd user-management-service
   
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
     -  200 OK: Usuario creado con éxito.
     -  400 Bad Request: Error de validación.
