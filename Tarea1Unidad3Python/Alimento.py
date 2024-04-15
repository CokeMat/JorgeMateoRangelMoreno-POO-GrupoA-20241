from datetime import datetime
from enum import Enum
from Producto import Producto, tipoProducto

class Alimento(Producto):
    def __init__(self, nombre, precio, stock, fecha_importacion, fecha_vencimiento):
        super().__init__(nombre, tipoProducto.ALIMENTO, precio, stock, fecha_importacion)
        self.fecha_vencimiento = fecha_vencimiento

    def get_fecha_vencimiento(self):
        return self.fecha_vencimiento

    def get_datos(self):
        return f"{super().get_datos()}    Fecha de Caducidad: {self.get_fecha_vencimiento()}"