from Libreria import Libreria

print("Bienvenido a la libreria, seleccione una de las siguientes opciones:")
libreria = Libreria()

while True:
    print("** MENU   L I B R E R I A **")
    print(f" 1. Mostrar Usuarios\n 2. Mostrar Libros\n 3. Registrar Usuario\n 4. Registrar Libros\n 5. Rentar un libro\n 6. Mostrar libros rentados\n 7. Mostrar libros disponibles\n 8. Usuarios con libros\n 9. Salir\n")
    opcion = int(input("Opcion: "))
    if opcion == 9:
        break
    elif opcion == 1:
        libreria.mostrar_empleados()
    elif opcion == 2:
        libreria.mostrar_libros()
    elif opcion == 3:
        libreria.agregar_usuarios()
    elif opcion == 4:
        libreria.agregar_libros()
    elif opcion == 5:
        libreria.rentar_libros()
    elif opcion == 6:
        libreria.mostrar_libros_rentados()
    elif opcion == 7:
        libreria.mostrar_libros_disponibles()
    elif opcion == 8:
        libreria.mostrar_usuarios_libros()
    else:
        print("No se selecciono ninguna de las opciones mostradas, vuelva a elegir.")

print("¡Hasta luego! Vuelva pronto.")