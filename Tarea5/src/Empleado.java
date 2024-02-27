public class Empleado {
    String nombre;
    double salario;
    double bonificacion;
    int horasExtras;

    public Empleado(String nombre, double salario, double bonificacion, int horasExtras){
        this.nombre=nombre;
        this.salario=salario;
        this.bonificacion=bonificacion;
        this.horasExtras=horasExtras;
    }
    void calcularSalario(){
        System.out.printf("Nombre del Empleado: %s\n Salario inicial: $%.2f\n Sin bonificaciones y sin horas extras\n Salario Final: $%.2f\n", nombre, salario, salario);
        }
        double salarioFinal;
    void calcularSalario(double bonificacion){
        salarioFinal=salario+bonificacion;
        System.out.printf("Nombre del Empleado: %s\n Salario inicial: $%f\n Bonificacion: $%.2f\n Sin horas extras\n Salario Final: $%.2f\n", nombre, salario, bonificacion, salarioFinal);
    }
    void calcularSalario(double bonificacion, int horasExtras){
       salarioFinal=salario+bonificacion+20*horasExtras;
        System.out.printf("Nombre del Empleado: %s\n Salario inicial: $%.2f\n Bonificacion: $%.2f\n Total de horas extras: %d\n Salario Final: $%.2f\n", nombre, salario, bonificacion, horasExtras, salarioFinal);
    }

}