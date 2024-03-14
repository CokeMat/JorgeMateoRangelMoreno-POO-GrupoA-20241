from Banco import Banco
print("Bienvenido al banco, seleccione una de las siguientes opciones:")
banco = Banco()

while True:
    print("** MENU   B A N C O **")
    print(f" 1. Mostrar Empleados\n 2. Mostrar detalles de un empleado\n 3. Agregar Usuario\n 4. Agregar cuenta a un Usuario\n 5. Depositar a una cuenta\n 6. Retirar dinero de una cuenta\n 7. Salir\n")
    opcion = int(input("Opcion: "))
    if opcion == 7:
        break

    if opcion == 1:
        banco.mostrar_empleados()
    elif opcion == 2:
        banco.mostrar_info_empleado()
    elif opcion == 3:
        banco.ingresar_datos()
    elif opcion == 4:
        banco.agregar_cuenta_empleado()
    elif opcion == 5:
        banco.depositar_dinero()
    elif opcion == 6:
        banco.retirar_dinero()
    else:
        print("No se selecciono ninguna de las opciones mostradas, vuelva a elegir.")
    print()

print("¡Hasta luego! Vuelva pronto.")