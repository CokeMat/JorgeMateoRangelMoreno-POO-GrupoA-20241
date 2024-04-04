from Animal import Animal
from Employee import Employee
import random

class Maintenance:
    __action = ""
    __date = ""
    __observation = ""
    __animal_id = ""
    __id = ""

    def __init__(self, maintenance_employee, date, action, animal_id, observation):
        self.__maintenance_employee = maintenance_employee
        self.__maintenance_employee.set_active_employee(True)
        self.__action = action
        self.__date = date
        self.__observation = observation
        self.__animal_id = animal_id
        self.__id = self.generate_id()

    def get_action(self):
        return self.__action

    def set_action(self, action):
        self.__action = action

    def get_date(self):
        return self.__date

    def set_date(self, date):
        self.__date = date

    def get_observation(self):
        return self.__observation

    def set_observation(self, observation):
        self.__observation = observation

    def get_animal_id(self):
        return self.__animal_id

    def get_maintenance_employee(self):
        return self.__maintenance_employee

    def set_maintenance_employee(self, maintenance_employee):
        self.__maintenance_employee = maintenance_employee

    def get_id(self):
        return self.__id
    
    def set_id(self, id):
        self.__id = id

    def generate_id(self):
        cad = "M"
        letters_bank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        numbers_bank = "0123456789"

        cad += random.choice(letters_bank)
        i = 0
        while i < 4:
            cad += random.choice(numbers_bank)
            i += 1

        return cad