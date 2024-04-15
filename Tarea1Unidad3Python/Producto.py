import random
from enum import Enum

class tipoProducto(Enum):
    LIMPIEZA = "Limpieza"
    BELLEZA = "Belleza"
    ELECTRODOMESTICOS = "Electrodomesticos"
    ALIMENTO = "Alimento"

class Producto:
    def __init__(self, nombre, tipo_producto, precio, stock, fecha_importacion):
        self.nombre = nombre
        self.precio = precio
        self.stock = stock
        self.fecha_importacion = fecha_importacion
        self.num_serie = self.generar_numero_serie()
        self.tipo_producto = tipo_producto
        self.comprado = False

    def get_nombre(self):
        return self.nombre

    def get_precio(self):
        return self.precio

    def get_stock(self):
        return self.stock

    def get_fecha_importacion(self):
        return self.fecha_importacion

    def get_num_serie(self):
        return self.num_serie

    def is_comprado(self):
        return self.comprado

    def set_comprado(self, comprado):
        self.comprado = comprado

    def get_tipo_producto(self):
        return self.tipo_producto

    def get_datos(self):
        return f"Nombre: {self.get_nombre()}\nPrecio: ${self.get_precio()}\nNúmero de serie: {self.get_num_serie()}\nFecha de importación: {self.get_fecha_importacion()}\nTipo de producto: {self.get_tipo_producto()}\nCantidad de productos: {self.get_stock()}"

    def set_stock(self, stock):
        self.stock = stock

    def generar_numero_serie(self):
        letra_nombre = self.get_nombre()[0]
        num = random.randint(100000, 999999)
        num_serie = f"{letra_nombre}-{num}"
        return num_serie