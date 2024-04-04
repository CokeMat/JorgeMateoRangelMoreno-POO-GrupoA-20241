import java.util.*;
public class Zoo {
    Scanner sc = new Scanner(System.in);
    Random ran = new Random();
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ArrayList<Visitant> visitantList = new ArrayList<>();
    private ArrayList<Animal> animalList = new ArrayList<>();
    private ArrayList<Maintenance> maintenanceList = new ArrayList<>();
    private ArrayList<ZooVisit> zooVisitList = new ArrayList<>();

    //MÉTODO PARA HACER PRUEBAS
    /*public void prueba(){
        visitantList.add(new Visitant("Edgar", "Martinez", "Lopez", "22/11/2005", "20/04/2018", "M", generateID("V")));
        visitantList.add(new Visitant("Gabriel", "Chacon", "Arellano", "11/05/2005", "12/04/2010","M", generateID("V")));
        visitantList.add(new Visitant("Juana", "Lopez", "Hernandez", "22/11/2008", "20/04/2014","F", generateID("V")));
        visitantList.add(new Visitant("Jorge", "Rangel", "Moreno", "22/11/2005", "15/12/2024","M", generateID("V")));
        visitantList.add(new Visitant("Ximena", "Baltierra", "Lopez", "16/06/2006", "30/01/2024","F", generateID("V")));
        visitantList.add(new Visitant("Leo", "Messi", "Cuchittini", "14/06/1986", "20/04/2018","M", generateID("V")));
        visitantList.add(new Visitant("Pepito", "Rangel", "Moreno", "22/11/2010", "15/12/2024","M", generateID("V")));
        visitantList.add(new Visitant("Luisito", "Baltierra", "Lopez", "16/06/2012", "30/01/2024","F", generateID("V")));
        visitantList.add(new Visitant("Pedrito", "Messi", "Cuchittini", "14/06/2008", "20/04/2018","M", generateID("V")));
        
        
        employeeList.add(new Employee("Juanito", "Perez", "Dominguez", "22/11/2005", "20/04/2012", "Guide", "M", generateID("E")));
        employeeList.add(new Employee("Cristiano", "Dosantos", "Aveiro", "10/11/1995", "25/11/2014", "Veterinary","F", generateID("E")));
        employeeList.add(new Employee("Erling", "Braul", "Halland", "22/01/1989", "27/05/2020", "Guide","M", generateID("E")));
        employeeList.add(new Employee("Neymar", "Dosantos", "Jr", "16/04/1970", "30/01/2012", "Maintenance","M", generateID("E")));
        employeeList.add(new Employee("Thomas", "Muller", "Poll", "01/01/1969", "31/06/2018", "Veterinary","F", generateID("E")));
        employeeList.add(new Employee("Herry", "LaBomba", "Martin", "20/10/2000", "10/07/2021", "Maintenance","M", generateID("E")));
        
        ArrayList arregloEnfermedades1 = new ArrayList<>();
        ArrayList arregloEnfermedades2 = new ArrayList<>();
        arregloEnfermedades1.add("Enfermedad1");
        arregloEnfermedades1.add("Enfermedad2");
        arregloEnfermedades1.add("Enfermedad3");
        arregloEnfermedades1.add("Enfermedad4");
        arregloEnfermedades1.add("Enfermedad5");
        animalList.add(new Animal("Toby", "Vertebrado", "Carne", "Diario" ,90.56, "04/06/1999", "08/11/2004", true, arregloEnfermedades1, generateID("A")));
        animalList.add(new Animal("Jorge", "Vertebrado", "Carne", "Diario", 90.56, "04/06/1999", "08/11/2004", true, arregloEnfermedades2, generateID("A")));
        animalList.add(new Animal("Toby", "invertebrado", "Vegetariano", "Diario", 100.56, "20/05/1998", "08/11/2014", true, arregloEnfermedades2, generateID("A")));
        animalList.add(new Animal("Max", "anélido", "Carne",  "Diario", 10.56, "04/04/2001", "08/11/2012", false, arregloEnfermedades1, generateID("A")));
        animalList.add(new Animal("Mabappe", "poriferos", "Carne",  "Diario",90.56, "04/06/2000", "08/11/2018", false, arregloEnfermedades1, generateID("A")));
        animalList.add(new Animal("Duck", "Vertebrado", "plantas",  "Diario",10.00, "04/06/1086", "08/11/1990", true, arregloEnfermedades2, generateID("A")));
    */

    //MÉTODOS ADD
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
                if (!validName(lastNameM)) {
                    System.out.println("Invalid  mother's name inserted");
                    break;
                }
            String sex = askSex();
                if(!validSex(sex)){//M, m, f ,F
                    System.out.println("Invalid sex inserted");
                    break;
                }
            String bithdate = askDate("BIRTHDATE");//12/08/2006
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
        String ID = generateID("E"); //EA1234
            if (!employeeList.isEmpty()) {
                while (!validGeneratedID(ID, 'E')) {
                    ID = correctID(ID); //EA12341
                }
            }
        
