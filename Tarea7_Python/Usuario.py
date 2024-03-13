class Usuario:
  __id=0
  __nombre=""
  __edad=0

  def __init__(self, nombre, id, edad):
    self.__nombre = nombre
    self.__id = id
    self.__edad = edad
    self.__libros_rentados = []

  def get_nombre(self):
    return self.__nombre

  def get_id(self):
    return self.__id

  def get_edad(self):
    return self.__edad

  def get_libros_rentados(self):
    for libro in self.__libros_rentados:
        print("Título del libro:", libro.get_nombre())
        print("Autor:", libro.get_autor())
        print("ID:", libro.get_id())
    return ""

  def get_datos(self):
    print("Nombre:", self.get_nombre())
    print("ID:", self.get_id())
    print("Edad:", self.get_edad())
    return ""

  def add_libro(self, libro):
    self.__libros_rentados.append(libro)