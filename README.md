# globank-challenge

## Acerca de globank-challenge

Este proyecto contiene cinco microservicios 

* discovery-server
* globank-challenge-cliente
* globank-challenge-cuenta
* globank-challenge-movimiento
* api-gateway


A través de la api-gateway la aplicación expone 3 APIs
* http://localhost:8090/apigateway-cliente/cliente
* http://localhost:8090/apigateway-cuenta/cuenta
* http://localhost:8090/apigateway-movimiento/movimiento

De manera alternativa también están funcionales las APIs sin uso de api-gateway
* http://localhost:9001/cliente
* http://localhost:9002/cuenta
* http://localhost:9003/movimiento

## Eureka server endpoint
### http://localhost:8761/
#### Aquí se muestra el estado de los microservicios, el número de instancias y más métricas asociadas

## globank-challenge-cliente
### Cliente endpoint 1:listar
* http://localhost:8090/apigateway-cliente/cliente/listar
### Request
```
N/A
```
###Response
```
[
    {
        "clienteId": 1,
        "contrasenia": "1234",
        "estado": true
    },
    {
        "clienteId": 2,
        "contrasenia": "12345",
        "estado": false
    },
    {
        "clienteId": 3,
        "contrasenia": "123456",
        "estado": true
    }
]

```
### Cliente endpoint 2:crear
* http://localhost:8090/apigateway-cliente/cliente/crear
### Request
{
    "contrasenia" : "Joseph145",
    "estado" : "false"
}
###Response
```
N/A

```

### Cliente endpoint 3:actualizar
* http://localhost:8090/apigateway-cliente/cliente/actualizar
### Request
{
    "clienteId" : "2",
    "contrasenia" : "JoseRepelinCuchara",
    "estado" : "false"
}
###Response
```
N/A

```
### Cliente endpoint 4:eliminar
* http://localhost:8090/apigateway-cliente/cliente/eliminar
### Request
{
    "clienteId" : "2"
}
###Response
```
N/A

```

### Cuenta endpoint 1:listar
* http://localhost:8090/apigateway-cuenta/cuenta/listar
### Request
N/A
###Response
```
[
    {
        "cuentaId": 1,
        "numeroCuenta": "0123456789",
        "tipoCuenta": "Ahorro",
        "saldoInicial": 2000000.0,
        "estado": true,
        "nombre": "Zacarias Piedras del Rio"
    },
    {
        "cuentaId": 2,
        "numeroCuenta": "0243656589",
        "tipoCuenta": "Corriente",
        "saldoInicial": 1000000.0,
        "estado": true,
        "nombre": "Juanito Alimaña"
    },
    {
        "cuentaId": 3,
        "numeroCuenta": "4323496109",
        "tipoCuenta": "Ahorro",
        "saldoInicial": 500000.0,
        "estado": true,
        "nombre": "Pedro Paramo"
    }
]

```
### Cuenta endpoint 2:crear
* http://localhost:8090/apigateway-cuenta/cuenta/crear
### Request
```
{
    "numeroCuenta" : "9876543210",
    "tipoCuenta" : "Corriente",
    "saldoInicial" : "50000.0",
    "estado" : "true",
    "nombre" : "Josefa"
}
```
###Response
```
N/A

```
### Cuenta endpoint 3:actualizar
* http://localhost:8090/apigateway-cuenta/cuenta/actualizar
### Request
```
{
    "cuentaId" : "1",
    "numeroCuenta" : "9876543210",
    "tipoCuenta" : "Ahorros",
    "saldoInicial" : "3000.0",
    "estado" : "false",
    "nombre" : "Josefa"
}
```
###Response
```
N/A

```

### Cuenta endpoint 4:eliminar
* http://localhost:8090/apigateway-cuenta/cuenta/eliminar
### Request
```
{
    "cuentaId" : "2"
}
```
###Response
```
N/A

```

### Movimiento endpoint 1:listar
* http://localhost:8090/apigateway-movimiento/movimiento/listar
### Request
```
N/A
```
###Response
```
[
    {
        "movimientoId": 1,
        "fecha": "2022-08-11",
        "tipoMovimiento": "Retiro",
        "valor": 10000.0,
        "saldo": 8900000.0
    },
    {
        "movimientoId": 2,
        "fecha": "2022-02-14",
        "tipoMovimiento": "Depsito",
        "valor": 555500.0,
        "saldo": 6500000.0
    },
    {
        "movimientoId": 3,
        "fecha": "2022-06-21",
        "tipoMovimiento": "Deposito",
        "valor": 62480.0,
        "saldo": 1600000.0
    }
]

```

### Movimiento endpoint 2:crear
* http://localhost:8090/apigateway-movimiento/movimiento/crear
### Request
```
{
    "tipoMovimiento" : "Retiro",
    "valor" : "40000.0",
    "saldo" : "8000000.0"
}
```
###Response
```
N/A

```

### Movimiento endpoint 3:actualizar
* http://localhost:8090/apigateway-movimiento/movimiento/actualizar
### Request
```
{
    "movimientoId" : "1",
    "tipoMovimiento" : "Retiro",
    "valor" : "130000.0",
    "saldo" : "560000.0"
}
```
###Response
```
N/A

```

### Movimiento endpoint 4:eliminar
* http://localhost:8090/apigateway-movimiento/movimiento/eliminar
### Request
```
{
    "movimientoId" : "4"
}
```
###Response
```
N/A

```


## Trabajando con globank-challenge en el IDE

### Base de datos
* Para la persistencia se usó la base de datos en memoria H2
* El llenado de las tablas se hace al levantar los respectivos microservicios, donde automaticamente se ejecuta el script import.sql que hace parte de los para llenar cada tabla

### Prerequisites
Se debe contar con las siguientes herramientas
* Java 11 o mayor (JDK).
* git command line tool (https://help.github.com/articles/set-up-git), development es la branch actualizada 
* IDE de preferencia
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * Eclipse IDE
  * [VS Code](https://code.visualstudio.com)

### Pasos para desplegar:

1) En la consola de Git Bash
    ```
    git clone https://github.com/globank-challenge/dev-java-leon-herrera.git
    ```
2) En Eclipse IDE o STS
    ```
    File -> Import -> Maven -> Existing Maven project 
    ```
   -Seleccione los cinco microservicios e importelos
   -Finalmente ejecute maven -> Update project y levante cada microservicio, subiendo primero discovery-server y por último api-gateway, el orden de ejecución para los tres servicios del medio (globank-challenge-cliente, globank-challenge-cuenta y globank-challenge-movimiento) no tiene relevancia