        employeeList.add(new Employee(name, lastNameF, lastNameM, bithdate, registerDate, role, sex, ID));
        System.out.println("Employee added succesfully!");
        break;
        }
    }
       
    public void addVisitant(){
        while (true) {
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
                if (!validName(lastNameM)) {
                    System.out.println("Invalid name inserted");
                    break;
                }
            String sex = askSex();
                if(!validSex(sex)){
                    System.out.println("Invalid sex inserted");
                    break;
                }
            String birthdate = askDate("BIRTHDATE");
                if(!validDate(birthdate)){
                    System.out.println("Invalid date inserted");
                    break;
                } 
            String registerDate = askDate("REGISTER DATE");
                if(!validDate(registerDate)){
                    System.out.println("Invalid date inserted");
                    break;
                }
            String ID = generateID("V");
                if (!visitantList.isEmpty()) {
                    while (!validGeneratedID(ID, 'V')) {
                        ID = correctID(ID);
                    }
                }
        visitantList.add(new Visitant(name, lastNameF, lastNameM, birthdate, registerDate, sex, ID));
        System.out.println("Visitant added successfully!!");  
        break;    
        }  
    }

    public void addAnimal(){
        while (true) {
            System.out.println("INSERT THE NAME");
            String name = sc.nextLine();
            System.out.println("INSERT THE ANIMAL TYPE");
            String animalType = sc.nextLine();
            System.out.println("INSERT THE ANIMAL'S FOOD TYPE");
            String foodType = sc.nextLine();
            System.out.println("INSERT THE FOOD FREQUENCY");
            String foodFrequency = sc.nextLine();
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
            System.out.println("INSERT THE WEIGHT");
            double weight = sc.nextDouble();

            boolean isVaccinated;
            System.out.println("IS THE ANIMAL VACCINATED?(Y/N)");
            String answer = sc.next();
            sc.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                isVaccinated = true;
            }
            else if(answer.equalsIgnoreCase("N")){
                isVaccinated = false;
            }
            else{
                System.out.println("Invalid option");
                break;
            }

            ArrayList<String> diseases = new ArrayList<>();
            System.out.println("Does the animal have any diseases?");
            if (sc.next().equalsIgnoreCase("Y")) {
                while (true) {
                    System.out.println("Insert the disease");
                    diseases.add(sc.nextLine());
                        System.out.println("Do you want to register another disease?");
                        if (sc.next().equalsIgnoreCase("N")) {
                            break;
                        }
                }
            }
            String ID = generateID("A");
                if (!animalList.isEmpty()) {
                    while (!validGeneratedID(ID, 'A')) {
                        ID = correctID(ID);
                    }
                }

        animalList.add(new Animal(name, animalType, foodType, foodFrequency, weight, bithdate, registerDate, isVaccinated, diseases, ID));
        System.out.println("Animall added successfully!!");
        break;    
        }
    }

    public void addZooVisit(){
        while (true) {
            //PARA EL GUÍA(1)
            Employee guide;
            if(haveGuides()){
                System.out.println("--------THESE ARE THE GUIDES AVAILABLE--------");
                for (Employee employee : employeeList) {
                    if(employee.getRole().equals("Guide")){
                        System.out.printf("\n | NAME: %s | ID: %s | ", employee.getFullName(), employee.getID());
                    } 
                }
                    System.out.print("\nInsert the ID of the guide: ");
                    String ID = sc.next();
                    sc.nextLine();
                        if(validID('E', ID)){
                            int i = getIndex('E', ID);
                            guide = employeeList.get(i);
                        }
                        else{
                            System.out.println("Invalid ID inserted");
                            break;
                        }
            }
            else{
               System.out.println("There are not guides registered, to register a zoo visit it must exist at least one guide in the system."); 
               break;
            }
            //PARA LA FECHA
            String date = askDate("DATE OF THE VISIT");
                if (!validDate(date)) {
                    System.out.println("Invalid date inserted");
                    break;
                }
            //PARA LLOS VISITANTES(1...N)
            //SI YA AGREGÓ UN VISITANTE QUE NO LO PUEDA VOLVER A AGREGAR
            ArrayList<Visitant> zooVisitants = new ArrayList<>();
            if (visitantList.isEmpty()) {
                System.out.println("There are not visitants registered");
                break;
            }
            else{
                //HACER UN ARREGLO CON TODOS LOS ID QUE ELIJA, CUANDO TERMINE AGREGARLOS TODOS AL ARRAYLIST DE ZOOVISIT
                //AGREGAR AL PRIMER VISITANTE
                String ID = askID('V');
                    if (validID('V', ID)) {
                        zooVisitants.add(visitantList.get(getIndex('V', ID)));
                        System.out.println("The visitant was added to the zoo visit");
                    }
                    else{
                        System.out.println("Invalid ID inserted");
                        break;
                    }
                    
                //AGREGAR MÁS VISITANTES
                    int n = 1;
                    while (n != visitantList.size()) {
                            System.out.println("\n These are the visitants added to zoo visit");
                            for (Visitant visitant : zooVisitants) {
                                System.out.printf(" \n | VISITANT NAME: %s | VISITANT ID: %s | ",visitant.getFullName(), visitant.getID());
                            }
                            boolean flag = true;
                            System.out.print("\nDo you want to add another visitant(Y/N)");
                                if(sc.next().equalsIgnoreCase("Y")){
                                    String Id = askID('V');
                                        if (validID('V', Id)) {
                                            for (Visitant  visitant: zooVisitants) {
                                                if(visitant.getID().equals(Id)){
                                                    flag = false;
                                                    System.out.println("This visitant has already been added to the visit");
                                                    break;
                                                }
                                            }
                                                if(flag){
                                                    zooVisitants.add(visitantList.get(getIndex('V', Id)));
                                                    System.out.println("The visitant was added to the zoo visit");
                                                    n++;
                                                }   
                                        }
                                        else{
                                            System.out.println("Invalid ID inserted");
                                        }
                            }
                            else{
                                break;
                            }
                        if(n == visitantList.size()){
                            System.out.println("You have added all the visitants avaliable");
                        }
                    } 
            }
            String ID = generateID("ZV");
            if (!zooVisitList.isEmpty()) {
                while (!validGeneratedID(ID, 'Z')) {
                    ID = correctID(ID);
                }
            }
    zooVisitList.add(new ZooVisit(guide, date, zooVisitants, ID));
    System.out.println("Zoo visit added successfully!!");
    break; 
        }
    }

    public void addMaintenance(){
        while (true) {
            Employee maintenanceEmployee;
            if(haveMaintenanceEmployees()){
                System.out.println("--------THESE ARE THE MAINTENANCE EMPLOYEES AVAILABLE--------");
                for (Employee employee : employeeList) {
                    if(employee.getRole().equals("Maintenance")){
                        System.out.printf("\n | NAME: %s | ID: %s | ", employee.getFullName(), employee.getID());
                    } 
                }
                    System.out.print("\nInsert the ID: ");
                    String ID = sc.next();
                    sc.nextLine();
                        if(validID('E', ID)){
                            int i = getIndex('E', ID);
                            maintenanceEmployee = employeeList.get(i);
                        }
                        else{
                            System.out.println("Invalid ID inserted");
                            break;
                        }
            }
            else{
               System.out.println("There are not maintenance employees registered"); 
               break;
            }
            String date = askDate("DAY OF THE MAINTENANCE");
                if(!validDate(date)){
                    System.out.println("Invalid date inserted");
                    break;
                }
            System.out.println("INSERT THE ACTION MADE DURING THE MAINTENANCE");
            String action = sc.nextLine();
            String animalID = askID('A');
                if (!validID('A', animalID)) {
                    System.out.println("Invalid ID inserted");
                    break;
                }
                else{
                    int i = getIndex('A', animalID);
                        Animal animal = animalList.get(i);
                        animal.setActiveAnimal(true);
                }
            String observations = "NO OBSERVATIONS REGISTERED";
            System.out.println("Do you want to add some observations?(Y/N)");
                if (sc.next().equalsIgnoreCase("Y")) {
                    System.out.println("INSERT THE OBSERVATION");
                    observations = sc.nextLine();
                }
        String ID = generateID("M");
        if (!maintenanceList.isEmpty()) {
            while (!validGeneratedID(ID, 'M')) {
                ID = correctID(ID);
            }
        }
        maintenanceList.add(new Maintenance(maintenanceEmployee, date, action, animalID, observations, ID));
        System.out.println("Maintenance added successfully!!");
        break;
        }
    }
    
    //MÉTODOS REMOVE
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

    public void removeVisitant(){
        if(visitantList.isEmpty()){
            System.out.println("There are not visitants registered");
        }
        else{
            String ID = askID('V');
                if (validID('V', ID)){
                    int i = getIndex('V', ID);
                    if (visitantList.get(i).isActiveVisitant()) {
                        System.out.println("This visitant participates in other activities, so it's not possible to remove it");
                    }
                    else{
                        visitantList.remove(i);
                        System.out.println("The visitant was removed successfully!");
                    }
                }
                else if(!ID.equals("EMPTY")){
                    System.out.println("Invalid ID inserted");
                }
        }
    }

    public void removeAnimal(){
        if(animalList.isEmpty()){
            System.out.println("There are not animals registered");
        }
        else{
            String ID = askID('A');
                if (validID('A', ID)){
                    int i = getIndex('A', ID);
                        if (animalList.get(i).isActiveAnimal()) {
                            System.out.println("This animal participates in other activities, so it can't be removed");
                        }
                        else{
                            animalList.remove(i);
                            System.out.println("The animal was removed successfully!");
                        }
                }
                else if(!ID.equals("EMPTY")){
                    System.out.println("Invalid ID inserted");
                }
        }
    }

    //MÉTODOS SHOW LIST CON INFO COMPLETA
    //FUNCIONA CORRECTAMENTE
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

    //FUNCIONA CORRECTAMENTE
    public void showVisitantList(){
        if (visitantList.isEmpty()) {
            System.out.println("There are not visitants registered");
        }
        else{
            System.out.println("---------------------------VISITANTS LIST---------------------------");
            for (Visitant visitant : visitantList) {
                System.out.printf("\n | NAME: %s | FATHER'S LAST NAME: %s | MOTHER'S LAST NAME: %s | ", visitant.getName(), visitant.getLastNameF(), visitant.getLastNameM());
                System.out.printf("\n | BIRTH DATE: %s | REGISTER DATE: %s | NUMBER OF VISITS: %d | ", visitant.getBirthdate(), visitant.getRegisterDate(), visitant.getNumVisits());
                System.out.printf("\n | SEX: %s | CURP: %s | ID: %s | ", visitant.getSex(), visitant.getCurp(), visitant.getID());
                System.out.println("\n -------------------------------------------------------------------- ");
            }
        } 
    }

    //FUNCIONA CORRECTAMENTE
    public void showAnimalList(){
        if (animalList.isEmpty()) {
            System.out.println("There are not animals registered");
        }
        else{
            System.out.println("---------------------------ANIMALS LIST---------------------------");
            for (Animal animal : animalList) {
                    System.out.printf("\n | NAME: %s | AINMAL TYPE: %s | FOOD TYPE: %s | ", animal.getName(), animal.getAnimalType(), animal.getFoodType());
                    System.out.printf("\n | BIRTH DATE: %s | REGISTER DATE: %s | WEIGHT: % .2f kg | ", animal.getBirthdate(), animal.getRegisterDate(), animal.getWeight());
                    System.out.printf("\n | IS VACCINATED: %s  | FOOD FREQUENCY: %s | ID: %s | ", animal.isVaccinated(), animal.getFoodFrecuency(), animal.getID());
                        animal.showDiseasesList();
                System.out.println("\n -------------------------------------------------------------------- ");
            }
        }
    }
    //FUNCIONA CORRECTAMENTE
    public void showZooVisitList(){
        if (zooVisitList.isEmpty()) {
            System.out.println("There are not zoo visits registered");
        }
        else{
            System.out.println("---------------------------ZOO VISITS LIST---------------------------");
            for (ZooVisit zooVisit : zooVisitList) {
                System.out.printf("\n | GUIDE'S NAME: %s | GUIDE'S ID: %s | VISIT DATE: %s |" , zooVisit.getGuide().getFullName(),
                    zooVisit.getGuide().getID(), zooVisit.getVisitDate());
                System.out.println("\nTHESE ARE THE VISITANT/S OF THE ZOO VISIT");
                    for (Visitant visitant : zooVisit.getVisitantList()) {
                        System.out.printf("\n | NAME: %s | ID: %s |", visitant.getFullName(), visitant.getID());
                    }
                System.out.printf("\n | NUMBER OF ADULTS: %d | NUMBER OF CHILDREN : %d | VISIT COST: % .2f|", zooVisit.getNumAdult(),
                    zooVisit.getNumChild(), zooVisit.getAmount());
            System.out.println("\n -------------------------------------------------------------------- ");
            }
        }  
    }

    public void showMaintenanceList() {
        if (maintenanceList.isEmpty()) {
            System.out.println("There are not maintenances registered");
        }
        else{
            System.out.println("---------------------------MAINTENANCES LIST---------------------------");
            for (Maintenance maintenance : maintenanceList) {
                System.out.printf("\n | MAINTENANCE EMPLOYEE NAME: %s |  MAINTENANCE EMPLOYEE ID: %s |" , maintenance.getMaintenanceEmployee().getFullName(), 
                    maintenance.getMaintenanceEmployee().getID());
                System.out.printf("\n | ACTION: %s | (ID)ANIMAl: %s | DATE: %s |", maintenance.getAction(), maintenance.getAnimalID(), maintenance.getDate());
                System.out.printf("\n | OBSERVATIONS: %s |", maintenance.getObservation());
                System.out.println("\n -------------------------------------------------------------------- ");
            }
        }
    }

    //MÉTODOS SHOW LIST SÓLO CON ID Y NOMBRE
    public boolean showEmployeeListID(){
        if (employeeList.isEmpty()) {
            System.out.println("There are not employees registered");
            return false;
        }
        else{
            System.out.println("---------------EMPLOYEE LIST------------------------");
            for (Employee employee : employeeList) {
                System.out.printf("\n | NAME: %s | ID: %s | ", employee.getFullName(), employee.getID());
            }
            return true;
        }  
    }

    public boolean showVisitantListID(){
        if (visitantList.isEmpty()) {
            System.out.println("There are not visitants registered");
            return false;
        }
        else{
            System.out.println("---------------VISITANTS LIST------------------------");
            for (Visitant visitant : visitantList) {
                System.out.printf("\n | NAME: %s | ID: %s | ", visitant.getFullName(), visitant.getID());
            }
            return true;
        } 
    }

    public boolean showAnimalListID(){
        if (animalList.isEmpty()) {
            System.out.println("There are not animals registered");
            return false;
        }
        else{
            System.out.println("---------------ANIMALS LIST------------------------");
            for (Animal animal : animalList) {
                System.out.printf("\n | NAME: %s | ID: %s | ", animal.getName(), animal.getID());
            }
            return true;
        }
    }
    
    public boolean showZooVisitListID(){
        if (zooVisitList.isEmpty()) {
            System.out.println("There are not zoo visits registered");
            return false;
        }
        else{
            System.out.println("---------------ZOO VISITS LIST------------------------");
            for (ZooVisit zooVisit : zooVisitList) {
                System.out.printf("\n | VISIT DATE: %s | ID: %s | ", zooVisit.getVisitDate(), zooVisit.getID());
            }
            return true;
        }
    }

    public boolean showMaintenanceListID(){
        if (maintenanceList.isEmpty()) {
            System.out.println("There are not maintenances registered");
            return false;
        }
        else{
            System.out.println("---------------MAINTENANCES LIST------------------------");
            for (Maintenance maintenance : maintenanceList) {
                System.out.printf("\n | DATE: %s | ID: %s | ", maintenance.getDate(), maintenance.getID());
            }
            return true;
        } 
    }

    //MÉTODOS SHOW INFO DE UN OBJETO ESPECÍFICO
    //FUNCIONA CORRECTAMENTE
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

    public void showEmployeeInfo(int i){
        Employee employee = employeeList.get(i);
        System.out.printf("\n | NAME: %s | FATHER'S LAST NAME: %s | MOTHER'S LAST NAME: %s | ", employee.getName(), employee.getLastnameF(), employee.getLastnameM());
        System.out.printf("\n | BIRTH DATE: %s | REGISTER DATE: %s | ROLE: %s | ", employee.getBirthdate(), employee.getRegisterDate(), employee.getRole());
        System.out.printf("\n | SCHEDULE: %s | SEX: %s | SALARY: % .2f | ", employee.getSchedule(), employee.getSex(), employee.getSalary());
        System.out.printf("\n | CURP: %s | RFC: %s | ID: %s | ", employee.getCURP(), employee.getRFC(), employee.getID());
    }

    //FUNCIONA CORRECTAMENTE
    public void showVisitantInfo(){
        String ID = askID('V');
            if (validID('V', ID)) {
                int i = getIndex('V', ID);
                Visitant visitant = visitantList.get(i);
                System.out.printf("\n | NAME: %s | FATHER'S LAST NAME: %s | MOTHER'S LAST NAME: %s | ", visitant.getName(), visitant.getLastNameF(), visitant.getLastNameM());
                System.out.printf("\n | BIRTH DATE: %s | REGISTER DATE: %s | NUMBER OF VISITS: %d | ", visitant.getBirthdate(), visitant.getRegisterDate(), visitant.getNumVisits());
                System.out.printf("\n | SEX: %s | CURP: %s | ID: %s | ", visitant.getSex(), visitant.getCurp(), visitant.getID());
                System.out.println("\n -------------------------------------------------------------------- ");
            }
            else if(!ID.equals("EMPTY")){
                System.out.println("Invalid ID inserted");
            }
    }

    public void showVisitantInfo(int i){
        Visitant visitant = visitantList.get(i);
        System.out.printf("\n | NAME: %s | FATHER'S LAST NAME: %s | MOTHER'S LAST NAME: %s | ", visitant.getName(), visitant.getLastNameF(), visitant.getLastNameM());
        System.out.printf("\n | BIRTH DATE: %s | REGISTER DATE: %s | NUMBER OF VISITS: %d | ", visitant.getBirthdate(), visitant.getRegisterDate(), visitant.getNumVisits());
        System.out.printf("\n | SEX: %s | CURP: %s | ID: %s | ", visitant.getSex(), visitant.getCurp(), visitant.getID());
    }

    //FUNCIONA CORRECTAMENTE
    public void showAnimalInfo(){
        String ID = askID('A');
            if (validID('A', ID)) {
                int i = getIndex('A', ID);
                Animal animal = animalList.get(i);
                System.out.printf("\n | NAME: %s | AINMAL TYPE: %s | FOOD TYPE: %s | ", animal.getName(), animal.getAnimalType(), animal.getFoodType());
                    System.out.printf("\n | BIRTH DATE: %s | REGISTER DATE: %s | WEIGHT: % .2f kg | ", animal.getBirthdate(), animal.getRegisterDate(), animal.getWeight());
                    System.out.printf("\n | IS VACCINATED: %s | ID: %s | ", animal.isVaccinated(), animal.getID());
                    animal.showDiseasesList();
                System.out.println("\n -------------------------------------------------------------------- ");
            }
            else if(!ID.equals("EMPTY")){
                System.out.println("Invalid ID inserted");
            }
    }

    public void showAnimalInfo(int i){
        Animal animal = animalList.get(i);
        System.out.printf("\n | NAME: %s | AINMAL TYPE: %s | FOOD TYPE: %s | ", animal.getName(), animal.getAnimalType(), animal.getFoodType());
            System.out.printf("\n | BIRTH DATE: %s | REGISTER DATE: %s | WEIGHT: % .2f kg | ", animal.getBirthdate(), animal.getRegisterDate(), animal.getWeight());
            System.out.printf("\n | IS VACCINATED: %s  | FOOD FREQUENCY: %s | ID: %s | ", animal.isVaccinated(), animal.getFoodFrecuency(), animal.getID());
            animal.showDiseasesList();
        System.out.println("\n -------------------------------------------------------------------- ");
    }

    //FUNCIONA CORRECTAMENTE
    public void showZooVisitInfo(){
        String ID = askID('Z');
            if (validID('Z', ID)) {
                int i = getIndex('Z', ID);
                ZooVisit zooVisit = zooVisitList.get(i);//MANUAL COORECTION
                        System.out.printf("\n | GUIDE'S NAME: %s | GUIDE'S ID: %s | VISIT DATE: %s |" , zooVisit.getGuide().getFullName(),
                            zooVisit.getGuide().getID(), zooVisit.getVisitDate());
                        System.out.println("THESE ARE THE VISITANT/S OF THE ZOO VISIT");
                            for (Visitant visitant : zooVisit.getVisitantList()) {
                                System.out.printf("\n | NAME: %s | ID: %s |", visitant.getFullName(), visitant.getID());
                            }
                        System.out.printf("\n | NUMBER OF ADULTS: %d | NUMBER OF CHILDREN : %d | VISIT COST: % .2f|", zooVisit.getNumAdult(),
                            zooVisit.getNumChild(), zooVisit.getAmount());
                            System.out.println("\n -------------------------------------------------------------------- ");
            }
            else if(!ID.equals("EMPTY")){
                System.out.println("Invalid ID inserted");
            }
    }

    //FUNCIONA CORRECTAMENTE
    public void showMaintenanceInfo(){
        String ID = askID('M');
            if (validID('M', ID)) {
                int i = getIndex('M', ID);
                    Maintenance maintenance = maintenanceList.get(i);//MANUAL COORECTION
                        System.out.printf("\n | MAINTENANCE EMPLOYEE NAME: %s |  MAINTENANCE EMPLOYEE ID: %s |" , maintenance.getMaintenanceEmployee().getFullName(), 
                            maintenance.getMaintenanceEmployee().getID());
                        System.out.printf("\n | ACTION: %s | (ID)ANIMAl: %s | DATE: %s |", maintenance.getAction(), maintenance.getAnimalID(), maintenance.getDate());
                        System.out.printf("\n | OBSERVATIONS: %s |", maintenance.getObservation());
                        System.out.println("\n -------------------------------------------------------------------- ");
            }
            else if(!ID.equals("EMPTY")){
                System.out.println("Invalid ID inserted");
            }
    }

    //MÉTODOS MODIFY 
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


                    }//SWITCH
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
                }//WHILE
            }//IF
            else if(!ID.equals("EMPTY")){
                System.out.println("Invalid ID inserted");
            }
    }//MÉTODO

    public void modifyVisitant(){
        String ID = askID('V');
            if (validID('V', ID)) {
                int i = getIndex('V', ID);
                Visitant visitant = visitantList.get(i);
                showVisitantInfo(i);
                boolean flag = true;
                while (flag){
                    System.out.println("\nWhich information do you want to modify?");
                    System.out.print("\n1. NAME\n2. FATHER'S LASTNAME\n3. MOTHER'S LASTNAME\n4. SEX\n5. BIRTHDATE\n6. REGISTER DATE");
                    System.out.print("\n7. CURP\n8. GO BACK TO MAIN MENU \nSelect an option: ");
                    int x = sc.nextInt();

                    switch (x){
                        case 1:
                            System.out.println("New Name: ");
                                String newName = sc.next();
                                sc.nextLine();
                                if (validName(newName)) {
                                    visitant.setName(newName);
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
                                    visitant.setLastNameF(newlstnF);
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
                                    visitant.setLastNameM(newlstnM);
                                    System.out.println("Mother's lastname updated successfully.");
                                }
                                else{
                                    System.out.println("Invalid mother's lastname inserted");
                                }
                                
                            break;
                        case 4:
                            System.out.print("Insert the new sex: ");
                            String newSex = askSex();
                                if (validSex(newSex)) {
                                    visitant.setSex(newSex);
                                    System.out.println("Sex uptaded successfully."); 
                                }
                                else{
                                    System.out.println("Invalid sex inserted");
                                }  
                                break;

                        case 5:
                            String newBirthdate = askDate("NEW BIRTHDATE");
                            if (validDate(newBirthdate)) {
                                visitant.setBirthdate(newBirthdate);
                                System.out.println("Birthdate updated successfully."); 
                            }
                            else{
                                System.out.println("Invalid date inserted");
                            }    
                        break;

                        case 6:
                            String newArrivingDay = askDate("NEW REGISTER DATE");
                            if (validDate(newArrivingDay)) {
                                visitant.setRegisterDate(newArrivingDay);
                                System.out.println("Register date updated successfully."); 
                            }
                            else{
                                System.out.println("Invalid date inserted");
                            }    
                        break;

                        case 7: 
                            System.out.println("INSERT THE NEW CURP");
                            String newCURP = sc.next();
                            sc.nextLine();
                            visitant.setCurp(newCURP);
                        break;
                        
                        default:
                            flag = false;
                        break;
                    }//SWITCH
                    if(flag){
                        System.out.print("\nDo you want to continue modifying this visitant?(Y/N): ");
                        String answer = sc.next();
                        sc.nextLine();
                        if (!answer.equalsIgnoreCase("Y")) {
                            flag = false;
                        }
                        else{
                            System.out.println("------------------INFORMATION UPDATED------------------");
                            showVisitantInfo(i);
                        }
                    }
                }//WHILE
            }//IF
            else if(!ID.equals("EMPTY")){
                System.out.println("Invalid ID inserted");
            }
    }//MÉTODO

    public void modifyAnimal(){
        String ID = askID('A');
            if (validID('A', ID)) {
                int i = getIndex('A', ID);
                Animal animal = animalList.get(i);
                showAnimalInfo(i);
                boolean flag = true;
                while (flag){
                    System.out.println("\nWhich information do you want to modify?");
                    System.out.print("\n1. NAME\n2. ANIMAL TYPE\n3. FOOD TYPE\n4. WEIGHT\n5. BIRTHDATE\n6. REGISTER DATE\n7. IS VACCCINATED\n8. FOOD FREQUENCY\n9. MODIFY DISEASES LIST\n10. RETURN TO MAIN MENU");
                    System.out.println("\nSelect an option: ");
                    int x = sc.nextInt();

                    switch (x){
                        case 1:
                            System.out.println("New Name: ");
                            String newName = sc.next();
                            sc.nextLine();
                            animal.setName(newName);
                            System.out.println("Name updated successfully.");
                            break;
                        case 2:
                            System.out.print("New Animal Type: ");
                            String newAnimalType = sc.next();
                            sc.nextLine();
                            animal.setAnimalType(newAnimalType);
                            System.out.println("Animal type updated successfully.");
                            break;
                        case 3:
                            System.out.println("New Food Type: ");
                            String newTypeFood = sc.next();
                            sc.nextLine();
                            animal.setFoodType(newTypeFood);
                            System.out.println("Food type updated successfully.");
                            break;
                        case 4:
                            System.out.println("New Weight: ");
                            double newWeight = sc.nextDouble();
                            animal.setWeight(newWeight);
                            System.out.println("Weight updated successfully.");
                            break;
                        case 5:
                            String newBirthdate = askDate("NEW BIRTHDATE");
                            if (validDate(newBirthdate)) {
                                animal.setBirthdate(newBirthdate);
                                System.out.println("Birthdate updated successfully."); 
                            }
                            else{
                                System.out.println("Invalid date inserted");
                            }   
                        break;
                            
                        case 6:
                            String newArrivingDay = askDate("NEW REGISTER DATE");
                            if (validDate(newArrivingDay)) {
                                animal.setRegisterDate(newArrivingDay);
                                System.out.println("Register date updated successfully."); 
                            }
                            else{
                                System.out.println("Invalid date inserted");
                            }
                        break;
                            
                        case 7:
                            System.out.println("Is the animal vaccined?(Y/N)");
                            if (sc.next().equalsIgnoreCase("Y")) {
                                animal.setVaccinated(true);
                                System.out.println("Vaccinated status updated successfully");
                            }
                            else if(sc.next().equalsIgnoreCase("N")){
                                animal.setVaccinated(false);
                                System.out.println("Vaccinated status updated successfully");
                            }
                            else{
                                System.out.println("Invalid answer");
                            }
                        break;

                        case 8:
                            System.out.println("INSERT THE NEW FOOD FREQUENCY");
                            String newFoodFrequency = sc.next();
                            sc.nextLine();
                            animal.setFoodFrecuency(newFoodFrequency);
                        break;

                        case 9:
                            modifyDiseasesList(animal); 
                            break;

                        default:
                            flag = false;
                        break;


                    }
                    if (flag) {
                        System.out.print("\nDo you want to continue modifying this animal?(Y/N)");
                            String answer = sc.next();
                            sc.nextLine();
                            if (!answer.equalsIgnoreCase("Y")) {
                                flag = false;
                            }
                            else{
                                System.out.println("------------------INFORMATION UPDATED------------------");
                                showAnimalInfo(i);
                            }
                    }
                }
            }
            else if(!ID.equals("EMPTY")){
                System.out.println("Invalid ID inserted");
            }
    }

    //MÉTODOS AUXILIARES

    private String askSex(){
        System.out.println("INSERT THE SEX(M/F)");
        String sex = sc.next();
        sc.nextLine();
        return sex;
    }

    private boolean validSex(String cad){
        cad = cad.toUpperCase();
        boolean flag = false;
            if(cad.equals("M") || cad.equals("F")){
                flag = true;
            }   
    return flag;
    }

    private String askDate(String data){
        System.out.println("INSERT THE "+ data);
        System.out.print("\nEXAMPLE: 08/10/1956");
        System.out.println();
        String date = sc.next();
        sc.nextLine();
        return date;
    }

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

    private boolean isNumber(String cad){
        boolean flag = true;
            for (int i = 0; i < cad.length(); i++) {
                char car = cad.charAt(i);
                if(!(car >= 48 && car <= 57)){
                    flag = false;
                    break;
                }
            }     
    return flag;
    }

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

    private String askID(char car){
    String cad;
        switch (car) {
            case 'V':
                if(showVisitantListID()){
                    System.out.print("\nInsert the ID of the visitant: ");
                    cad = sc.next();
                    sc.nextLine();
                    return cad;
                }
                else{
                    return "EMPTY";
                }

            case 'E':
                if(showEmployeeListID()){
                    System.out.print("\nInsert the ID of the employee: ");
                    cad = sc.next();
                    sc.nextLine();
                    return cad;
                }
                else{
                    return "EMPTY";
                }         
            
            case 'A':
                if(showAnimalListID()){
                    System.out.print("\nInsert the ID of the animal: ");
                    cad = sc.next();
                    sc.nextLine();
                    return cad;
                }
                else{
                    return "EMPTY";
                } 

            case 'M':
                if(showMaintenanceListID()){
                    System.out.print("\nInsert the ID of the maintenance: ");
                    cad = sc.next();
                    sc.nextLine();
                    return cad;
                }
                else{
                    return "EMPTY";
                } 

            case 'Z':
                if(showZooVisitListID()){
                    System.out.print("\nInsert the ID of the zoo visit: ");
                    cad = sc.next();
                    sc.nextLine();
                    return cad;
                }
                else{
                    return "EMPTY";
                }

            default:
                return "INVALID";
        }    
    }

    private boolean validID(char car, String cad){
    boolean flag = false;
        switch (car) {
            case 'V':
                for (Visitant visitant : visitantList) {
                    if(cad.equals(visitant.getID())){
                        flag = true;
                        break;
                    }
                }
            break;

            case 'E':
                for (Employee employee : employeeList) {
                    if(cad.equals(employee.getID())){
                        flag = true;
                        break;
                    }
                }
         
            break;

            case 'A':
                for (Animal animal : animalList) {
                    if(cad.equals(animal.getID())){
                        flag = true;
                        break;
                    }
                }
            break;

            case 'Z':
                for (ZooVisit zooVisit : zooVisitList) {
                    if(cad.equals(zooVisit.getID())){
                        flag = true;
                        break;
                    }
                }
            break;

            case 'M':
                for (Maintenance maintenance : maintenanceList) {
                    if(cad.equals(maintenance.getID())){
                        flag = true;
                        break;
                    }
                }
            break;

            default:
            break;
        }
    return flag;
    }

    private String askRole(){
        System.out.println("Select an option");
        System.out.println("1. Veterinary");
        System.out.println("2. Guide");
        System.out.println("3. Maintenance");
        System.out.println("4. Administration");
        int x = sc.nextInt();

            switch (x) {
                case 1:
                    return "Veterinary";

                case 2:
                    return "Guide";

                case 3:
                    return "Maintenance";

                case 4:
                    return "Administration";
            
                default:
                    return "NOVALID";
            }
    }
     
    private String askName(String cad){
        System.out.print("\nINSERT THE " + cad + ": ");
            String answer = sc.next();
            sc.nextLine();
            return answer;
    }

    private boolean validName(String name){
    boolean flag = true;
        name = name.toUpperCase();
        for (int i = 0; i < name.length(); i++) {
            char car = name.charAt(i);
            if(car < 65 || car > 90){
                flag = false;
                break;
            }
        }
    return flag;
    }

    private boolean haveGuides(){
    boolean flag = false;
        for (Employee employee : employeeList) {
            if(employee.getRole().equals("Guide")){
                flag =  true;
                break;
            }
        }
    return flag;
    }

    private boolean haveMaintenanceEmployees(){
        boolean flag = false;
            for (Employee employee : employeeList) {
                if(employee.getRole().equals("Maintenance")){
                    flag =  true;
                    break;
                }
            }
    return flag;    
    }
    private String generateID(String cad){
        String lettersBank = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbersBank = "0123456789";
            cad += lettersBank.charAt(ran.nextInt(lettersBank.length()));
            int i = 0;
                while(i < 4){
                    cad += numbersBank.charAt(ran.nextInt(numbersBank.length()));
                    i++;
                }
    return cad; 
    }

    private boolean validGeneratedID(String ID, char car){
        boolean flag = true;
        switch (car) {
            case 'E':
                for (Employee employee : employeeList) {
                    if (ID.equals(employee.getID())) {
                        flag = false;
                        break;
                    }
                }
            break;

            case 'V':
                for (Visitant visitant : visitantList) {
                    if (ID.equals(visitant.getID())) {
                        flag = false;
                        break;
                    }
                }
                
            break;

            case 'A':
                for (Animal animal : animalList) {
                    if (ID.equals(animal.getID())) {
                        flag = false;
                        break;
                    }
                }
                
            break;

            case 'M':
                for (Maintenance maintenance : maintenanceList) {
                    if (ID.equals(maintenance.getID())) {
                        flag = false;
                        break;
                    }
                }
                
            break;
        
            default:
                for (ZooVisit zooVisit : zooVisitList) {
                    if (ID.equals(zooVisit.getID())) {
                        flag = false;
                        break;
                    }
                }
            break;
        }
    return flag;
    }

    private String correctID(String ID){
        String numbersBank = "0123456789";
        ID += numbersBank.charAt(ran.nextInt(numbersBank.length()));
        return ID;
    }

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
}
//ARRIBA LAS CHIVAS