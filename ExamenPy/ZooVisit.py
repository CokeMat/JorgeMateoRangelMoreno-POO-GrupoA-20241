import random
from Employee import Employee
from Visitant import Visitant

class ZooVisit:
    __visit_date = ""
    __visitant_list = []
    __amount = 0.0
    __num_child = 0
    __num_adult = 0
    __ID = ""
    
    def __init__(self, guide, visit_date, visitant_list):
        self.__guide = guide
        self.__guide.set_active_employee(True)
        self.__visit_date = visit_date
        self.__visitant_list = visitant_list
        for visitant in self.__visitant_list:
            visitant.set_active_visitant(True)
        self.calculate_num_adult()
        self.calculate_num_child()
        self.calculate_amount()
        self.__ID = self.generate_id()

    # GETTERS AND SETTERS
    def get_guide(self):
        return self.__guide
    def get_visitant_list(self):
        return self.__visitant_list
    def get_amount(self):
        return self.__amount
    def get_visit_date(self):
        return self.__visit_date
    def get_num_child(self):
        return self.__num_child
    def get_num_adult(self):
        return self.__num_adult
    def get_id(self):
        return self.__ID
    def set_id(self, ID):
        self.__ID = ID 

    def activate_visitants(self):
        for visitant in self.__visitant_list:
            visitant.set_active_visitant(True)

    def calculate_num_adult(self):
        for visitant in self.__visitant_list:
            if visitant.is_adult():
                self.__num_adult += 1

    def calculate_num_child(self):
        self.__num_child = len(self.__visitant_list) - self.__num_adult

    def calculate_amount(self):
        for visitant in self.__visitant_list:
            visitant.add_visit()
            if visitant.is_adult():
                if visitant.get_num_visits() % 5 == 0:
                    self.__amount += 80
                else:
                    self.__amount += 100
            else:
                self.__amount += 50

    def generate_id(self):
        cad = "ZV"
        letters_bank = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
        cad += random.choice(letters_bank)
        i = 0
        while i < 4:                
            cad += str(random.randint(0,9))
            i += 1
        return cad