# Sistema de gestión para el Zoológico de Morelia🐆
En este proyecto aplicamos los conocimientos aprendidos en la segunda unidad de la materia de Programación Orientada a Objetos.
Abarcando lo siguiente:
- Métodos constructores
- Sobrecarga de métodos
- Métodos getters y setters
- Encapsulamiento
- Uso de ArrayList
---
Para el desarrollo de este proyecto seguimos las instrucciones contenidas en el siguiente enlace: [Instrucciones](https://itmorelia-ejercicios-eder.notion.site/POO-Examen-Unidad-2-7364713517994e76baa1b44f6eef71ce)

## Estructura del código
## Clase main
Esta clase tiene la función de empezar la ejecución del código, creando una instancia de la clase `Programme` . Utilizando este objeto para ejecutar el método `run_programme()`.
## Clase Programme
Fue solicitado que el programa contara con una contraseña para poder acceder al sistema de gestión. En este apartado no se le permitirá al usuario avanzar hasta ingresar la contraseña correcta.
```python
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
```
Una vez que es ingresada la contraseña correcta, se le mostrarán al usuario las opciones de acciones que puede realizar en el sistema, a través del método `show_options()`.
Las acciones que puede realizar el usuario se resume a lo siguiente:
1. Registar en el sistema:
    - Empleados
    - Visitantes
    - Animales
    - Mantenimientos
    - Visitas al zoológico

2. Eliminar del sistema:
    - Empleados
    - Visitantes
    - Animales

**Nota**: Se podrán eliminar si y sólo el objeto no participa en otras relaciones, de lo contrario no se le permitirá al usuario hacerlo.

3. Consultar información ya sea de todos o de algún objeto en específico:
    - Empleados
    - Visitantes
    - Animales
    - Mantenimientos
    - Visitas al zoológico
**Nota**: Si no existe ninnguna instancia de alguna de las clases mencionadas, se mostrará al usuario un mensaje en el que indique que no hay objetos de esa clase, por lo que no hay información a mostrar.

4. Modificar información:
    - Empleados
    - Visitantes
    - Animales

**Nota**: Sólo se podrá modificar la información de un usuario si esta no compromete alguna relación en la que participe el objeto.

A continuación se mostrarán estas cuatro acciones ya en código en el lenguaje Java.

## Clase Zoo
La clase Zoo cuenta con cinco listas, las cuáles contendrán las instancias de los objetos creados durante la ejecución del programa.
```python
    class Zoo:
    def __init__(self):
        self.__employee_list = []
        self.__visitant_list = []
        self.__animal_list = []
        self.__maintenance_list = []
        self.__zoo_visit_list = []
```
Ahora se presentarán los métodos utilizados para realizar las acciones mencionadas en el apartado anterior.
### 1. Registrar o añadir: Métodos Add
Estos métodos le permitirán al usuario registrar un objeto en el sistema. Para esto se le irán pidiendo los datos requeridos en el constructor del objeto en cuestión. Si ingresa algún dato que es inválido, el programa se lo indicará y lo enviará al menú principal.
En cambio si ingresa datos válidos, el programa agregará a la lista el objeto con los atributos indicados por el usuario. De igual forma se lo hará saber en pantalla si fue posible agregar el objeto.
```python
    #MÉTODO ADD
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
```
Todos los métodos add siguen la misma estructura y lógica. Únicamente pidiendo atributos diferentes al usuario dependiendo el tipo de objeto en cuestión.

### Métodos remove
stos métodos permiten al usuario eliminar una instancia de una clase. Primero se verifica si la lista del tipo de objeto está vacía, ya que no tiene sentido intentar eliminar un objeto si la lista está vacía. Si la lista no está vacía, se muestra al usuario una lista de ID junto con el nombre, para que pueda ingresar en consola el ID del objeto que desea eliminar. Si el usuario ingresa un ID que coincide con uno de los mostrados en la lista, el programa verifica que la instancia de la clase no participe en otra relación, ya que si lo hace y se elimina, la relación se romperá. Si el objeto no participa en otra relación, se elimina y se muestra un mensaje en consola al usuario.
```python
#MÉTODO REMOVE
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
```
### Métodos showList
Estos métodos se encargarán de mostrar la información completa de todas las instancias creadas de la clase. Aprovechando los métodos get con los que cuentan todas las clases que participan en este programa. Al igual que con los métodos remove, el programa se asegurará que si la lista se encuentra vacía se lo haga saber al usuario, ya que no tendría sentido mostrar información de una lista de objetos vacía.
```python
#MÉTODO SHOWLIST
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
  
```
### Métodos showInfo
Estos métodos se encargarán de mostrar la información completa de una instancia en particular de la clase. Para esto se mostrará al usuario los objetos disponibles y se le solicitará que ingrese el ID del cuál desea consultar información. El programa se asegurará que si la lista se encuentra vacía se lo haga saber al usuario, ya que no tendría sentido mostrar información de una lista de objetos vacía.
```python
#MÉTODO SHOWINFO
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

```
### Métodos modify
Este es probablemente el método más interesante, ya que permite al usuario alterar la información de un objeto. Permitiéndole cambiar alguna información en caso de ser errónea o simplemente actualizar algún atributo del objeto. Este método también cuenta con validaciones para asegurarse que no haya errores al momento de que el usuario actualice la información.
```python
#MÉTODO MODIFY
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

```



## Métodos relevantes
### Método valid_date()
Este método se encarga de validar que las fechas ingresadas por consola siguien la siguiente estructura: __08/06/2004__
```python
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
```
---
### Método get_index()
Este método se encarga de obtener la posición en su respectiva lista. Logramos obtener esta función en un sólo método. Ya que en anteriores ejercicios hacíamos una función para cada tipo de dato. En cambio en este usando un switch logramos ahorrarnos varias líneas de código.
``` python
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

```
---
### Método modify_diseases_list()
Este método consideramos relevante mencionarlo ya que hace dinámica la experiencia del usuario. Este le permite añadir, modificar y eliminar enfermedades de la lista de enfermedades de los objetos de tipo Animal. Resultando fácil e intuitivo de utilizar.
``` python
pdef modify_diseases_list(self, animal):
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
```
## Conclusiones
Este proyecto nos resultó un tanto desafiante e interesante a la vez. Ya que utilizamos todos los conocimientos adquiridos en la segunda unidad de la materia de Progamación Orientada a Objetos.

Además nos provocó cierta emoción entender como es que funcionan algunos de los sistemas de registro más complejos del mundo. Que si bien en este proyecto hicimos una mínima parte de esos sistemas, nos pareció sorprendente el potencial que tiene la programación para el adecuado funcionamiento y organización de las empresas en todo el mundo.