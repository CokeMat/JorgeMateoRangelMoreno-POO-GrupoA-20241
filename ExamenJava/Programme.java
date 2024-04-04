import java.util.Scanner;

public class Programme {
    private final String PASSWORD = "pass1234*";
    private Scanner sc = new Scanner(System.in);
    private Zoo zoo = new Zoo();


    private boolean validPassword = false;
    public void runProgramme(){   
        //zoo.prueba();//MÉTODO PARA HACER PRUEBAS
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
        }
    }

    public void showOptions(){
    boolean flag = true;
        while (flag) {
            System.out.println("\n************** WELCOME TO THE ZOO SYSTEM **************");
            System.out.println("Please select an option(Write the number)");
            System.out.println("1. Register");
            System.out.println("2. Delete");
            System.out.println("3. Modify information");
            System.out.println("4. Consult information");
            System.out.println("5. Exit of the system");

            int x = sc.nextInt();
            switch (x) {
                case 1:
                System.out.println("What do you want to register? ");
                    System.out.println("Select an option");
                    System.out.println("1. Register an employee");
                    System.out.println("2. Register a visitant");
                    System.out.println("3. Register an animal");
                    System.out.println("4. Register a zoo visit");
                    System.out.println("5. Register the maintenance done to an animal");
                    System.out.println("6. Get back to the last menu");

                        switch (sc.nextInt()) {
                            case 1:
                                zoo.addEmployee();
                            break;

                            case 2:
                                zoo.addVisitant();
                            break;

                            case 3:
                                zoo.addAnimal();
                            break;

                            case 4:
                                zoo.addZooVisit();
                            break;

                            case 5:
                                zoo.addMaintenance();
                            break;
                        
                            default:
                            break;
                        }
                break;

                case 2:
                    System.out.println("1. Delete an employee");
                    System.out.println("2. Delete a visitant");
                    System.out.println("3. Delete an animal");
                    System.out.println("4. Get back to the last menu");

                        switch (sc.nextInt()) {
                            case 1:
                                zoo.removeEmployee();
                            break;

                            case 2:
                                zoo.removeVisitant();
                            break;

                            case 3:
                                zoo.removeAnimal();
                            break;
                        
                            default:
                            break;
                        }
                break;

                case 3:
                    System.out.println("1. Modify employee information");
                    System.out.println("2. Modify visitant information");
                    System.out.println("3. Modify animal information");
                    System.out.println("4. Get back to the last menu");

                        switch (sc.nextInt()) {
                            case 1:
                                zoo.modifyEmployee();
                            break;

                            case 2:
                                zoo.modifyVisitant();
                            break;

                            case 3:
                                zoo.modifyAnimal();
                            break;
                        
                            default:
                            break;
                        }
                break;

                case 4: 
                    System.out.println("1. Employees information");
                    System.out.println("2. Visitants information");
                    System.out.println("3. Animals information");
                    System.out.println("4. Zoo Visits information");
                    System.out.println("5. Maintenances information");
                    System.out.println("6. Get back to the last menu");


                        switch (sc.nextInt()) {
                            case 1:
                                System.out.println("Do you need information of a specific employee?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                int option1 = sc.nextInt();
                                    if(option1 == 1){
                                        zoo.showEmployeeInfo();
                                    }
                                    else if(option1 == 2){
                                        zoo.showEmployeeList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;

                            case 2:
                                System.out.println("Do you need information of a specific visitant?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                    int option2 = sc.nextInt();
                                    if(option2 == 1){
                                        zoo.showVisitantInfo();
                                    }
                                    else if(option2 == 2){
                                        zoo.showVisitantList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;

                            case 3:
                                System.out.println("Do you need information of a specific animal?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                    int option3 = sc.nextInt();
                                    if(option3 == 1){
                                        zoo.showAnimalInfo();
                                    }
                                    else if(option3 == 2){
                                        zoo.showAnimalList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;

                            case 4:
                                System.out.println("Do you need information of a specific zoo visit?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                    int option4 = sc.nextInt();
                                    if(option4 == 1){
                                        zoo.showZooVisitInfo();
                                    }
                                    else if(option4 == 2){
                                        zoo.showZooVisitList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;

                            case 5:
                                System.out.println("Do you need information of a specific maintenance?");
                                System.out.println("1. Yes");
                                System.out.println("2. No");
                                int option5 = sc.nextInt();
                                    if(option5 == 1){
                                        zoo.showMaintenanceInfo();
                                    }
                                    else if(option5 == 2){
                                        zoo.showMaintenanceList();
                                    }
                                    else{
                                        System.out.println("Invalid option");
                                    }
                            break;
                        
                            default:
                            break;
                        }
                break;

                default:
                    flag = false;
                break;
            }
        }
    }
}