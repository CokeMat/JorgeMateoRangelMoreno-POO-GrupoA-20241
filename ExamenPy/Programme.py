from Zoo import Zoo
from ZooVisit import ZooVisit
from Visitant import Visitant
from Employee import Employee
from Maintenance import Maintenance

class Programme:
    __PASSWORD = "pass1234*"
    zoo = Zoo()
    
    def run_programme(self):
        valid_password = False
        while not valid_password:
            print("******************** WELCOME ********************")
            print("Please insert the password to access the zoo information")
            print("PASSWORD: pass1234*")
            password = input()
            if password == self.__PASSWORD:
                valid_password = True
                self.show_options()
            else:
                print("Wrong password. Try again")
    
    def show_options(self):
        flag = True
        while flag:
            print("************** WELCOME TO THE ZOO SYSTEM **************")
            print("Please select an option (Write the number)")
            print("1. Register")
            print("2. Delete")
            print("3. Modify information")
            print("4. Consult information")
            print("5. Exit of the system")
            
            x = int(input())
            if x == 1:
                print("What do you want to register?")
                print("Select an option")
                print("1. Register an employee")
                print("2. Register a visitant")
                print("3. Register an animal")
                print("4. Register a zoo visit")
                print("5. Register the maintenance done to an animal")
                print("6. Get back to the last menu")
                
                option = int(input())
                if option == 1:
                    self.zoo.add_employee()
                elif option == 2:
                    self.zoo.add_visitant()
                elif option == 3:
                    self.zoo.add_animal()
                elif option == 4:
                    self.zoo.add_zoo_visit()
                elif option == 5:
                    self.zoo.add_maintenance()
                else:
                    pass
                
            elif x == 2:
                print("1. Delete an employee")
                print("2. Delete a visitant")
                print("3. Delete an animal")
                print("4. Get back to the last menu")
                
                option = int(input())
                if option == 1:
                    self.zoo.remove_employee()
                elif option == 2:
                    self.zoo.remove_visitant()
                elif option == 3:
                    self.zoo.remove_animal()
                else:
                    pass
                
            elif x == 3:
                print("1. Modify employee information")
                print("2. Modify visitant information")
                print("3. Modify animal information")
                print("4. Get back to the last menu")
                
                option = int(input())
                if option == 1:
                    self.zoo.modify_employee()
                elif option == 2:
                    self.zoo.modify_visitant()
                elif option == 3:
                    self.zoo.modify_animal()
                else:
                    pass
                
            elif x == 4:
                print("1. Employees information")
                print("2. Visitants information")
                print("3. Animals information")
                print("4. Zoo Visits information")
                print("5. Maintenances information")
                print("6. Get back to the last menu")
                
                option = int(input())
                if option == 1:
                    print("Do you need information of a specific employee?")
                    print("1. Yes")
                    print("2. No")
                    sub_option = int(input())
                    if sub_option == 1:
                        self.zoo.show_employee_info()
                    elif sub_option == 2:
                        self.zoo.show_employee_list()
                    else:
                        print("Invalid option")
                elif option == 2:
                    print("Do you need information of a specific visitant?")
                    print("1. Yes")
                    print("2. No")
                    sub_option = int(input())
                    if sub_option == 1:
                        self.zoo.show_visitant_info()
                    elif sub_option == 2:
                        self.zoo.show_visitant_list()
                    else:
                        print("Invalid option")
                elif option == 3:
                    print("Do you need information of a specific animal?")
                    print("1. Yes")
                    print("2. No")
                    sub_option = int(input())
                    if sub_option == 1:
                        self.zoo.show_animal_info()
                    elif sub_option == 2:
                        self.zoo.show_animal_list()
                    else:
                        print("Invalid option")
                elif option == 4:
                    print("Do you need information of a specific zoo visit?")
                    print("1. Yes")
                    print("2. No")
                    sub_option = int(input())
                    if sub_option == 1:
                        self.zoo.show_zoo_visit_info()
                    elif sub_option == 2:
                        self.zoo.show_zoo_visit_list()
                    else:
                        print("Invalid option")
                elif option == 5:
                    print("Do you need information of a specific maintenance?")
                    print("1. Yes")
                    print("2. No")
                    sub_option = int(input())
                    if sub_option == 1:
                        self.zoo.show_maintenance_info()
                    elif sub_option == 2:
                        self.zoo.show_maintenance_list()
                    else:
                        print("Invalid option")
                else:
                    pass
            else:
                flag = False
