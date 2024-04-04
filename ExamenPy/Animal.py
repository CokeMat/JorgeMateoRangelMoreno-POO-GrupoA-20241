import random

class Animal:
    __name = ""
    __animal_type = ""
    __food_type = ""
    __food_frequency = ""
    __birthdate = ""
    __register_date = ""
    __weight = 0.0
    __diseases = []
    __is_vaccinated = False
    __active_animal = False
    __ID = ""

    def __init__(self, name, animal_type, food_type, food_frequency, weight, birthdate, 
                 register_date, is_vaccinated, diseases):
        self.__name = name
        self.__animal_type = animal_type
        self.__food_type = food_type
        self.__food_frequency = food_frequency
        self.__weight = weight
        self.__birthdate = birthdate
        self.__register_date = register_date
        self.__is_vaccinated = is_vaccinated
        self.__diseases = diseases
        self.__ID = self.generate_id()

    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name

    def get_animal_type(self):
        return self.__animal_type

    def set_animal_type(self, animal_type):
        self.__animal_type = animal_type

    def get_food_type(self):
        return self.__food_type

    def set_food_type(self, food_type):
        self.__food_type = food_type

    def get_food_frequency(self):
        return self.__food_frequency

    def set_food_frequency(self, food_frequency):
        self.__food_frequency = food_frequency

    def get_birthdate(self):
        return self.__birthdate

    def set_birthdate(self, birthdate):
        self.__birthdate = birthdate

    def get_register_date(self):
        return self.__register_date

    def set_register_date(self, register_date):
        self._register__date = register_date

    def get_weight(self):
        return self.__weight

    def set_weight(self, weight):
        self.__weight = weight

    def get_diseases(self):
        return self.__diseases

    def set_diseases(self, diseases):
        self._diseases = diseases

    def is_vaccinated(self):
        return self.__is_vaccinated

    def set_vaccinated(self, is_vaccinated):
        self.__is_vaccinated = is_vaccinated

    def get_id(self):
        return self.__ID
    
    def set_id(self, ID):
        self.__ID = ID

    def is_active_animal(self):
        return self.__active_animal

    def set_active_animal(self, active_animal):
        self.__active_animal = active_animal

    def generate_id(self):
        cad = "A"
        letters_bank = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
        cad += random.choice(letters_bank)
        i = 0
        while i < 4:                
            cad += str(random.randint(0,9))
            i += 1
        return cad
            
    def show_diseases_list(self):
        if not self.__diseases:
            print("\nThis animal doesn't have any diseases")
        else:
            n = 1
            print("\n-------------------DISEASES LIST-------------------")
            for disease in self.__diseases:
                print(f"\n{n}. {disease}")
                n += 1
