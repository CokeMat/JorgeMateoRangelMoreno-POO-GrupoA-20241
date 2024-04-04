import random

class Employee:
    __name = ""
    __lastname_f = ""
    __lastname_m = ""
    __birthdate = ""
    __register_date = ""
    __role = ""
    __schedule = ""
    __salary = ""
    __sex = ""
    __rfc = ""
    __curp = ""
    __id = ""
    __active_employee = False
    
    def __init__(self, name, lastname_f, lastname_m, birthdate, register_date, role, sex):
        self.__name = name.upper()
        self.__lastname_f = lastname_f.upper()
        self.__lastname_m = lastname_m.upper()
        self.__birthdate = birthdate
        self.__register_date = register_date
        self.__role = role
        self.__schedule = self.generate_schedule(role)
        self.__salary = self.generate_salary(role)
        self.__sex = sex
        self.__rfc = self.generate_rfc()
        self.__curp = self.generate_curp()
        self.__id = self.generate_id()
        self.__active_employee = False

    def generate_id(self):
        cad = "E"
        letters_bank = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"
        cad += random.choice(letters_bank)
        i = 0
        while i < 4:                
            cad += str(random.randint(0,9))
            i += 1
        return cad

    def get_full_name(self):
        return f"{self.__name} {self.__lastname_f} {self.__lastname_m}"

    def generate_schedule(self, role):
        if role == "Veterinary":
            return "09:00-18:00"
        elif role == "Guide":
            return "09:00-15:00"
        elif role == "Maintenance":
            return "17:00-21:00"
        elif role == "Administration":
            return "08:00-15:00"
        else:
            return "NULL"

    def generate_salary(self, role):
        if role == "Veterinary":
            return 14000
        elif role == "Guide":
            return 9000
        elif role == "Maintenance":
            return 5000
        elif role == "Administration":
            return 10000
        else:
            return -1

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

    def generate_rfc(self):
        last_name_f = self.__lastname_f[:2]
        last_name_m = self.__lastname_m[:1]
        name = self.__name[:1]
        year = self.__birthdate[8:10]
        month = self.__birthdate[0:2]
        day = self.__birthdate[3:5]
        n1 = random.randint(0, 9)
        n2 = random.randint(0, 9)
        letraAleatoria = chr(random.randint(65, 90))
        return f"{last_name_f}{last_name_m}{name}{year}{month}{day}{n1}{letraAleatoria}{n2}"

    # Getters and setters
    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name.upper()
        self.curp = self.generate_curp()
        self.rfc = self.generate_rfc()

    def get_lastname_f(self):
        return self.__lastname_f

    def set_lastname_f(self, lastname_f):
        self.__lastname_f = lastname_f.upper()
        self.curp = self.generate_curp()
        self.rfc = self.generate_rfc()

    def get_lastname_m(self):
        return self.__lastname_m

    def set_lastname_m(self, lastname_m):
        self.__lastname_m = lastname_m.upper()
        self.__curp = self.generate_curp()
        self.__rfc = self.generate_rfc()

    def get_birthdate(self):
        return self.__birthdate

    def set_birthdate(self, birthdate):
        self.__birthdate = birthdate
        self.__curp = self.generate_curp()
        self.__rfc = self.generate_rfc()

    def get_register_date(self):
        return self.__register_date

    def set_register_date(self, register_date):
        self.__register_date = register_date

    def get_role(self):
        return self.__role

    def set_role(self, role):
        self.__role = role

    def get_schedule(self):
        return self.__schedule

    def set_schedule(self, schedule):
        self.__schedule = schedule

    def get_sex(self):
        return self.__sex

    def set_sex(self, sex):
        self.__sex = sex
        self.__curp = self.generate_curp()
        self.__rfc = self.generate_rfc()

    def get_rfc(self):
        return self.__rfc

    def set_rfc(self, rfc):
        self.__rfc = rfc

    def get_curp(self):
        return self.__curp

    def set_curp(self, curp):
        self.__curp = curp

    def get_id(self):
        return self.__id
    
    def set_id(self, ID):
        self.__ID = ID

    def get_salary(self):
        return self.__salary

    def set_salary(self, salary):
        self.__salary = salary

    def is_active_employee(self):
        return self.__active_employee

    def set_active_employee(self, active_employee):
        self.__active_employee = active_employee
