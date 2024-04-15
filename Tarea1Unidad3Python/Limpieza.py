from Producto import Producto, tipoProducto
from enum import Enum

class Limpieza(Producto):
    def __init__(self, nombre, precio, stock, fecha_importacion, marca):
        super().__init__(nombre, tipoProducto.LIMPIEZA, precio, stock, fecha_importacion)
        self.marca = marca

    def get_marca(self):
        return self.marca

    def get_datos(self):
        return f"{super().get_datos()}    Marca: {self.get_marca()}"