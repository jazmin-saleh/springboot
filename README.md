El controlador `CustomersController` maneja las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) relacionadas con los clientes (`Customers`) en la aplicación. A continuación se detallan las rutas y métodos asociados:

1. **Listar todos los clientes**:
   - Ruta: `/customers`
   - Método: `GET`
   - Descripción: Retorna todos los clientes almacenados en el sistema.

2. **Buscar cliente por ID**:
   - Ruta: `/customers/{id}`
   - Método: `GET`
   - Descripción: Retorna un cliente específico según su ID.

3. **Guardar un nuevo cliente**:
   - Ruta: `/customers`
   - Método: `POST`
   - Descripción: Crea y guarda un nuevo cliente en el sistema. El cliente a ser creado se proporciona en el cuerpo de la solicitud.

4. **Eliminar cliente por ID**:
   - Ruta: `/customers/{id}`
   - Método: `DELETE`
   - Descripción: Elimina un cliente específico según su ID.

Cada método define una acción específica que se puede realizar con los clientes y define la ruta a través de la cual se puede acceder a esa acción. Las anotaciones `@GetMapping`, `@PostMapping`, `@DeleteMapping`, etc., se utilizan para asociar un método de controlador a una ruta y tipo de solicitud HTTP específica.
