class Libro:
  __id=0
  __nombre=""
  __autor=""
  __es_rentado=False

  def __init__(self, nombre, autor, id):
     self.__id=id
     self.__nombre=nombre
     self.__autor=autor


  def get_nombre(self):
    return self.__nombre

  def get_autor(self):
    return self.__autor

  def get_id(self):
    return self.__id

  def es_rentado(self):
    return self.rentado

  def get_datos(self):
    print("Título del libro:", self.get_nombre())
    print("Autor:", self.get_autor())
    print("ID:", self.get_id())
    return ""

  def set_rentado(self, rentado):
    self.rentado = rentado