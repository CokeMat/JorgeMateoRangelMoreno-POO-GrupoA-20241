from Cliente import Cliente
from Producto import Enum, tipoProducto
from datetime import datetime
from Alimento import Alimento
from Electrodomesticos import Electrodomesticos
from Belleza import Belleza
from Limpieza import Limpieza

class Tienda:
    def __init__(self):
        self.clientes = []
        self.productos = []
        self.total_productos = 0
        self.stock_incial = 0

    def get_stock_incial(self):
        return self.stock_incial

    def set_stock_incial(self, stock_incial):
        self.stock_incial = stock_incial

    def get_total(self):
        return self.total_productos

    def set_total(self, total):
        self.total_productos = total

    def registrar_producto(self):
        datos_comun = []
        print("¿Qué producto desea registrar?")
        print("1. Limpieza\n2. Belleza\n3. Alimento\n4. Electrodomestico")
        op_producto = int(input("Opcion: "))
        if op_producto < 5:
            print("**** N U E V O   P R O D U C T O ****")
            nombre = input("Ingresa el nombre: ")
            datos_comun.append(nombre)

            precio = float(input("Ingresa el precio: "))
            datos_comun.append(str(precio))

            fecha_importacion = input("Ingresa la fecha de importación: ")
            datos_comun.append(fecha_importacion)

            stock = int(input("Ingresa el stock: "))
            self.set_stock_incial(stock)
            self.set_total(stock + self.get_total())
            datos_comun.append(str(stock))

        if op_producto == 1:
            self.registrar_producto_limpieza(datos_comun)
        elif op_producto == 2:
            self.registrar_producto_belleza(datos_comun)
        elif op_producto == 3:
            self.registrar_producto_alimento(datos_comun)
        elif op_producto == 4:
            self.registrar_producto_elec(datos_comun)
        else:
            print("Opción invalida")

    def eliminar_producto(self):
        print("**** E L I M I N A R   P R O D U C T O ****")
        if not self.productos:
            print("No hay productos para eliminar de la lista")
        else:
            self.mostrar_productos()
            enter_num_serie = input("Ingrese el numero de serie del producto: ")
            for producto in self.productos:
                if producto.get_num_serie() == enter_num_serie:
                    if not producto.is_comprado():
                        self.productos.remove(producto)
                        print("El producto ha sido removido exitosamente")
                    else:
                        print("No se puede eliminar a este producto debido a que ya ha sido registrado en una compra, elija otro")
                    break
            else:
                print("No se ha encontrado un producto con el Numero de serie introducido.")

    def mostrar_info_producto(self):
        print("**** I N F O   P R O D U C T O ****")
        if not self.productos:
            print("No hay productos registrados en la lista")
        else:
            self.mostrar_productos()
            enter_num_serie = input("Ingrese el número de serie del producto: ")
            encontrado = False
            for producto in self.productos:
                if producto.get_num_serie() == enter_num_serie:
                    producto.get_datos()
                    encontrado = True
                    break
            if not encontrado:
                print("No se ha encontrado un producto con el número de serie introducido.")

    def mostrar_productos(self):
        print("**** L I S T A   P R O D U C T O S ****")
        if not self.productos:
            print("No hay productos registrados")
        else:
            self.mostrar_limpieza()
            self.mostrar_alimento()
            self.mostrar_belleza()
            self.mostrar_elec()
            print("Total productos registrados: ", len(self.productos))
            print("Total de productos: ", self.get_total())

    def mostrar_limpieza(self):
        print("** Limpieza **")
        i = 0
        for producto in self.productos:
            if producto.get_tipo_producto() == tipoProducto.LIMPIEZA:
                i += 1
                print(f"{i}. Nombre: {producto.get_nombre()}\n   Numero de Serie: {producto.get_num_serie()}\n   Precio: ${producto.get_precio():.2f}\n   Stock: {producto.get_stock()}")

    def mostrar_belleza(self):
        print("** Belleza **")
        i = 0
        for producto in self.productos:
            if producto.get_tipo_producto() == tipoProducto.BELLEZA:
                i += 1
                print(f"{i}. Nombre: {producto.get_nombre()}\n   Numero de Serie: {producto.get_num_serie()}\n   Precio: ${producto.get_precio():.2f}\n   Stock: {producto.get_stock()}")

    def mostrar_alimento(self):
        print("** Alimento **")
        i = 0
        for producto in self.productos:
            if producto.get_tipo_producto() == tipoProducto.ALIMENTO:
                i += 1
                print(f"{i}. Nombre: {producto.get_nombre()}\n   Numero de Serie: {producto.get_num_serie()}\n   Precio: ${producto.get_precio():.2f}\n   Stock: {producto.get_stock()}")

    def mostrar_elec(self):
        print("** Electrodomesticos **")
        i = 0
        for producto in self.productos:
            if producto.get_tipo_producto() == tipoProducto.ELECTRODOMESTICOS:
                i += 1
                print(f"{i}. Nombre: {producto.get_nombre()}\n   Numero de Serie: {producto.get_num_serie()}\n   Precio: ${producto.get_precio():.2f}\n   Stock: {producto.get_stock()}")

    def registrar_producto_limpieza(self, datos_comun):
        print("** Limpieza **")
        nombre = datos_comun[0]
        precio = float(datos_comun[1])
        fecha_importacion = datos_comun[2]
        stock = int(datos_comun[3])
        marca = input("Ingresa la marca: ")
        num_serie = ""
        limpieza = Limpieza(nombre, precio, stock, fecha_importacion, num_serie, marca)
        self.productos.append(limpieza)
        print("Producto Registrado")

    def registrar_producto_belleza(self, datos_comun):
        print("** Belleza **")
        nombre = datos_comun[0]
        precio = float(datos_comun[1])
        fecha_importacion = datos_comun[2]
        stock = int(datos_comun[3])
        marca = input("Ingresa la marca: ")
        num_serie = ""
        belleza = Belleza(nombre, precio, stock, fecha_importacion, num_serie, marca)
        self.productos.append(belleza)
        print("Producto Registrado")

    def registrar_producto_alimento(self, datos_comun):
        print("** Alimento **")
        nombre = datos_comun[0]
        precio = float(datos_comun[1])
        fecha_importacion = datos_comun[2]
        stock = int(datos_comun[3])
        num_serie = ""
        fecha_caducidad = self.set_fecha_caducidad()
        alimento = Alimento(nombre, precio, stock, fecha_importacion, num_serie, fecha_caducidad)
        self.productos.append(alimento)
        print("Producto Registrado")

    def set_fecha_caducidad(self):
        print("Ingresa la fecha de caducidad: ")
        a = int(input("Año: "))
        m = int(input("Mes: "))
        d = int(input("Día: "))
        fecha_caducidad = datetime(a, m, d)
        return fecha_caducidad

    def registrar_producto_elec(self, datos_comun):
        print("** Electrodomesticos **")
        nombre = datos_comun[0]
        precio = float(datos_comun[1])
        fecha_importacion = datos_comun[2]
        stock = int(datos_comun[3])
        marca = input("Ingresa la marca: ")
        num_serie = ""
        electrodomesticos = Electrodomesticos(nombre, precio, stock, fecha_importacion, num_serie, marca)
        self.productos.append(electrodomesticos)
        print("Producto Registrado")

    def registrar_cliente(self):
        print("**** N U E V O   C L I E N T E ****")
        nombre = input("Nombre: ")
        edad = int(input("Edad: "))
        cliente = Cliente(nombre, edad)
        self.clientes.append(cliente)
        print("Se registro con exito al cliente")

    def eliminar_cliente(self):
        print("**** E L I M I N A R   C L I E N T E ****")
        if not self.clientes:
            print("No hay clientes para eliminar de la lista")
        else:
            print("¿Qué cliente desea eliminar?")
            self.mostrar_clientes()
            op_eliminar = int(input())
            if self.clientes[op_eliminar].is_compra_hecha():
                print("No se puede eliminar a este cliente debido a que ya ha realizado una compra, elija otro")
            else:
                self.clientes.pop(op_eliminar)
                print("El cliente ha sido removido exitosamente.")

    def mostrar_clientes(self):
        print("**** L I S T A   C L I E N T E S ****")
        if not self.clientes:
            print("No hay clientes registrados")
        else:
            for i, cliente in enumerate(self.clientes, start=1):
                print(f"{i}. Nombre: {cliente.get_nombre()}\n   ID: {cliente.get_id()}")

    def mostrar_info_cliente(self):
        print("**** I N F O   C L I E N T E S ****")
        if not self.clientes:
            print("No hay clientes registrados")
        else:
            self.mostrar_clientes()
            op_cliente = int(input("¿De cual cliente quiere ver su informacion?"))
            self.clientes[op_cliente - 1].get_datos()

    def realizar_pedido(self):
        print("**** R E G I S T R O    P E D I D O S ****")
        if not self.clientes:
            print("No hay clientes registrados")
        elif not self.productos:
            print("No hay productos registrados")
        else:
            self.mostrar_clientes()
            op_cliente = int(input("¿Qué cliente desea realizar un pedido?"))
            total = 0
            num_productos = 0
            while True:
                self.mostrar_productos()
                id_producto = input("Ingrese el ID del producto que desea agregar: ")
                if id_producto == "0":
                    break
                for producto in self.productos:
                    if producto.get_num_serie() == id_producto:
                        if producto.get_stock() == 0:
                            print(f"Ya no quedan productos de {producto.get_nombre()}, elija otro.")
                        else:
                            producto_solicitado = int(input(f"¿Cuantos {producto.get_nombre()} desea?"))
                            total += producto.get_precio()
                            num_productos += producto_solicitado
                            self.clientes[op_cliente - 1].pedido(producto)
                            producto.set_stock(producto.get_stock() - producto_solicitado)
                            self.set_total(self.get_total() - producto_solicitado)
                            self.clientes[op_cliente - 1].set_compra_hecha(True)
                            producto.set_comprado(True)
                else:
                    print("No se ha encontrado un producto con el Numero de serie introducido.")
                print("Cuando ya haya terminado de agregar productos ingrese 0.")

    def ver_pedidos(self):
        print("**** P E D I D O S   T O T A L E S ****")
        if not self.clientes:
            print("No hay pedidos registrados")
        else:
            i = 0
            for cliente in self.clientes:
                if cliente.is_compra_hecha():
                    i += 1
                    print(f"{i}.\n{cliente.get_nombre()}\n{cliente.get_numero_pedido()}")
            print("Total de pedidos: ", i)

    def ver_pedido_cliente(self):
        print("**** V E R    P E D I D O S    C L I E N T E ****")
        if not self.clientes:
            print("No hay pedidos registrados")
        else:
            self.mostrar_clientes()
            i = int(input("¿De que cliente quiere ver su pedido?"))
            if self.clientes[i - 1].is_compra_hecha():
                print(f"{i}.\nNombre: {self.clientes[i - 1].get_nombre()}\nNumero de Pedido: {self.clientes[i - 1].get_numero_pedido()}\nPedido: {self.clientes[i - 1].get_productos_comprados(i - 1)}")
            else:
                print("Este cliente no ha realizado ninguna compra.")

    def ventas_producto(self):
        print("**** V E N T A S    P R O D U C T O ****")
        i = 0
        total_productos = 0
        cant_total_tienda = 0
        for producto in self.productos:
            i += 1
            num_productos_vendidos = self.get_stock_incial() - producto.get_stock()
            cant_total_producto = num_productos_vendidos * producto.get_precio()
            total_productos += num_productos_vendidos
            cant_total_tienda += cant_total_producto
            print(f"{i}. Producto: {producto.get_nombre()}\n   Vendidos: {num_productos_vendidos}\n   Total Vendido: ${cant_total_producto:.2f}")
        print("Total de productos vendidos de la tienda: ", total_productos)
        print("Total de dinero: ", cant_total_tienda)
