class BankAccount:
  __account_number=0
  __amount=0
  __type=''
  def __init__(self, account_number, type):
      self.__accountNumber = account_number
      self.__type = type
      self.__amount = 0

  def get_account_number(self):
      return self.__account_number

  def get_type(self):
      return self.__type

  def get_amount(self):
      return self.__amount

  def get_datos(self):
      print("Numero de cuenta:", self.get_account_number())
      print("Tipo de cuenta:", self.get_type())
      print("Cantidad de dinero: $", self.get_amount())
      return ""

  def agregar_dinero(self, amount):
      if self.__type == 'A':
          self.agregar_dinero_A(amount)
      elif self.__type == 'B':
          self.agregar_dinero_B(amount)
      else:
          self.__amount += amount

  def agregar_dinero_A(self, amount):
      if self.__amount + amount <= 50000:
          self.__amount += amount
      else:
          print("No puede tener más de $50,000 en una cuenta A")

  def agregar_dinero_B(self, amount):
      if self.__amount + amount <= 100000:
          self.__amount += amount
      else:
          print("No puede tener más de $100,000 en una cuenta B")

  def retirar_dinero(self, amount):
      if self.__type == 'A':
          self.retirar_dinero_A(amount)
      elif self.__type == 'B':
          self.retirar_dinero_B(amount)
      else:
          self.retirar_dinero_C(amount)
      return amount

  def retirar_dinero_A(self, amount):
      if self.__amount - amount >= 1000:
          self.__amount -= amount
      else:
          print("No puede tener menos de $1,000 en una cuenta A")

  def retirar_dinero_B(self, amount):
      if self.__amount - amount >= 5000:
          self.__amount -= amount
      else:
          print("No puede tener menos de $5,000 en una cuenta B")

  def retirar_dinero_C(self, amount):
      if self.__amount - amount >= 10000:
          self.__amount -= amount
      else:
          print("No puede tener menos de $10,000 en una cuenta C")