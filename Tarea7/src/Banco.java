import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

class Banco {
    ArrayList<Employee> employeeList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    Random num = new Random();

    public void ingresarDatos() {
        System.out.println("-Nombre:");
        String name = sc.next();
        System.out.println("-Apellido:");
        String lastName = sc.next();
        Employee employee = new Employee(name, lastName);
        employeeList.add(employee);
        System.out.println("Se han registrado con éxito los datos");
        System.out.println("****************");
    }

    public void mostrarEmpleados() {
        if (employeeList.isEmpty()) {
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("Agregue un usuario con la opción '3'");
        } else {
            int i = 0;
            for (Employee employee : employeeList) {
                System.out.printf("Empleado %d:");
                System.out.printf("%s\n", i += 1, employee.getFullName());
            }
        }
    }

    public void mostrarInfoEmpleado() {
        if (employeeList.isEmpty()) {
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("Agregue un usuario con la opción '3'");
        } else {
            System.out.println("¿De cuál empleado te gustaría saber su información?:");
            int i = sc.nextInt();
            if (i > employeeList.size()) {
                System.out.println("No se ha encontrado ningún empleado con ese número");
            } else {
                Employee employee = employeeList.get(i - 1);
                System.out.printf("Empleado: ");
                System.out.printf("%s\n", employee.getFullName());
                for (BankAccount account : employee.getAccountList()) {
                    System.out.println(account.getDatos());
                }
            }
        }
    }

    public void depositarDinero() {
        if (employeeList.isEmpty()) {
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("No hay cuenta a la que depositar");
        } else {
            System.out.println("¿A qué empleado te gustaría depositar?:");
            int i = sc.nextInt();
            if (i > employeeList.size()) {
                System.out.println("No se ha encontrado el empleado");
            } else {
                Employee employee = employeeList.get(i - 1);
                System.out.println("¿A qué cuenta te gustaría depositar?:");
                int j = sc.nextInt();
                if (j > employee.getAccountList().size()) {
                    System.out.println("No se ha encontrado la cuenta");
                } else {
                    BankAccount account = employee.getAccountList().get(j - 1);
                    System.out.println("¿Cuánto desea depositar?");
                    double amount = sc.nextDouble();
                    account.agregarDinero(amount);
                    System.out.println("Se realizó el depósito con éxito.");
                }
            }
        }
    }

    public void agregarCuentaEmpleado() {
        if (employeeList.isEmpty()) {
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("No hay empleado al que agregar una cuenta");
        } else {
            System.out.println("¿A qué empleado te gustaría agregar una cuenta?:");
            int i = sc.nextInt();
            if (i > employeeList.size()) {
                System.out.println("No se ha encontrado al empleado");
            } else {
                long accountNumber = num.nextInt(100000, 999999);
                System.out.println("Tipo de cuenta que desea agregar(A, B o C): ");
                char type = sc.next().charAt(0);
                BankAccount account = new BankAccount(accountNumber, type);
                Employee employee = employeeList.get(i - 1);
                employee.addAccount(account);
                System.out.println("Se ha registrado con éxito la cuenta");
                System.out.println("****************");
            }
        }
    }

    public void retirarDinero() {
        if (employeeList.isEmpty()) {
            System.out.println("*****  V  A  C  I  O  ******");
            System.out.println("No hay cuenta de la que retirar dinero");
        } else {
            System.out.println("¿De qué empleado te gustaría retirar dinero?:");
            int i = sc.nextInt();
            if (i > employeeList.size()) {
                System.out.println("No se ha encontrado el empleado");
            } else {
                Employee employee = employeeList.get(i - 1);
                System.out.println("¿De qué cuenta te gustaría retirar dinero?:");
                int j = sc.nextInt();
                if (j > employee.getAccountList().size()) {
                    System.out.println("No se ha encontrado la cuenta");
                } else {
                    BankAccount account = employee.getAccountList().get(j - 1);
                    System.out.println("¿Cuánto desea retirar?");
                    double amount = sc.nextDouble();
                    account.retirarDinero(amount);
                    System.out.println("Se realizó el retiro con éxito.");
                }
            }
        }
    }
}