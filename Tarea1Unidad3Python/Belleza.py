from Producto import Enum, tipoProducto
from Producto import Producto

class Belleza(Producto):
    def __init__(self, nombre, precio, stock, fecha_importacion, marca):
        super().__init__(nombre, tipoProducto.BELLEZA, precio, stock, fecha_importacion)
        self.marca = marca

    def get_marca(self):
        return self.marca

    def get_datos(self):
        return f"{super().get_datos()}    Marca: {self.get_marca()}"