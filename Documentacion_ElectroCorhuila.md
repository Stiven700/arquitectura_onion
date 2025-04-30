## Daniel Stiven Poveda Cante
# Documentación de la API Electro Corhuila

Este repositorio contiene la API backend para el sistema de gestión de tarifas y usuarios de Electro Corhuila. Está desarrollado utilizando Java con Spring Boot y sigue la arquitectura limpia (onion architecture).

## Endpoints

### 1. Usuarios

#### **POST /usuarios**
Crea un nuevo usuario en el sistema.

##### Request Body:
```json
{
    "nombre": "Carlos Pérez",
    "estrato": "3"
}
```

##### Response:
```json
{
    "id": 1,
    "nombre": "Carlos Pérez",
    "estrato": "3",
    "tarifa": {
        "id": 3,
        "tarifaBase": 150.0
    }
}
```

#### **GET /usuarios**
Obtiene todos los usuarios registrados en el sistema.

##### Response:
```json
[
    {
        "id": 1,
        "nombre": "Carlos Pérez",
        "estrato": "3",
        "tarifa": {
            "id": 3,
            "tarifaBase": 150.0
        }
    },
    {
        "id": 2,
        "nombre": "Carlos Pinado",
        "estrato": "3",
        "tarifa": {
            "id": 3,
            "tarifaBase": 150.0
        }
    }
]
```

#### **GET /usuarios/{id}**
Obtiene los detalles de un usuario por su ID.

##### Response:
```json
{
    "id": 1,
    "nombre": "Carlos Pérez",
    "estrato": "3",
    "tarifa": {
        "id": 3,
        "tarifaBase": 150.0
    }
}
```

---

### 2. Tarifas

#### **POST /tarifas**
Crea una nueva tarifa en el sistema.

##### Request Body:
```json
{
    "tarifaBase": 100.0
}
```

##### Response:
```json
{
    "id": 1,
    "tarifaBase": 100.0
}
```

#### **GET /tarifas**
Obtiene todas las tarifas disponibles en el sistema.

##### Response:
```json
[
    {
        "id": 1,
        "tarifaBase": 100.0,
        "usuarios": []
    },
    {
        "id": 3,
        "tarifaBase": 150.0,
        "usuarios": [
            {
                "id": 1,
                "nombre": "Carlos Pérez",
                "estrato": "3"
            }
        ]
    }
]
```

#### **GET /tarifas/{id}**
Obtiene los detalles de una tarifa por su ID.

##### Response:
```json
{
    "id": 3,
    "tarifaBase": 150.0,
    "usuarios": [
        {
            "id": 1,
            "nombre": "Carlos Pérez",
            "estrato": "3"
        }
    ]
}
```

---

## Estructura del Proyecto

La aplicación está estructurada utilizando una arquitectura limpia (onion architecture) que separa las diferentes capas de la aplicación.

```
electro-corhuila/
├── domain/
│   ├── model/Usuario.java
│   ├── model/Tarifa.java
│   └── repository/...
├── application/
│   └── service/...
├── api/
│   └── controller/...
├── ElectroCorhuilaApplication.java
```

- **domain**: Contiene las entidades y repositorios.
- **application**: Servicios que contienen la lógica de negocio.
- **api**: Controladores REST que exponen los endpoints de la API.

---

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación.
- **Spring Boot**: Framework utilizado para construir la aplicación.
- **JPA (Java Persistence API)**: Para la persistencia de datos en la base de datos.
- **Lombok**: Biblioteca para la generación automática de código (getters, setters, constructores, etc.).
- **Jackson**: Para la serialización y deserialización de JSON.

---

## Instalación

### Requisitos Previos

- **Java 17** o superior.
- **Maven** para la gestión de dependencias.

### 🚀 Pasos para ejecutar el proyecto desde IntelliJ IDEA

1. **Clona el repositorio (si no lo has hecho aún):**
    ```bash
    git clone https://github.com/Stiven700/arquitectura_onion
    ```

2. **Abre el proyecto en IntelliJ IDEA:**
    - Desde IntelliJ, ve a **File > Open** y selecciona la carpeta `electrocorhuila`.
    - IntelliJ detectará automáticamente que es un proyecto Maven y descargará las dependencias necesarias.

3. **Verifica que la base de datos esté corriendo:**
    - Asegúrate de que tu servidor de base de datos (por ejemplo, MySQL) esté activo.
    - Verifica que los parámetros de conexión en `src/main/resources/application.properties` o `application.yml` estén correctamente configurados:
        ```properties
        spring.datasource.url=jdbc:mysql://localhost:3306/electrocorhuila
        spring.datasource.username=tu_usuario
        spring.datasource.password=tu_contraseña
        ```

4. **Ejecuta la aplicación desde IntelliJ:**
    - Abre la clase principal `ElectroCorhuilaApplication.java` ubicada en `src/main/java/...`
    - Haz clic derecho sobre la clase y selecciona **Run 'ElectroCorhuilaApplication.main()'**

5. **Verifica en el navegador:**
    - La aplicación estará disponible en:  
      👉 `http://localhost:8080`


---