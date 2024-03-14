class Employee:
  __name=""
  __last_name=""
  __account_list=[]
  
  def __init__(self, name, last_name):
      self.__name = name
      self.__lastName = last_name
      self.__account_list = []

  def get_name(self):
      return self.__name

  def get_last_name(self):
      return self.__last_name

  def get_full_name(self):
      print(self.__name + " " + self.__last_name)
      return ""

  def get_account_list(self):
      return self.__account_list

  def add_account(self, account):
      self.__account_list.append(account)

  def get_datos_usuario(self):
      print("Titular de la cuenta:", self.get_name(), self.get_last_name())
      for account in self.__account_list:
          print(account.get_datos())
      return ""