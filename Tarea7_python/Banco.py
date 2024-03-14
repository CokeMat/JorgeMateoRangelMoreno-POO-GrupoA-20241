import random
from Employee import Employee
from BanckAccount import BankAccount
class Banco:
  
  __employee_list = []
      

  def ingresar_datos(self):
      print("-Nombre:")
      name = input()
      print("-Apellido:")
      lastName = input()
      employee = Employee(name, lastName)
      self.__employee_list.append(employee)
      print("Se han registrado con éxito los datos")
      print("****************")

  def mostrar_empleados(self):
      if not self.__employee_list:
          print("*****  V  A  C  I  O  ******")
          print("Agregue un usuario con la opción '3'")
      else:
          i = 0
          for employee in self.__employee_list:
              print(f"Empleado {i + 1}: {employee.get_full_name()}")
              i += 1

  def mostrar_info_empleado(self):
      if not self.__employee_list:
          print("*****  V  A  C  I  O  ******")
          print("Agregue un usuario con la opción '3'")
      else:
          print("¿De cuál empleado te gustaría saber su información?:")
          i = int(input())
          if i > len(self.__employee_list):
              print("No se ha encontrado ningún empleado con ese número")
          else:
              employee = self.__employee_list[i - 1]
              print(f"Empleado: {employee.get_full_name()}")
              for account in employee.get_account_list():
                  print(account.get_datos())

  def depositar_dinero(self):
      if not self.__employee_list:
          print("*****  V  A  C  I  O  ******")
          print("No hay cuenta a la que depositar")
      else:
          print("¿A qué empleado te gustaría depositar?:")
          i = int(input())
          if i > len(self.__employee_list):
              print("No se ha encontrado el empleado")
          else:
              employee = self.__employee_list[i - 1]
              print("¿A qué cuenta te gustaría depositar?:")
              j = int(input())
              if j > len(employee.get_account_list()):
                  print("No se ha encontrado la cuenta")
              else:
                  account = employee.get_account_list()[j - 1]
                  print("¿Cuánto desea depositar?")
                  amount = float(input())
                  account.agregar_dinero(amount)
                  print("Se realizó el depósito con éxito.")

  def agregar_cuenta_empleado(self):
      if not self.__employee_list:
          print("*****  V  A  C  I  O  ******")
          print("No hay empleado al que agregar una cuenta")
      else:
          print("¿A qué empleado te gustaría agregar una cuenta?:")
          i = int(input())
          if i > len(self.__employee_list):
              print("No se ha encontrado al empleado")
          else:
              account_number = random.randint(100000, 999999)
              print("Tipo de cuenta que desea agregar (A, B o C): ")
              type = input()[0].upper()
              account = BankAccount(account_number, type)
              employee = self.__employee_list[i - 1]
              employee.add_account(account)
              print("Se ha registrado con éxito la cuenta")
              print("****************")

  def retirar_dinero(self):
      if not self.__employee_list:
          print("*****  V  A  C  I  O  ******")
          print("No hay cuenta de la que retirar dinero")
      else:
          print("¿De qué empleado te gustaría retirar dinero?:")
          i = int(input())
          if i > len(self.__employee_list):
              print("No se ha encontrado el empleado")
          else:
              employee = self.__employee_list[i - 1]
              print("¿De qué cuenta te gustaría retirar dinero?:")
              j = int(input())
              if j > len(employee.get_account_list()):
                  print("No se ha encontrado la cuenta")
              else:
                  account = employee.get_account_list()[j - 1]
                  print("¿Cuánto desea retirar?")
                  amount = float(input())
                  account.retirar_dinero(amount)
                  print("Se realizó el retiro con éxito.")