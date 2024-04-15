import getpass

class Sistema:
    CONTRASENA_SEGURA = "%Pr0gr4m4c10n%"
    tienda = Tienda()

    def ejecutar_programa(self):
        es_contrasena_valida = False
        while not es_contrasena_valida:
            print("*** BIENVENIDO ***")
            print("Contraseña: %Pr0gr4m4c10n%")
            contrasena = getpass.getpass("Ingresa la contraseña: ")

            if contrasena == self.CONTRASENA_SEGURA:
                es_contrasena_valida = True
                self.ejecutar_menu_sistema()
            else:
                print("\nCONTRASEÑA INCORRECTA")

    def ejecutar_menu_sistema(self):
        opcion = 0

        while opcion != 4:
            print("\n--------T  I  E  N  D  A----------")
            print("BIENVENIDO A LA TIENDA")
            print("Seleccione una opción:\n")
            print("1. Productos")
            print("2. Clientes")
            print("3. Compras")
            print("4. Salir")
            opcion = int(input("\nOpcion: "))

            if opcion == 1:
                while True:
                    print("\nSelecciono la opción Producto")
                    print("---------P  R  O  D  U  C  T  O  S----------")
                    print("1. Registrar producto")
                    print("2. Eliminar producto")
                    print("3. Ver Productos")
                    print("4. Consultar informacion de un producto")
                    print("5. Volver al menu principal")
                    opcion_producto = int(input("\nOpción: "))
                    if opcion_producto == 5:
                        break

                    if opcion_producto == 1:
                        self.tienda.registrar_producto()
                    elif opcion_producto == 2:
                        self.tienda.eliminar_producto()
                    elif opcion_producto == 3:
                        self.tienda.mostrar_productos()
                    elif opcion_producto == 4:
                        self.tienda.mostrar_info_producto()
                    else:
                        print("Opcion invalida")

            elif opcion == 2:
                while True:
                    print("\nSelecciono la opción Clientes")
                    print("---------C  L  I  E  N  T  E  S----------")
                    print("1. Registrar cliente")
                    print("2. Eliminar cliente")
                    print("3. Ver clientes")
                    print("4. Consultar informacion de un cliente")
                    print("5. Volver al menu principal")
                    opcion_cliente = int(input("\nOpción: "))
                    if opcion_cliente == 5:
                        print("Volviendo al menu principal...")
                        break

                    if opcion_cliente == 1:
                        self.tienda.registrar_cliente()
                    elif opcion_cliente == 2:
                        self.tienda.eliminar_cliente()
                    elif opcion_cliente == 3:
                        self.tienda.mostrar_clientes()
                    elif opcion_cliente == 4:
                        self.tienda.mostrar_info_cliente()
                    else:
                        print("Opcion invalida")

            elif opcion == 3:
                while True:
                    print("\nSelecciono la opción Compras")
                    print("---------C  O  M  P  R  A  S----------")
                    print("1. Realizar un pedido")
                    print("2. Ver compras totales")
                    print("3. Ver compras de un cliente")
                    print("4. Ver compras totales de productos")
                    print("5. Volver al menu principal")
                    opcion_compras = int(input("\nOpción: "))
                    if opcion_compras == 5:
                        print("Volviendo al menu principal...")
                        break

                    if opcion_compras == 1:
                        self.tienda.realizar_pedido()
                    elif opcion_compras == 2:
                        self.tienda.ver_pedidos()
                    elif opcion_compras == 3:
                        self.tienda.ver_pedido_cliente()
                    elif opcion_compras == 4:
                        self.tienda.ventas_producto()
                    else:
                        print("Opcion invalida")

            elif opcion == 4:
                print("¡Vuelva pronto!")

            else:
                print("Opcion invalida, seleccione otra.")