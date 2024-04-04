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
Esta clase tiene la función de empezar la ejecución del código, creando una instancia de la clase `Programme` . Utilizando este objeto para ejecutar el método `runProgramme()`.
## Clase Programme
Fue solicitado que el programa contara con una contraseña para poder acceder al sistema de gestión. En este apartado no se le permitirá al usuario avanzar hasta ingresar la contraseña correcta.
```java
    while (!validPassword) {
            System.out.println("\n******************** WELCOME ******************** ");
            System.out.println("Please insert the password to access to the zoo information");
            System.out.println("PASSWORD: pass1234* ");
            String cad = sc.nextLine();
                if(cad.equals(PASSWORD)){
                    validPassword = true;
                    showOptions();
                }
                else{
                    System.out.println("Wrong password. Try again");
                } 
```
Una vez que es ingresada la contraseña correcta, se le mostrarán al usuario las opciones de acciones que puede realizar en el sistema, a través del método `showOptions()`.
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
```java
    public class Zoo {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ArrayList<Visitant> visitantList = new ArrayList<>();
    private ArrayList<Animal> animalList = new ArrayList<>();
    private ArrayList<Maintenance> maintenanceList = new ArrayList<>();
    private ArrayList<ZooVisit> zooVisitList = new ArrayList<>(); 
    ...
```
Ahora se presentarán los métodos utilizados para realizar las acciones mencionadas en el apartado anterior.
### 1. Registrar o añadir: Métodos Add
Estos métodos le permitirán al usuario registrar un objeto en el sistema. Para esto se le irán pidiendo los datos requeridos en el constructor del objeto en cuestión. Si ingresa algún dato que es inválido, el programa se lo indicará y lo enviará al menú principal.
En cambio si ingresa datos válidos, el programa agregará a la lista el objeto con los atributos indicados por el usuario. De igual forma se lo hará saber en pantalla si fue posible agregar el objeto.
```java
    ///MÉTODO ADD
     public void addEmployee(){
        while(true){
            String name = askName("NAME");
                if (!validName(name)) {
                    System.out.println("Invalid name inserted");
                    break;
                }
            String lastNameF = askName("FATHER'S LASTNAME");
                if (!validName(lastNameF)) {
                    System.out.println("Invalid father's lastname inserted");
                    break;
                }
            String lastNameM = askName("MOTHER'S LASTNAME");
                if (!validName(lastNameF)) {
                    System.out.println("Invalid name inserted");
                    break;
                }
            String sex = askSex();
                if(!validSex(sex)){
                    System.out.println("Invalid sex inserted");
                    break;
                }
            String bithdate = askDate("BIRTHDATE");
                if(!validDate(bithdate)){
                    System.out.println("Invalid date inserted");
                    break;
                } 
            String registerDate = askDate("REGISTER DATE");
                if(!validDate(registerDate)){
                    System.out.println("Invalid date inserted");
                    break;
                }
            System.out.println("INSERT THE ROLE");
            String role = askRole();
                if(role.equals("NOVALID")){
                    System.out.println("Invalid option");
                    break;
                }
        String ID = generateID("E");
            if (!employeeList.isEmpty()) {
                while (!validGeneratedID(ID, 'E')) {
                    ID = correctID(ID);
                }
            }
        
        employeeList.add(new Employee(name, lastNameF, lastNameM, bithdate, registerDate, role, sex, ID));
        System.out.println("Employee added succesfully!");
        break;
        }
    }
```
Todos los métodos add siguen la misma estructura y lógica. Únicamente pidiendo atributos diferentes al usuario dependiendo el tipo de objeto en cuestión.

