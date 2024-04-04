from ZooVisit import ZooVisit
from Visitant import Visitant
from Employee import Employee
from Animal import Animal
from Maintenance import Maintenance
import random

class Zoo:
    def __init__(self):
        self.__employee_list = []
        self.__visitant_list = []
        self.__animal_list = []
        self.__maintenance_list = []
        self.__zoo_visit_list = []
        
    """def prueba(self):
        self.__visitant_list.append(Visitant("Edgar", "Martinez", "Lopez", "22/11/2005", "20/04/2018", "M"))
        self.__visitant_list.append(Visitant("Gabriel", "Chacon", "Arellano", "11/05/2005", "12/04/2010", "M"))
        self.__visitant_list.append(Visitant("Juana", "Lopez", "Hernandez", "22/11/2008", "20/04/2014", "F"))
        self.__visitant_list.append(Visitant("Jorge", "Rangel", "Moreno", "22/11/2005", "15/12/2024", "M"))
        self.__visitant_list.append(Visitant("Ximena", "Baltierra", "Lopez", "16/06/2006", "30/01/2024", "F"))
        self.__visitant_list.append(Visitant("Leo", "Messi", "Cuchittini", "14/06/1986", "20/04/2018", "M"))
        self.__visitant_list.append(Visitant("Pepito", "Rangel", "Moreno", "22/11/2010", "15/12/2024", "M"))
        self.__visitant_list.append(Visitant("Luisito", "Baltierra", "Lopez", "16/06/2012", "30/01/2024", "F"))
        self.__visitant_list.append(Visitant("Pedrito", "Messi", "Cuchittini", "14/06/2008", "20/04/2018", "M"))

        self.__employee_list.append(Employee("Juanito", "Perez", "Dominguez", "22/11/2005", "20/04/2012", "Guide", "M"))
        self.__employee_list.append(Employee("Cristiano", "Dosantos", "Aveiro", "10/11/1995", "25/11/2014", "Veterinary", "F"))
        self.__employee_list.append(Employee("Erling", "Braul", "Halland", "22/01/1989", "27/05/2020", "Guide", "M"))
        self.__employee_list.append(Employee("Neymar", "Dosantos", "Jr", "16/04/1970", "30/01/2012", "Maintenance", "M"))
        self.__employee_list.append(Employee("Thomas", "Muller", "Poll", "01/01/1969", "31/06/2018", "Veterinary", "F"))
        self.__employee_list.append(Employee("Herry", "LaBomba", "Martin", "20/10/2000", "10/07/2021", "Maintenance", "M"))
        
        arreglo_enfermedades1 = ["Enfermedad1", "Enfermedad2", "Enfermedad3", "Enfermedad4", "Enfermedad5"]
        arreglo_enfermedades2 = []

        self.__animal_list.append(Animal("Toby", "Vertebrado", "Carne", "Diario" ,90.56, "04/06/1999", "08/11/2004", True, arreglo_enfermedades1))
        self.__animal_list.append(Animal("Jorge", "Vertebrado", "Carne",  "Diario" ,90.56, "04/06/1999", "08/11/2004", True, arreglo_enfermedades2))
        self.__animal_list.append(Animal("Toby", "invertebrado", "Vegetariano",  "Diario" ,100.56, "20/05/1998", "08/11/2014", True, arreglo_enfermedades2))
        self.__animal_list.append(Animal("Max", "anélido", "Carne",  "Diario" ,10.56, "04/04/2001", "08/11/2012", False, arreglo_enfermedades1))
        self.__animal_list.append(Animal("Mabappe", "poriferos", "Carne",  "Diario" ,90.56, "04/06/2000", "08/11/2018", False, arreglo_enfermedades1))
        self.__animal_list.append(Animal("Duck", "Vertebrado", "plantas",  "Diario" ,10.00, "04/06/2018", "12/05/2012", True, arreglo_enfermedades2))
    """

    def add_employee(self):
        while True:
            name = self.ask_name("NAME")
            if not self.valid_name(name):
                print("Invalid name inserted")
                break
            lastname_f = self.ask_name("FATHER'S LASTNAME")
            if not self.valid_name(lastname_f):
                print("Invalid father's lastname inserted")
                break
            lastname_m = self.ask_name("MOTHER'S LASTNAME")
            if not self.valid_name(lastname_m):
                print("Invalid mother's lastname inserted")
                break
            sex = self.ask_sex()
            if not self.valid_sex(sex):
                print("Invalid sex inserted")
                break
            birthdate = self.ask_date("BIRTHDATE")
            if not self.valid_date(birthdate):
                print("Invalid date inserted")
                break
            register_date = self.ask_date("REGISTER DATE")
            if not self.valid_date(register_date):
                print("Invalid date inserted")
                break
            role = self.ask_role()
            if role == "NOVALID":
                print("Invalid option")
                break
            self.__employee_list.append(Employee(name, lastname_f, lastname_m, birthdate, register_date, role, sex))
            print("Employee added successfully!")
            break

    def add_visitant(self):
        while True:
            name = self.ask_name("NAME")
            if not self.valid_name(name):
                print("Invalid name inserted")
                break
            lastname_f = self.ask_name("FATHER'S LASTNAME")
            if not self.valid_name(lastname_f):
                print("Invalid father's lastname inserted")
                break
            lastname_m = self.ask_name("MOTHER'S LASTNAME")
            if not self.valid_name(lastname_m):
                print("Invalid mother's lastname inserted")
                break
            sex = self.ask_sex()
            if not self.valid_sex(sex):
                print("Invalid sex inserted")
                break
            birthdate = self.ask_date("BIRTHDATE")
            if not self.valid_date(birthdate):
                print("Invalid date inserted")
                break
            register_date = self.ask_date("REGISTER DATE")
            if not self.valid_date(register_date):
                print("Invalid date inserted")
                break
            self.__visitant_list.append(Visitant(name, lastname_f, lastname_m, birthdate, register_date, sex))
            print("Visitant added successfully!")
            break


    def add_animal(self):
        while True:
            print("INSERT THE NAME")
            name = input()
            print("INSERT THE ANIMAL TYPE")
            animal_type = input()
            print("INSERT THE ANIMAL'S FOOD TYPE")
            food_type = input()
            print("INSERT THE FOOD FREQUENCY")
            food_frequency = input()
            bithdate = self.ask_date("BIRTHDATE")
            if not self.valid_date(bithdate):
                print("Invalid date inserted")
                break
            register_date = self.ask_date("REGISTER DATE")
            if not self.valid_date(register_date):
                print("Invalid date inserted")
                break
            print("INSERT THE WEIGHT")
            weight = float(input())

            is_vaccinated = None
            print("IS THE ANIMAL VACCINATED?(Y/N)")
            answer = input().upper()
            if answer == "Y":
                is_vaccinated = True
            elif answer == "N":
                is_vaccinated = False
            else:
                print("Invalid option")
                break

            diseases = []
            print("Does the animal have any diseases?")
            if input().upper() == "Y":
                while True:
                    print("Insert the disease")
                    diseases.append(input())
                    print("Do you want to register another disease?")
                    if input().upper() == "N":
                        break
                    
            self.__animal_list.append(Animal(name, animal_type, food_type, food_frequency, weight, bithdate, register_date, is_vaccinated, diseases))
            print("Animal added successfully!!")
            break

    def add_zoo_visit(self):
        while True:
        # PARA EL GUÍA(1)
            if self.have_guides():
                print("--------THESE ARE THE GUIDES AVAILABLE--------")
                for employee in self.__employee_list:
                    if employee.get_role() == "Guide":
                        print("| NAME: {} | ID: {} |".format(employee.get_full_name(), employee.get_id()))
                print("Insert the ID of the guide: ")
                ID = input()
                if self.valid_id('E', ID):
                    i = self.get_index('E', ID)
                    guide = self.__employee_list[i]
                else:
                    print("Invalid ID inserted")
                    break
            else:
                print("There are not guides registered, to register a zoo visit it must exist at least one guide in the system.")
                break
            # PARA LA FECHA
            date = self.ask_date("DATE OF THE VISIT")
            if not self.valid_date(date):
                print("Invalid date inserted")
                break
            # PARA LLOS VISITANTES(1...N)
            # SI YA AGREGÓ UN VISITANTE QUE NO LO PUEDA VOLVER A AGREGAR
            zoo_visitants = []
            if len(self.__visitant_list) == 0:
                print("There are not visitants registered")
                break
            else:
                # HACER UN ARREGLO CON TODOS LOS ID QUE ELIJA, CUANDO TERMINE AGREGARLOS TODOS AL ARRAYLIST DE ZOOVISIT
                # AGREGAR AL PRIMER VISITANTE
                ID = self.ask_id('V')
                if self.valid_id('V', ID):
                    zoo_visitants.append(self.__visitant_list[self.get_index('V', ID)])
                    print("The visitant was added to the zoo visit")
                else:
                    print("Invalid ID inserted")
                    break

                # AGREGAR MÁS VISITANTES
                n = 1
                while n != len(self.__visitant_list):
                    print("These are the visitants added to zoo visit")
                    for visitant in zoo_visitants:
                        print("| VISITANT NAME: {} | VISITANT ID: {} |".format(visitant.get_full_name(), visitant.get_id()))
                    flag = True
                    print("Do you want to add another visitant(Y/N)")
                    if input().upper() == "Y":
                        Id = self.ask_id('V')
                        if self.valid_id('V', Id):
                            for visitant in zoo_visitants:
                                if visitant.get_id() == Id:
                                    flag = False
                                    print("This visitant has already been added to the visit")
                                    break
                            if flag:
                                zoo_visitants.append(self.__visitant_list[self.get_index('V', Id)])
                                print("The visitant was added to the zoo visit")
                                n += 1
                        else:
                            print("Invalid ID inserted")
                    else:
                        break
                    if n == len(self.__visitant_list):
                        print("You have added all the visitants available")
            self.__zoo_visit_list.append(ZooVisit(guide, date, zoo_visitants))
            
            print("Zoo visit added successfully!!")
            break

 
    def add_maintenance(self):
        while True:
            maintenance_employee = None
            if self.have_maintenance_employees():
                print("--------THESE ARE THE MAINTENANCE EMPLOYEES AVAILABLE--------")
                for employee in self.__employee_list:
                    if employee.get_role() == "Maintenance":
                        print("| NAME: {} | ID: {} |".format(employee.get_full_name(), employee.get_id()))
                print("\nInsert the ID: ")
                ID = input()
                if self.valid_id('E', ID):
                    i = self.get_index('E', ID)
                    maintenance_employee = self.__employee_list[i]
                else:
                    print("Invalid ID inserted")
                    break
            else:
                print("There are no maintenance employees registered")
                break
            
            date = self.ask_date("DAY OF THE MAINTENANCE")
            if not self.valid_date(date):
                print("Invalid date inserted")
                break
            
            print("INSERT THE ACTION MADE DURING THE MAINTENANCE")
            action = input()
            
            animalID = self.ask_id('A')
            if not self.valid_id('A', animalID):
                print("Invalid ID inserted")
                break
            else:
                i = self.get_index('A', animalID)
                animal = self.__animal_list[i]
                animal.set_active_animal(True)
            
            observations = "NO OBSERVATIONS REGISTERED"
            print("Do you want to add some observations?(Y/N)")
            if input().upper() == "Y":
                print("INSERT THE OBSERVATION")
                observations = input()
            
            self.__maintenance_list.append(Maintenance(maintenance_employee, date, action, animalID, observations))
            print("Maintenance added successfully!!")
            break

    def remove_employee(self):
        if len(self.__employee_list) == 0:
            print("There are no employees registered")
        else:
            ID = self.ask_id('E')
            if self.valid_id('E', ID):
                i = self.get_index('E', ID)
                if self.__employee_list[i].is_active_employee():
                    print("This employee participates in other activities, so it's not possible to remove it")
                else:
                    self.__employee_list.pop(i)
                    print("The employee was removed successfully!")
            elif ID != "EMPTY":
                print("Invalid ID inserted")

    def remove_visitant(self):
        if len(self.__visitant_list) == 0:
            print("There are no visitants registered")
        else:
            ID = self.ask_id('V')
            if self.valid_id('V', ID):
                i = self.get_index('V', ID)
                if self.__visitant_list[i].is_active_visitant():
                    print("This visitant participates in other activities, so it's not possible to remove it")
                else:
                    self.__visitant_list.pop(i)
                    print("The visitant was removed successfully!")
            elif ID != "EMPTY":
                print("Invalid ID inserted")

    def remove_animal(self):
        if len(self.__animal_list) == 0:
            print("There are no animals registered")
        else:
            ID = self.ask_id('A')
            if self.valid_id('A', ID):
                i = self.get_index('A', ID)
                if self.__animal_list[i].is_active_animal():
                    print("This animal participates in other activities, so it can't be removed")
                else:
                    self.__animal_list.pop(i)
                    print("The animal was removed successfully!")
            elif ID != "EMPTY":
                print("Invalid ID inserted")

    def show_employee_list(self):
        if len(self.__employee_list) == 0:
            print("There are not employees registered")
        else:
            print("---------------------------EMPLOYEES LIST---------------------------")
            for employee in self.__employee_list:
                print("| NAME: {} | FATHER'S LAST NAME: {} | MOTHER'S LAST NAME: {} |".format(employee.get_name(), employee.get_lastname_f(), employee.get_lastname_m()))
                print("| BIRTH DATE: {} | REGISTER DATE: {} | ROLE: {} |".format(employee.get_birthdate(), employee.get_register_date(), employee.get_role()))
                print("| SCHEDULE: {} | SEX: {} | SALARY: {:.2f} |".format(employee.get_schedule(), employee.get_sex(), employee.get_salary()))
                print("| CURP: {} | RFC: {} | ID: {} |".format(employee.get_curp(), employee.get_rfc(), employee.get_id()))
                print("--------------------------------------------------------------------")

    def show_visitant_list(self):
        if len(self.__visitant_list) == 0:
            print("There are not visitants registered")
        else:
            print("---------------------------VISITANTS LIST---------------------------")
            for visitant in self.__visitant_list:
                print("| NAME: {} | FATHER'S LAST NAME: {} | MOTHER'S LAST NAME: {} |".format(visitant.get_name(), visitant.get_lastname_f(), visitant.get_lastname_m()))
                print("| BIRTH DATE: {} | REGISTER DATE: {} | NUMBER OF VISITS: {} |".format(visitant.get_birthdate(), visitant.get_register_date(), visitant.get_num_visits()))
                print("| SEX: {} | CURP: {} | ID: {} |".format(visitant.get_sex(), visitant.get_curp(), visitant.get_id()))
                print("--------------------------------------------------------------------")

    def show_animal_list(self):
        if len(self.__animal_list) == 0:
            print("There are not animals registered")
        else:
            print("---------------------------ANIMALS LIST---------------------------")
            for animal in self.__animal_list:
                print("| NAME: {} | ANIMAL TYPE: {} | FOOD TYPE: {} |".format(animal.get_name(), animal.get_animal_type(), animal.get_food_type()))
                print("| BIRTH DATE: {} | REGISTER DATE: {} | WEIGHT: {:.2f} kg |".format(animal.get_birthdate(), animal.get_register_date(), animal.get_weight()))
                print("| IS VACCINATED: {} | FOOD FREQUENCY: {} | ID: {} |".format(animal.is_vaccinated(), animal.get_food_frequency(), animal.get_id()))
                animal.show_diseases_list()
                print("--------------------------------------------------------------------")

    def show_zoo_visit_list(self):
        if len(self.__zoo_visit_list) == 0:
            print("There are not zoo visits registered")
        else:
            print("---------------------------ZOO VISITS LIST---------------------------")
            for zoo_visit in self.__zoo_visit_list:
                print("| GUIDE'S NAME: {} | GUIDE'S ID: {} | VISIT DATE: {} |".format(zoo_visit.get_guide().get_full_name(), zoo_visit.get_guide().get_id(), zoo_visit.get_visit_date()))
                print("THESE ARE THE VISITANT/S OF THE ZOO VISIT")
                for visitant in zoo_visit.get_visitant_list():
                    print("| NAME: {} | ID: {} |".format(visitant.get_full_name(), visitant.get_id()))
                print("| NUMBER OF ADULTS: {} | NUMBER OF CHILDREN: {} | VISIT COST: {:.2f} |".format(zoo_visit.get_num_adult(), zoo_visit.get_num_child(), zoo_visit.get_amount()))
                print("--------------------------------------------------------------------")

    def show_maintenance_list(self):
        if len(self.__maintenance_list) == 0:
            print("There are not maintenances registered")
        else:
            print("---------------------------MAINTENANCES LIST---------------------------")
            for maintenance in self.__maintenance_list:
                print("| MAINTENANCE EMPLOYEE NAME: {} | MAINTENANCE EMPLOYEE ID: {} |".format(maintenance.get_maintenance_employee().get_full_name(), maintenance.get_maintenance_employee().get_id()))
                print("| ACTION: {} | (ID)ANIMAL: {} | DATE: {} |".format(maintenance.get_action(), maintenance.get_animal_id(), maintenance.get_date()))
                print("| OBSERVATIONS: {} |".format(maintenance.get_observation()))
                print("--------------------------------------------------------------------")

    def show_employee_list_id(self):
        if len(self.__employee_list) == 0:
            print("There are not employees registered")
            return False
        else:
            print("---------------EMPLOYEE LIST------------------------")
            for employee in self.__employee_list:
                print("| NAME: {} | ID: {} |".format(employee.get_full_name(), employee.get_id()))
            return True
    
    #PARTE GABO
    def show_visitant_list_id(self):
        if len(self.__visitant_list) == 0:
            print("There are no visitants registered")
            return False
        else:
            print("---------------VISITANTS LIST------------------------")
            for visitant in self.__visitant_list:
                print("| NAME: {} | ID: {} |".format(visitant.get_full_name(), visitant.get_id()))
            return True

    def show_animal_list_id(self):
        if len(self.__animal_list) == 0:
            print("There are no animals registered")
            return False
        else:
            print("---------------ANIMALS LIST------------------------")
            for animal in self.__animal_list:
                print("| NAME: {} | ID: {} |".format(animal.get_name(), animal.get_id()))
            return True

    def show_zoo_visit_list_id(self):
        if len(self.__zoo_visit_list) == 0:
            print("There are no zoo visits registered")
            return False
        else:
            print("---------------ZOO VISITS LIST------------------------")
            for zoo_visit in self.__zoo_visit_list:
                print("| VISIT DATE: {} | ID: {} |".format(zoo_visit.get_visit_date(), zoo_visit.get_id()))
            return True

    def show_maintenance_list_id(self):
        if len(self.__maintenance_list) == 0:
            print("There are no maintenances registered")
            return False
        else:
            print("---------------MAINTENANCES LIST------------------------")
            for maintenance in self.__maintenance_list:
                print("| DATE: {} | ID: {} |".format(maintenance.get_date(), maintenance.get_id()))
            return True

    def show_employee_info(self):
        id = self.ask_id('E')
        if self.valid_id('E', id):
            i = self.get_index('E', id)
            employee = self.__employee_list[i]
            print("| NAME: {} | FATHER'S LAST NAME: {} | MOTHER'S LAST NAME: {} |".format(employee.get_name(), employee.get_lastname_f(), employee.get_lastname_m()))
            print("| BIRTH DATE: {} | REGISTER DATE: {} | ROLE: {} |".format(employee.get_birthdate(), employee.get_register_date(), employee.get_role()))
            print("| SCHEDULE: {} | SEX: {} | SALARY: {:.2f} |".format(employee.get_schedule(), employee.get_sex(), employee.get_salary()))
            print("| CURP: {} | RFC: {} | ID: {} |".format(employee.get_curp(), employee.get_rfc(), employee.get_id()))
            print("--------------------------------------------------------------------")
        elif id != "EMPTY":
            print("Invalid ID inserted")

    def show_employee_info_index(self, i):
        employee = self.__employee_list[i]
        print("| NAME: {} | FATHER'S LAST NAME: {} | MOTHER'S LAST NAME: {} |".format(employee.get_name(), employee.get_lastname_f(), employee.get_lastname_m()))
        print("| BIRTH DATE: {} | REGISTER DATE: {} | ROLE: {} |".format(employee.get_birthdate(), employee.get_register_date(), employee.get_role()))
        print("| SCHEDULE: {} | SEX: {} | SALARY: {:.2f} |".format(employee.get_schedule(), employee.get_sex(), employee.get_salary()))
        print("| CURP: {} | RFC: {} | ID: {} |".format(employee.get_curp(), employee.get_rfc(), employee.get_id()))

    def show_visitant_info(self):
        id = self.ask_id('V')
        if self.valid_id('V', id):
            i = self.get_index('V', id)
            visitant = self.__visitant_list[i]
            print("| NAME: {} | FATHER'S LAST NAME: {} | MOTHER'S LAST NAME: {} |".format(visitant.get_name(), visitant.get_lastname_f(), visitant.get_lastname_m()))
            print("| BIRTH DATE: {} | REGISTER DATE: {} | NUMBER OF VISITS: {} |".format(visitant.get_birthdate(), visitant.get_register_date(), visitant.get_num_visits()))
            print("| SEX: {} | CURP: {} | ID: {} |".format(visitant.get_sex(), visitant.get_curp(), visitant.get_id()))
            print("--------------------------------------------------------------------")
        elif id != "EMPTY":
            print("Invalid ID inserted")

    def show_visitant_info_index(self, i):
        visitant = self.__visitant_list[i]
        print("| NAME: {} | FATHER'S LAST NAME: {} | MOTHER'S LAST NAME: {} |".format(visitant.get_name(), visitant.get_lastname_f(), visitant.get_lastname_m()))
        print("| BIRTH DATE: {} | REGISTER DATE: {} | NUMBER OF VISITS: {} |".format(visitant.get_birthdate(), visitant.get_register_date(), visitant.get_num_visits()))
        print("| SEX: {} | CURP: {} | ID: {} |".format(visitant.get_sex(), visitant.get_curp(), visitant.get_id()))

    def show_animal_info(self):
        id = self.ask_id('A')
        if self.valid_id('A', id):
            i = self.get_index('A', id)
            animal = self.__animal_list[i]
            print("| NAME: {} | ANIMAL TYPE: {} | FOOD TYPE: {} |".format(animal.get_name(), animal.get_animal_type(), animal.get_food_type()))
            print("| BIRTH DATE: {} | REGISTER DATE: {} | WEIGHT: {:.2f} kg |".format(animal.get_birthdate(), animal.get_register_date(), animal.get_weight()))
            print("| IS VACCINATED: {} | ID: {} |".format(animal.is_vaccinated(), animal.get_id()))
            animal.show_diseases_list()
            print("--------------------------------------------------------------------")
        elif id != "EMPTY":
            print("Invalid ID inserted")

    def show_animal_info_index(self, i):
        animal = self.__animal_list[i]
        print("| NAME: {} | ANIMAL TYPE: {} | FOOD TYPE: {} |".format(animal.get_name(), animal.get_animal_type(), animal.get_food_type()))
        print("| BIRTH DATE: {} | REGISTER DATE: {} | WEIGHT: {:.2f} kg |".format(animal.get_birthdate(), animal.get_register_date(), animal.get_weight()))
        print("| IS VACCINATED: {} | FOOD FREQUENCY: {} | ID: {} |".format(animal.is_vaccinated(), animal.get_food_frequency(), animal.get_id()))
        animal.show_diseases_list()

    def show_zoo_visit_info(self):
        id = self.ask_id('Z')
        if self.valid_id('Z', id):
            i = self.get_index('Z', id)
            zoo_visit = self.__zoo_visit_list[i]
            print("| GUIDE'S NAME: {} | GUIDE'S ID: {} | VISIT DATE: {} |".format(zoo_visit.get_guide().get_full_name(), zoo_visit.get_guide().get_id(), zoo_visit.get_visit_date()))
            print("THESE ARE THE VISITANT/S OF THE ZOO VISIT")
            for visitant in zoo_visit.get_visitant_list():
                print("| NAME: {} | ID: {} |".format(visitant.get_full_name(), visitant.get_id()))
            print("| NUMBER OF ADULTS: {} | NUMBER OF CHILDREN: {} | VISIT COST: {:.2f} |".format(zoo_visit.get_num_adult(), zoo_visit.get_num_child(), zoo_visit.get_amount()))
            print("--------------------------------------------------------------------")
        elif id != "EMPTY":
            print("Invalid ID inserted")

    def show_maintenance_info(self):
        id = self.ask_id('M')
        if self.valid_id('M', id):
            i = self.get_index('M', id)
            maintenance = self.__maintenance_list[i]
            print("| MAINTENANCE EMPLOYEE NAME: {} | MAINTENANCE EMPLOYEE ID: {} |".format(maintenance.get_maintenance_employee().get_full_name(), maintenance.get_maintenance_employee().get_id()))
            print("| ACTION: {} | (ID)ANIMAL: {} | DATE: {} |".format(maintenance.get_action(), maintenance.get_animal_id(), maintenance.get_date()))
            print("| OBSERVATIONS: {} |".format(maintenance.get_observation()))
            print("--------------------------------------------------------------------")
        elif id != "EMPTY":
            print("Invalid ID inserted")

    def modify_employee(self):
        id = self.ask_id('E')
        if self.valid_id('E', id):
            i = self.get_index('E', id)
            employee = self.__employee_list[i]
            self.show_employee_info_index(i)
            flag = True
            while flag:
                print("-------------------------------------------------------------------------------")
                print("Which information do you want to modify?")
                print("1. NAME")
                print("2. FATHER'S LASTNAME")
                print("3. MOTHER'S LASTNAME")
                print("4. BIRTHDATE")
                print("5. REGISTER DATE")
                print("6. ROLE")
                print("7. SCHEDULE")
                print("8. SEX")
                print("9. SALARY")
                print("10. CURP")
                print("11. RFC")
                print("12. GO BACK TO MAIN MENU")
                x = int(input("Select an option: "))

                if x == 1:
                    new_name = input("New Name: ")
                    if self.valid_name(new_name):   
                        employee.set_name(new_name)
                        print("Name updated successfully.")
                    else:
                        print("Invalid name inserted")

                elif x == 2:
                    new_lastname_f = input("New Father's lastname: ")
                    if self.valid_name(new_lastname_f):
                        employee.set_lastname_f(new_lastname_f)
                        print("Father's lastname updated successfully.")
                    else:
                        print("Invalid father's lastname inserted")
                        
                elif x == 3:
                    new_lastname_m = input("New Mother's lastname: ")
                    if self.valid_name(new_lastname_m):
                        employee.set_lastname_m(new_lastname_m)
                        print("Mother's lastname updated successfully.")
                    else:
                        print("Invalid mother's lastname inserted")
                    

                elif x == 4:
                    new_birthdate = self.ask_date("NEW BIRTHDATE")
                    if self.valid_date(new_birthdate):
                        employee.set_birthdate(new_birthdate)
                        print("Birthdate updated successfully.")
                    else:
                        print("Invalid date inserted")

                elif x == 5:
                    new_arriving_day = self.ask_date("NEW REGISTER DATE")
                    if self.valid_date(new_arriving_day):
                        employee.set_register_date(new_arriving_day)
                        print("Register date updated successfully.")
                    else:
                        print("Invalid date inserted")

                elif x == 6:
                    if employee.is_active_employee():
                        print("This employee participates in other activities, so it's not possible to modify the role")
                    else:
                        print("Insert the new role")
                        new_role = self.ask_role()
                        if new_role == "NOVALID":
                            print("Invalid role option")
                            break
                        else:
                            employee.set_role(new_role)
                            print("Role updated successfully")

                elif x == 7:
                    new_schedule = input("Insert the new schedule: ")
                    employee.set_schedule(new_schedule)
                    print("Schedule updated successfully.")

                elif x == 8:
                    new_sex = input("Insert the new sex: ")
                    if self.valid_sex(new_sex):
                        employee.set_sex(new_sex)
                        print("Sex updated successfully.")
                    else:
                        print("Invalid sex inserted")

                elif x == 9:
                    new_salary = float(input("Insert the new salary: "))
                    employee.set_salary(new_salary)
                    print("Salary updated successfully.")

                elif x == 10:
                    new_curp = input("Insert the new CURP: ")
                    employee.set_curp(new_curp)
                    print("CURP updated successfully.")

                elif x == 11:
                    new_rfc = input("Insert the new RFC: ")
                    employee.set_rfc(new_rfc)
                    print("RFC updated successfully.")

                else:
                    flag = False

                if flag:
                    answer = input("Do you want to continue modifying this employee?(Y/N): ")
                    if answer.upper() != "Y":
                        flag = False
                    else:
                        print("------------------INFORMATION UPDATED------------------")
                        self.show_employee_info_index(i)

        elif id != "EMPTY":
            print("Invalid ID inserted")

    def modify_visitant(self):
        id = self.ask_id('V')
        if self.valid_id('V', id):
            i = self.get_index('V', id)
            visitant = self.__visitant_list[i]
            self.show_visitant_info_index(i)
            flag = True
            while flag:
                print("Which information do you want to modify?")
                print("1. NAME")
                print("2. FATHER'S LASTNAME")
                print("3. MOTHER'S LASTNAME")
                print("4. SEX")
                print("5. BIRTHDATE")
                print("6. REGISTER DATE")
                print("7. CURP")
                print("8. GO BACK TO MAIN MENU")
                x = int(input("Select an option: "))

                if x == 1:
                    new_name = input("New Name: ")
                    if self.valid_name(new_name):   
                        visitant.set_name(new_name)
                        print("Name updated successfully.")
                    else:
                        print("Invalid name inserted")

                elif x == 2:
                    new_lastname_f = input("New Father's lastname: ")
                    if self.valid_name(new_lastname_f):
                        visitant.set_lastname_f(new_lastname_f)
                        print("Father's lastname updated successfully.")
                    else:
                        print("Invalid father's lastname inserted")
                        
                elif x == 3:
                    new_lastname_m = input("New Mother's lastname: ")
                    if self.valid_name(new_lastname_m):
                        visitant.set_lastname_m(new_lastname_m)
                        print("Mother's lastname updated successfully.")
                    else:
                        print("Invalid mother's lastname inserted")
                
                elif x == 4:
                    new_sex = input("Insert the new sex: ")
                    if self.valid_sex(new_sex):
                        visitant.set_sex(new_sex)
                        print("Sex updated successfully.")
                    else:
                        print("Invalid sex inserted")

                elif x == 5:
                    new_birthdate = self.ask_date("NEW BIRTHDATE")
                    if self.valid_date(new_birthdate):
                        visitant.set_birthdate(new_birthdate)
                        print("Birthdate updated successfully.")
                    else:
                        print("Invalid date inserted")

                elif x == 6:
                    new_arriving_day = self.ask_date("NEW REGISTER DATE")
                    if self.valid_date(new_arriving_day):
                        visitant.set_register_date(new_arriving_day)
                        print("Register date updated successfully.")
                    else:
                        print("Invalid date inserted")

                elif x == 7:
                    new_curp = input("Insert the new CURP: ")
                    visitant.set_curp(new_curp)

                else:
                    flag = False

                if flag:
                    answer = input("Do you want to continue modifying this visitant?(Y/N): ")
                    if answer.upper() != "Y":
                        flag = False
                    else:
                        print("------------------INFORMATION UPDATED------------------")
                        self.show_visitant_info_index(i)

        elif id != "EMPTY":
            print("Invalid ID inserted")

    def modify_animal(self):
        id = self.ask_id('A')
        if self.valid_id('A', id):
            i = self.get_index('A', id)
            animal = self.__animal_list[i]
            self.show_animal_info_index(i)
            flag = True
            while flag:
                print("Which information do you want to modify?")
                print("1. NAME")
                print("2. ANIMAL TYPE")
                print("3. FOOD TYPE")
                print("4. WEIGHT")
                print("5. BIRTHDATE")
                print("6. REGISTER DATE")
                print("7. IS VACCCINATED")
                print("8. FOOD FREQUENCY")
                print("9. MODIFY DISEASES LIST")
                print("10. RETURN TO MAIN MENU")
                x = int(input("Select an option: "))

                if x == 1:
                    new_name = input("New Name: ")
                    animal.set_name(new_name)
                    print("Name updated successfully.")

                elif x == 2:
                    new_animal_type = input("New Animal Type: ")
                    animal.set_animal_type(new_animal_type)
                    print("Animal type updated successfully.")

                elif x == 3:
                    new_type_food = input("New Food Type: ")
                    animal.set_food_type(new_type_food)
                    print("Food type updated successfully.")

                elif x == 4:
                    new_weight = float(input("New Weight: "))
                    animal.set_weight(new_weight)
                    print("Weight updated successfully.")

                elif x == 5:
                    new_birthdate = self.ask_date("NEW BIRTHDATE")
                    if self.valid_date(new_birthdate):
                        animal.set_birthdate(new_birthdate)
                        print("Birthdate updated successfully.")
                    else:
                        print("Invalid date inserted")

                elif x == 6:
                    new_arriving_day = self.ask_date("NEW REGISTER DATE")
                    if self.valid_date(new_arriving_day):
                        animal.set_register_date(new_arriving_day)
                        print("Register date updated successfully.")
                    else:
                        print("Invalid date inserted")

                elif x == 7:
                    answer = input("Is the animal vaccined?(Y/N): ")
                    if answer.upper() == "Y":
                        animal.set_vaccinated(True)
                        print("Vaccinated status updated successfully")
                    elif answer.upper() == "N":
                        animal.set_vaccinated(False)
                        print("Vaccinated status updated successfully")
                    else:
                        print("Invalid answer")

                elif x == 8:
                    new_food_frequency = input("INSERT THE NEW FOOD FREQUENCY")
                    animal.set_food_frecuency(new_food_frequency)

                elif x == 9:
                    self.modify_diseases_list(animal)

                else:
                    flag = False

                if flag:
                    answer = input("Do you want to continue modifying this animal?(Y/N): ")
                    if answer.upper() != "Y":
                        flag = False
                    else:
                        print("------------------INFORMATION UPDATED------------------")
                        self.show_animal_info_index(i)

        elif id != "EMPTY":
            print("Invalid ID inserted")
            
    
    
    
    
    
    def ask_sex(self):
        print("INSERT THE SEX(M/F)")
        sex = input()
        return sex

    def valid_sex(self, cad):
        cad = cad.upper()
        flag = False
        if cad == "M" or cad == "F":
            flag = True
        return flag

    def ask_date(self, data):
        print("INSERT THE " + data)
        print("EXAMPLE: 08/10/1956")
        date = input()
        return date

    def valid_date(self, cad):
        flag1 = False
        flag2 = False
        flag3 = False
        if len(cad) == 10 and cad[2] == '/' and cad[5] == '/':
            flag1 = True
        if flag1:
            if self.is_number(cad[0:2]) and self.is_number(cad[3:5]) and self.is_number(cad[6:len(cad)]):
                flag2 = True
        if flag1 and flag2:
            day = int(cad[0:2])
            month = int(cad[3:5])
            year = int(cad[6:])
            if day > 0 and day <= 31 and month > 0 and month <= 12 and year > 1850 and year <= 2024:
                flag3 = True
        return flag1 and flag2 and flag3

    def is_number(self, cad):
        numbers = "0123456789"
        flag = True
        for car in cad:
            if car not in numbers:
                flag = False
                break
        return flag

    def get_index(self, car, cad):
        x = 0
        if car == 'V':
            for i in range(len(self.__visitant_list)):
                if cad == self.__visitant_list[i].get_id():
                    x = i
        elif car == 'E':
            for i in range(len(self.__employee_list)):
                if cad == self.__employee_list[i].get_id():
                    x = i
        elif car == 'A':
            for i in range(len(self.__animal_list)):
                if cad == self.__animal_list[i].get_id():
                    x = i
        elif car == 'Z':
            for i in range(len(self.__zoo_visit_list)):
                if cad == self.__zoo_visit_list[i].get_id():
                    x = i
        elif car == 'M':
            for i in range(len(self.__maintenance_list)):
                if cad == self.__maintenance_list[i].get_id():
                    x = i
        return x

    def ask_id(self, car):
        cad = ""
        if car == 'V':
            if self.show_visitant_list_id():
                print("Insert the ID of the visitant: ")
                cad = input()
            else:
                cad = "EMPTY"
        elif car == 'E':
            if self.show_employee_list_id():
                print("Insert the ID of the employee: ")
                cad = input()
            else:
                cad = "EMPTY"
        elif car == 'A':
            if self.show_animal_list_id():
                print("Insert the ID of the animal: ")
                cad = input()
            else:
                cad = "EMPTY"
        elif car == 'M':
            if self.show_maintenance_list_id():
                print("Insert the ID of the maintenance: ")
                cad = input()
            else:
                cad = "EMPTY"
        elif car == 'Z':
            if self.show_zoo_visit_list_id():
                print("Insert the ID of the zoo visit: ")
                cad = input()
            else:
                cad = "EMPTY"
        return cad

    def valid_id(self, car, cad):
        flag = False
        if car == 'V':
            for visitant in self.__visitant_list:
                if cad == visitant.get_id():
                    flag = True
                    break
        elif car == 'E':
            for employee in self.__employee_list:
                if cad == employee.get_id():
                    flag = True
                    break
        elif car == 'A':
            for animal in self.__animal_list:
                if cad == animal.get_id():
                    flag = True
                    break
        elif car == 'Z':
            for zooVisit in self.__zoo_visit_list:
                if cad == zooVisit.get_id():
                    flag = True
                    break
        elif car == 'M':
            for maintenance in self.__maintenance_list:
                if cad == maintenance.get_id():
                    flag = True
                    break
        return flag

    def ask_role(self):
        print("Select an option")
        print("1. Veterinary")
        print("2. Guide")
        print("3. Maintenance")
        print("4. Administration")
        x = int(input())
        if x == 1:
            return "Veterinary"
        elif x == 2:
            return "Guide"
        elif x == 3:
            return "Maintenance"
        elif x == 4:
            return "Administration"
        else:
            return "NOVALID"

    def ask_name(self, cad):
        print("INSERT THE " + cad + ": ")
        answer = input()
        return answer

    def valid_name(self, name):
        flag = True
        name = name.upper()
        for car in name:
            if ord(car) < 65 or ord(car) > 90:
                flag = False
                break
        return flag

    def have_guides(self):
        flag = False
        for employee in self.__employee_list:
            if employee.get_role() == "Guide":
                flag = True
                break
        return flag

    def have_maintenance_employees(self):
        flag = False
        for employee in self.__employee_list:
            if employee.get_role() == "Maintenance":
                flag = True
                break
        return flag

    def modify_diseases_list(self, animal):
        while True:
            animal.show_diseases_list()
            if len(animal.get_diseases()) == 0:
                print("Do you want to add a disease to the list?(Y/N)")
                if input().upper() == "Y":
                    print("Insert the name of the disease")
                    dis = input()
                    animal.get_diseases().append(dis)
                    print("Disease added succesfully")
            else:
                print("Do you want to add(A) or remove(R) or modify(M) a disease of the list?")
                letter = input()
                if letter == "R":
                    print("Which disease is being removed? Insert the number")
                    i = int(input())
                    if i > 0 and i <= len(animal.get_diseases()):
                        animal.get_diseases().pop(i - 1)
                        print("Disease removed succesfully")
                    else:
                        print("Invalid option inserted")
                elif letter == "M":
                    print("Which disease is being removed? Insert the number")
                    n = int(input())
                    if n > 0 and n <= len(animal.get_diseases()):
                        print("Insert the name of the disease")
                        animal.get_diseases()[n - 1] = input()
                        print("Disease modified succesfully")
                    else:
                        print("Invalid option inserted")
                elif letter == "A":
                    print("Insert the name of the disease")
                    dis = input()
                    animal.get_diseases().append(dis)
                    print("Disease added succesfully")
                else:
                    print("Invalid option inserted")
            print("Do you want to continue modifying the diseases list?(Y/N)")
            if input().upper() != "Y":
                break