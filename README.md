# RetoNeoris

Este repositorio contiene el código y la lógica correspondiente al reto técnico planteado por la empresa NEORIS.

## Descripción

Este proyecto consiste en una API para un banco, desarrollada utilizando Spring Boot para el backend y MySQL como base de datos. Proporciona funcionalidades clave para la gestión de clientes, cuentas y movimientos bancarios.

## Características

- Registro y gestión de clientes: Permite el registro de nuevos clientes y el mantenimiento de su información personal, como nombre, género, edad, identificación, dirección y teléfono.
- Gestión de cuentas bancarias: Permite la creación de cuentas bancarias para los clientes, con detalles como número de cuenta, tipo de cuenta, saldo inicial y estado.
- Realización de movimientos bancarios: Permite registrar y consultar movimientos bancarios, como depósitos, retiros y transferencias, manteniendo un registro de las fechas, tipos de movimiento, valores y saldos asociados.

## Requisitos

- Docker y Docker Compose: Asegúrate de tener instalados Docker y Docker Compose en tu entorno de desarrollo antes de ejecutar el proyecto.

## Cómo ejecutar el proyecto

1. Clona este repositorio en tu máquina local.
2. Navega hasta el directorio del proyecto en tu terminal.
3. Ejecuta el comando `docker-compose build` para construir los contenedores de la aplicación y la base de datos.
4. Ejecuta el comando `docker-compose up` para iniciar los contenedores.
5. La aplicación estará disponible en `localhost:8080`.

## Cómo detener el proyecto

1. Presiona Ctrl+C en tu terminal donde se está ejecutando Docker Compose.
2. Ejecuta el comando `docker-compose down` para detener y eliminar los contenedores o `docker-compose down -v` para borrar el volumen que fue asignado a la base de datos y así también los registros creados.

## Cómo usar la API

Se adjunta una colección de Postman (`Transacciones.postman_collection.json`) dentro de la carpeta `PostmanCollection`que contiene ejemplos de solicitudes HTTP para interactuar con la API. Puedes importar esta colección en Postman y ejecutar las solicitudes para probar las diferentes funcionalidades de la API. La colección incluye ejemplos de solicitudes POST y GET para crear clientes, cuentas y movimientos bancarios, así como para obtener información específica.

## Tests Unitarios

Durante el desarrollo de este proyecto, se implementaron tests unitarios utilizando la metodología TDD (Desarrollo Dirigido por Pruebas). A medida que el proyecto avanzaba, se realizaron ajustes en los tests para adaptarse a los cambios en los requerimientos y funcionalidades.

## Base de datos

La aplicación utiliza una base de datos MySQL. Al ejecutar el proyecto con Docker Compose, se inicializará automáticamente la base de datos utilizando el archivo `init.sql` que se encuentra en el proyecto. Este archivo crea la estructura de la base de datos y carga algunos datos de prueba para comenzar.


Si tienes alguna pregunta o problema, no dudes en contactarme.