### Métodos remove
stos métodos permiten al usuario eliminar una instancia de una clase. Primero se verifica si la lista del tipo de objeto está vacía, ya que no tiene sentido intentar eliminar un objeto si la lista está vacía. Si la lista no está vacía, se muestra al usuario una lista de ID junto con el nombre, para que pueda ingresar en consola el ID del objeto que desea eliminar. Si el usuario ingresa un ID que coincide con uno de los mostrados en la lista, el programa verifica que la instancia de la clase no participe en otra relación, ya que si lo hace y se elimina, la relación se romperá. Si el objeto no participa en otra relación, se elimina y se muestra un mensaje en consola al usuario.
```java
//MÉTODO REMOVE
    public void removeEmployee(){
        if(employeeList.isEmpty()){
            System.out.println("There are not employees registered");
        }
        else{
            String ID = askID('E');
                if (validID('E', ID)){
                    int i = getIndex('E', ID);
                    if (employeeList.get(i).isActiveEmployee()) {
                        System.out.println("This employee participates in other activities, so it's not possible to remove it");
                    }
                    else{
                        employeeList.remove(i);
                        System.out.println("The employee was removed successfully!");
                    }
                }
                else if(!ID.equals("EMPTY")){
                    System.out.println("Invalid ID inserted");
                }
        }
    }
```
### Métodos showList
Estos métodos se encargarán de mostrar la información completa de todas las instancias creadas de la clase. Aprovechando los métodos get con los que cuentan todas las clases que participan en este programa. Al igual que con los métodos remove, el programa se asegurará que si la lista se encuentra vacía se lo haga saber al usuario, ya que no tendría sentido mostrar información de una lista de objetos vacía.
```java
//MÉTODO SHOWLIST
public void showEmployeeList(){
        if (employeeList.isEmpty()) {
            System.out.println("There are not employees registered");
        }
        else{
            System.out.println("---------------------------EMPLOYEES LIST---------------------------");
            for (Employee employee : employeeList) {
                System.out.printf("\n | NAME: %s | FATHER'S LAST NAME: %s | MOTHER'S LAST NAME: %s | ", employee.getName(), employee.getLastnameF(), employee.getLastnameM());
                System.out.printf("\n | BIRTH DATE: %s | REGISTER DATE: %s | ROLE: %s | ", employee.getBirthdate(), employee.getRegisterDate(), employee.getRole());
                System.out.printf("\n | SCHEDULE: %s | SEX: %s | SALARY: % .2f | ", employee.getSchedule(), employee.getSex(), employee.getSalary());
                System.out.printf("\n | CURP: %s | RFC: %s | ID: %s | ", employee.getCURP(), employee.getRFC(), employee.getID());
                System.out.println("\n -------------------------------------------------------------------- ");
            }
        }  
    }   
```
### Métodos showInfo
Estos métodos se encargarán de mostrar la información completa de una instancia en particular de la clase. Para esto se mostrará al usuario los objetos disponibles y se le solicitará que ingrese el ID del cuál desea consultar información. El programa se asegurará que si la lista se encuentra vacía se lo haga saber al usuario, ya que no tendría sentido mostrar información de una lista de objetos vacía.
```java
//MÉTODO SHOWINFO
public void showEmployeeInfo(){
            String ID = askID('E');
                if (validID('E', ID)) {
                    int i = getIndex('E', ID);
                    Employee employee = employeeList.get(i);
                    System.out.printf("\n | NAME: %s | FATHER'S LAST NAME: %s | MOTHER'S LAST NAME: %s | ", employee.getName(), employee.getLastnameF(), employee.getLastnameM());
                    System.out.printf("\n | BIRTH DATE: %s | REGISTER DATE: %s | ROLE: %s | ", employee.getBirthdate(), employee.getRegisterDate(), employee.getRole());
                    System.out.printf("\n | SCHEDULE: %s | SEX: %s | SALARY: % .2f | ", employee.getSchedule(), employee.getSex(), employee.getSalary());
                    System.out.printf("\n | CURP: %s | RFC: %s | ID: %s | ", employee.getCURP(), employee.getRFC(), employee.getID());
                    System.out.println("\n -------------------------------------------------------------------- ");
                }
                else if(!ID.equals("EMPTY")){
                    System.out.println("Invalid ID inserted");
                }
        }
```
### Métodos modify
Este es probablemente el método más interesante, ya que permite al usuario alterar la información de un objeto. Permitiéndole cambiar alguna información en caso de ser errónea o simplemente actualizar algún atributo del objeto. Este método también cuenta con validaciones para asegurarse que no haya errores al momento de que el usuario actualice la información.
```java
public void modifyEmployee(){
        String ID = askID('E');
            if (validID('E', ID)) {
                int i = getIndex('E', ID);
                Employee employee = employeeList.get(i);
                showEmployeeInfo(i);
                boolean flag = true;
                while (flag){
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.print("\nWhich information do you want to modify?");
                    System.out.print("\n1. NAME\n2. FATHER'S LASTNAME\n3. MOTHER'S LASTNAME\n4. BIRTHDATE\n5. REGISTER DATE\n6. ROLE");
                    System.out.print("\n7. SCHEDULE\n8. SEX\n9. SALARY\n10. CURP\n11. RFC\n12. GO BACK TO MAIN MENU");
                    System.out.println("\nSelect an option: ");
                    int x = sc.nextInt();

                    switch (x){
                        case 1:
                            System.out.print("New Name: ");
                                String newName = sc.next();
                                sc.nextLine();
                                if (validName(newName)) {
                                    employee.setName(newName);
                                    System.out.println("Name updated successfully.");
                                }
                                else{
                                    System.out.println("Invalid name inserted");
                                }
                            break;

                        case 2:
                            System.out.print("New Father's lastname: ");
                                String newlstnF = sc.next();
                                sc.nextLine();
                                if (validName(newlstnF)) {
                                    employee.setLastnameF(newlstnF);
                                    System.out.println("Father's lastname updated successfully.");
                                }
                                else{
                                    System.out.println("Invalid father's lastname inserted");
                                }
                            break;

                        case 3:
                            System.out.print("New Mother's lastname: ");
                                String newlstnM = sc.next();
                                sc.nextLine();
                                if (validName(newlstnM)) {
                                    employee.setLastnameM(newlstnM);
                                    System.out.println("Mother's lastname updated successfully.");
                                }
                                else{
                                    System.out.println("Invalid mother's lastname inserted");
                                }
                                
                            break;

                        case 4:
                            String newBirthdate = askDate("NEW BIRTHDATE");
                            if (validDate(newBirthdate)) {
                                employee.setBirthdate(newBirthdate);
                                System.out.println("Birthdate updated successfully."); 
                            }
                            else{
                                System.out.println("Invalid date inserted");
                            }    
                        break;

                        case 5:
                            String newArrivingDay = askDate("NEW REGISTER DATE");
                            if (validDate(newArrivingDay)) {
                                employee.setRegisterDate(newArrivingDay);
                                System.out.println("Register date updated successfully."); 
                            }
                            else{
                                System.out.println("Invalid date inserted");
                            }    
                        break;
                            
                        case 6:
                            if (employee.isActiveEmployee()) {
                                System.out.println("This employee participates in other activities, so it's not possible to modify the role");
                            }
                            else{
                                System.out.println("Insert the new role");
                                String newRole = askRole();
                                    if(newRole.equals("NOVALID")){
                                        System.out.println("Invalid role option");
                                        break;
                                    }
                                    else{
                                        employee.setRole(newRole);
                                        System.out.println("Role updated successfully");
                                    }
                            }
                        break;
                            
                        case 7:
                            System.out.print("Insert the new schedule: ");
                            String newSchedule = sc.next();
                            sc.nextLine();
                                employee.setSchedule(newSchedule);
                            System.out.println("Schedule uptaded successfully.");
                        break;

                        case 8:
                            System.out.print("Insert the new sex: ");
                            String newSex = askSex();
                                if (validSex(newSex)) {
                                    employee.setSex(newSex);
                                    System.out.println("Sex uptaded successfully."); 
                                }
                                else{
                                    System.out.println("Invalid sex inserted");
                                }   
                        break;

                        case 9:
                            System.out.print("Insert the new salary: ");
                            double newSalary = sc.nextDouble();
                                employee.setSalary(newSalary);
                            System.out.println("Salary uptaded successfully."); 
                        break;

                        case 10:
                            System.out.print("Insert the new CURP: ");
                            String newCURP = sc.next();
                            sc.nextLine();
                                employee.setCURP(newCURP);
                            System.out.println("CURP uptaded successfully."); 
                        break;

                        case 11:
                            System.out.print("Insert the new RFC: ");
                            String newRFC = sc.next();
                            sc.nextLine();
                                employee.setRFC(newRFC);
                            System.out.println("RFC uptaded successfully."); 
                        break;

                        default:
                            flag = false;
                        break;


                    }
                    if (flag) {
                        System.out.print("Do you want to continue modifying this employee?(Y/N): ");
                        String answer = sc.next();
                        sc.nextLine();
                        if (!answer.equalsIgnoreCase("Y")) {
                            flag = false;
                        }
                        else{
                            System.out.println("------------------INFORMATION UPDATED------------------");
                            showEmployeeInfo(i);
                        }
                    }
                }
            }
            else if(!ID.equals("EMPTY")){
                System.out.println("Invalid ID inserted");
            }
    }
```
## Métodos relevantes
### Método validDate()
Este método se encarga de validar que las fechas ingresadas por consola siguien la siguiente estructura: __08/06/2004__
```java
private boolean validDate(String cad){
        boolean flag1 = false, flag2 = false, flag3 = false;
            if(cad.length() == 10 && cad.charAt(2)== '/' && cad.charAt(5) == '/'){
            flag1 = true; 
            }   
            if(flag1){   
                if(isNumber(cad.substring(0, 2)) && isNumber(cad.substring(3, 5)) && isNumber(cad.substring(6))){
                    flag2 = true;
                }
            }
            if(flag1 && flag2){
                int day = Integer.parseInt(cad.substring(0, 2));
                int month = Integer.parseInt(cad.substring(3, 5));
                int year = Integer.parseInt(cad.substring(6));
                if(day > 0 && day <= 31 && month > 0 && month <= 12 && year > 1850 && year <= 2024){
                    flag3 = true;
                }
            }
        if(flag1 && flag2 && flag3){
           return true; 
        }
        else{
            return false;
        }
    }
```
---
### Método getIndex()
Este método se encarga de obtener la posición en su respectiva lista. Logramos obtener esta función en un sólo método. Ya que en anteriores ejercicios hacíamos una función para cada tipo de dato. En cambio en este usando un switch logramos ahorrarnos varias líneas de código.
``` java
private int getIndex(char car, String cad){    
    int x = 0;
        switch (car) {
            case 'V':
                for (int i = 0; i < visitantList.size(); i++) {
                    if(cad.equals(visitantList.get(i).getID())){
                        x = i;
                    }
                }
            break;

            case 'E':
                for (int i = 0; i < employeeList.size(); i++) {
                    if(cad.equals(employeeList.get(i).getID())){
                        x = i;
                    }
                }
            break;

            case 'A':
                for (int i = 0; i < animalList.size(); i++) {
                    if(cad.equals(animalList.get(i).getID())){
                        x = i;
                    }
                }
            break;

            case 'Z':
                for (int i = 0; i < zooVisitList.size(); i++) {
                    if(cad.equals(zooVisitList.get(i).getID())){
                        x = i;
                    }
                }
            break;

            case 'M':
                for (int i = 0; i < maintenanceList.size(); i++) {
                    if(cad.equals(maintenanceList.get(i).getID())){
                        x = i;
                    }
                }
            break;
        }
    return x;
    }
```
### Método modifyDiseasesList()
Este método consideramos relevante mencionarlo ya que hace dinámica la experiencia del usuario. Este le permite añadir, modificar y eliminar enfermedades de la lista de enfermedades de los objetos de tipo Animal. Resultando fácil e intuitivo de utilizar.
``` java
private void modifyDiseasesList(Animal animal){
            while (true){
                animal.showDiseasesList();
                    if(animal.getDiseases().isEmpty()){
                        System.out.println("Do you want to add a disease to the list?(Y/N)");
                        if (sc.next().equalsIgnoreCase("Y")) {
                            System.out.println("Insert the name of the disease");
                                String dis = sc.nextLine();
                                    animal.getDiseases().add(dis);
                                System.out.println("Disease added succesfully");
                        }    
                    }
                    else{
                        System.out.println("Do you want to add(A) or remove(R) or modify(M) a disease of the list?");
                            String letter = sc.next();
                            switch (letter) {
                                case "R":
                                    System.out.println("Which disease is being removed? Insert the number");
                                    int i = sc.nextInt();
                                    if(i > 0 && i <= animal.getDiseases().size()){
                                        animal.getDiseases().remove(i - 1);
                                        System.out.println("Disease removed succesfully");
                                    }
                                    else{
                                        System.out.println("Invalid option inserted");
                                    }
                                break;

                                case "M":
                                    System.out.println("Which disease is being removed? Insert the number");
                                        int n = sc.nextInt();
                                        if(n > 0 && n <= animal.getDiseases().size()){
                                            System.out.println("Insert the name of the disease");
                                                animal.getDiseases().set(n - 1, sc.nextLine());
                                            System.out.println("Disease modified succesfully");
                                        }
                                        else{
                                            System.out.println("Invalid option inserted");
                                        }
                                break;

                                case "A":
                                        System.out.println("Insert the name of the disease");
                                        String dis = sc.nextLine();
                                            animal.getDiseases().add(dis);
                                        System.out.println("Disease added succesfully");
                                break;

                                default:
                                    System.out.println("Invalid option inserted");
                                break;
                            }
                    }
            System.out.println("Do you want to continue modifying the diseases list?(Y/N)");
                if (!sc.next().equalsIgnoreCase("Y")) {
                    break;
                }
            }
    }
```
## Conclusiones
Este proyecto nos resultó un tanto desafiante e interesante a la vez. Ya que utilizamos todos los conocimientos adquiridos en la segunda unidad de la materia de Progamación Orientada a Objetos.

Además nos provocó cierta emoción entender como es que funcionan algunos de los sistemas de registro más complejos del mundo. Que si bien en este proyecto hicimos una mínima parte de esos sistemas, nos pareció sorprendente el potencial que tiene la programación para el adecuado funcionamiento y organización de las empresas en todo el mundo.