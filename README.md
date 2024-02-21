El servicio inicia en el 5432 y el enlace a la documentacion es en /docs
# Controlador de Productos
A continuación se detallan las rutas y métodos asociados a ventas:

1. **Crear una venta**:
   - Ruta: `/sales`
   - Método: `POST`
   - Parámetros de la solicitud:
     - `customerId`: ID del cliente asociado a la venta.
     - `productId`: ID del producto asociado a la venta.
     - Cuerpo de la solicitud: objeto `SalesDTO` que contiene la cantidad de productos vendidos.
   - Descripción: Crea una nueva venta en el sistema con el cliente y producto especificados, así como la cantidad de productos vendidos.

A continuación se detallan las rutas y métodos asociados productos:

1. **Listar todos los productos**:
   - Ruta: `/products`
   - Método: `GET`
   - Descripción: Retorna todos los productos almacenados en el sistema.

2. **Buscar producto por ID**:
   - Ruta: `/products/{id}`
   - Método: `GET`
   - Descripción: Retorna un producto específico según su ID.

3. **Guardar un nuevo producto**:
   - Ruta: `/products`
   - Método: `POST`
   - Descripción: Crea y guarda un nuevo producto en el sistema. El producto a ser creado se proporciona en el cuerpo de la solicitud.
 A continuación se detallan las rutas y métodos asociados a clientes:

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
