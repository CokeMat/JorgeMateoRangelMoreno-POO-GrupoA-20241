import random

class Visitant:
    __name = ""
    __lastname_f = ""
    __lastname_m = ""
    __birthdate = ""
    __register_date = ""
    __num_visits = 0
    __sex = ""
    __curp = ""
    __id = ""
    __active_visitant = False

    def __init__(self, name, lastname_f, lastname_m, birthdate, register_date, sex):
        self.__name = name.upper()
        self.__lastname_f = lastname_f.upper()
        self.__lastname_m = lastname_m.upper()
        self.__birthdate = birthdate
        self.__register_date = register_date
        self.__num_visits = 0
        self.__sex = sex
        self.__age = self.calculate_age()
        self.__active_visitant = False
        self.__curp = self.generate_curp()
        self.__id = self.generate_id()

    # Getters and setters
    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name.upper()
        self.__curp = self.generate_curp()

    def get_curp(self):
        return self.__curp
    
    def set_curp(self, curp):
        self.__curp = curp

    def get_birthdate(self):
        return self.__birthdate

    def set_birthdate(self, birthdate):
        self.__birthdate = birthdate
        self.__curp = self.generate_curp()
        self.__age = self.calculate_age()

    def get_register_date(self):
        return self.__register_date

    def set_register_date(self, register_date):
        self.__register_date = register_date

    def get_num_visits(self):
        return self.__num_visits

    def get_sex(self):
        return self.__sex

    def set_sex(self, sex):
        self.__sex = sex

    def get_age(self):
        return self.__age

    def get_lastname_f(self):
        return self.__lastname_f

    def set_lastname_f(self, lastname_f):
        self.__lastname_f = lastname_f.upper()
        self.__curp = self.generate_curp()

    def get_lastname_m(self):
        return self.__lastname_m

    def set_lastname_m(self, lastname_m):
        self.__lastname_m = lastname_m.upper()
        self.__curp = self.generate_curp()

    def get_id(self):
        return self.__id
    
    def set_id(self, ID):
        self.__ID = ID

    def is_active_visitant(self):
        return self.__active_visitant

    def set_active_visitant(self, active_visitant):
        self.__active_visitant = active_visitant

    # Métodoss auxiliares
    def get_full_name(self):
        return f"{self.__name} {self.__lastname_f} {self.__lastname_m}"

    def calculate_age(self):
        year = self.__birthdate[6:10]
        age = 2024 - int(year)
        return age

    def is_adult(self):
        if self.__age >= 18:
            return True
        else:
            return False

    def add_visit(self):
        self.__num_visits += 1

    def generate_id(self):
        cad = "V"
        letters_bank = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
        cad += random.choice(letters_bank)
        i = 0
        while i < 4:                
            cad += str(random.randint(0,9))
            i += 1
        return cad

    def generate_curp(self):
        last_name_f = self.__lastname_f[2]
        last_name_m = self.__lastname_m[1]
        name = self.__name[0]
        year = self.__birthdate[8:10]
        month = self.__birthdate[0:2]
        day = self.__birthdate[3:5]
        sex = "H" if self.__sex == "M" else "M"
        consonantes = ""
        for c in self.__lastname_f:
            if c not in ['A', 'E', 'I', 'O', 'U']:
                consonantes += c
                break
        for c in self.__lastname_m:
            if c not in ['A', 'E', 'I', 'O', 'U']:
                consonantes += c
                break
        for c in self.__name:
            if c not in ['A', 'E', 'I', 'O', 'U']:
                consonantes += c
                break
        n1 = random.randint(0, 9)
        n2 = random.randint(0, 9)
        return f"{last_name_f}{last_name_m}{name}{year}{month}{day}{sex}MIC{consonantes}{n1}{n2}"