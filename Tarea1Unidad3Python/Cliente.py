import datetime
import random

class Cliente:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.edad = edad
        self.num_pedido = random.randint(1000, 9999)
        self.id = self.generar_id()
        self.productos_comprados = []
        self.compras = []
        self.fecha_pedido = datetime.date.today()
        self.compra_hecha = False

    def get_nombre(self):
        return self.nombre

    def get_id(self):
        return self.id

    def get_edad(self):
        return self.edad

    def get_numero_pedido(self):
        return self.num_pedido

    def get_fecha_pedido(self):
        return self.fecha_pedido

    def is_compra_hecha(self):
        return self.compra_hecha

    def set_compra_hecha(self, compra_hecha):
        self.compra_hecha = compra_hecha

    def get_productos_comprados(self, i):
        return str(self.compras[i])

    def generar_id(self):
        letra_nombre = self.get_nombre()[0]
        pedido = str(self.get_numero_pedido())
        self.set_id("C" + letra_nombre + "-" + pedido)
        return self.id

    def set_id(self, id):
        self.id = id

    def get_datos(self):
        print(f"ID: {self.get_id()}\nNombre: {self.get_nombre()}\nEdad: {self.get_edad()}\nNúmero de Pedido: {self.get_numero_pedido()}\nFecha del pedido: {self.get_fecha_pedido()}\nCompra realizada: {self.is_compra_hecha()}")

    def pedido(self, producto):
        self.productos_comprados.append(producto)