from random import randint
from Usuario import Usuario
from Libro import Libro


class Libreria:
  __usuarios=[]
  __libros=[]

  def __init__(self):
    self.__usuarios = []
    self.__libros = []

  def mostrar_empleados(self):
    if not self.__usuarios:
        print("*****  V  A  C  I  O  ******")
        print("Agregue un usuario con la opción '3'")
    else:
        i = 0
        for usuario in self.__usuarios:
            print(f"Usuario {i + 1}:")
            print(usuario.get_datos())
            i += 1

  def mostrar_libros(self):
    if not self.__libros:
        print("*****  V  A  C  I  O  ******")
        print("No hay libros registrados")
    else:
        i = 0
        for libro in self.__libros:
            print(f"Libro {i + 1}:")
            print(libro.get_datos())
            i += 1

  def agregar_usuarios(self):
    id = randint(100000, 999999)
    print("-Nombre:")
    name = input()
    print("-Edad:")
    edad = int(input())
    usuario = Usuario(name, id, edad)
    self.__usuarios.append(usuario)
    print("Se han registrado con éxito los datos")
    print("****************")

  def agregar_libros(self):
    id =randint(100000, 999999)
    print("-Nombre:")
    name = input()
    print("-Autor:")
    autor = input()
    libro = Libro(name, autor, id)
    self.__libros.append(libro)
    print("Se han registrado con éxito los datos")
    print("****************")

  def rentar_libros(self):
    if not self.__libros:
        print("*****  V  A  C  I  O  ******")
        print("No hay libros para rentar.")
    else:
        print("¿Qué empleado es el que va a rentar un libro?")
        self.mostrar_empleados()
        i = int(input())
        if i > len(self.__usuarios):
            print("No se ha encontrado el empleado.")
        else:
            print("¿Qué libro le gustaría rentar?")
            self.mostrar_libros()
            j = int(input())
            if j > len(self.__libros):
                print("No se ha encontrado el libro ingresado.")
            else:
                libro = self.__libros[j - 1]
                if libro.es_rentado():
                    print("El libro ya ha sido rentado.")
                else:
                    libro.set_rentado(True)
                    usuario = self.__usuarios[i - 1]
                    usuario.add_libro(libro)
                    print("Libro rentado con éxito.")

  def mostrar_libros_rentados(self):
    if not self.__libros:
        print("*****  V  A  C  I  O  ******")
        print("No hay libros registrados")
    else:
        i = 0
        print("Libros rentados:")
        for libro in self.__libros:
            if libro.es_rentado():
                print(f"Libro {i + 1}:")
                print(libro.get_datos())
            i += 1

  def mostrar_libros_disponibles(self):
    if not self.__libros:
        print("*****  V  A  C  I  O  ******")
        print("No hay libros registrados")
    else:
        i = 0
        print("Libros disponibles:")
        for libro in self.__libros:
            if not libro.es_rentado():
                print(f"Libro {i + 1}:")
                print(libro.get_datos())
            i += 1

  def mostrar_usuarios_libros(self):
    if not self.__usuarios:
        print("*****  V  A  C  I  O  ******")
        print("Ningún usuario ha rentado un libro")
    else:
        i = 0
        for usuario in self.__usuarios:
            print("Libros rentados por el usuario")
            print(f"Usuario {i + 1}:")
            print(usuario.get_datos())
            print(usuario.get_libros_rentados())
            print("***********************")
            i += 1