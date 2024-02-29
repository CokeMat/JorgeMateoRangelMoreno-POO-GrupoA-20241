# Tarea 6 Unidad 2
## __Instrucciones__
Realizar el ejercicio

Se desea crear una clase llamada 'Producto' que represente un articulo en un inventario. La clase debe tener los siguientes atributos privados:
1. __nombre__ : Una cadena que representa el nombre del producto.
2. __precio__: Un número de punto flotante que representa el precio del producto.
3. __stock__: Un número entero que representa la cantidad de existencias disponibles del producto. 

Se deben proporcionar los siguientes métodos públicos:
1. Constructores:
    - Un constructor que tome tres parametros (__nombre, precio y stock__) para inicializar todos los atributos del producto.
    - Un constructor que tome dos parametros (__nombre y precio__) y que establezca el stock en 0 por defecto.

2.Getters y setters para todos los atributos:
    
    - getNombre() y setNombre(String nombre)

    - getPrecio() y setPrecio(double precio)

    - getStock() y setStock(int stock)

3. Métodos Adicionales:
    - __aumentarStock(int cantidad)__: Aumenta el stock del producto en la cantidad especificada, con validación para asegurarse de que lla cantidad sea mayor que cero.
    - __reducirStock(int cantidad)__: Reduce el stock del producto en la cantidad especificada, con validación para asegurarse de que la cantidad sea mayor que cero y menor o igual al stock actual.

Además, se deben incluir las siguientes validaciones en los setters:
- El precio y el stock no pueden ser negativos.
- El nombre no puede ser nulo
- La cantidad a reducir del stock debe ser menor o igual al stock actual. 


_______________________
### Jorge Mateo Rangel Moreno
### 231211103