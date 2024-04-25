package Shape;
import java.util.Scanner;
import Shape.utils.tipoFigura;

public class Romboide extends Shape{
    private double base, altura;

    public Romboide() {
        super(tipoFigura.ROMBOIDE);
        this.base = base;
        this.altura = altura;
    }
    public void romboide(){
        System.out.println("Selecciono la figura romboide");
        calcularArea();
        calcularPerimetro();
        mostrarDatos();
    }
    @Override
    public void calcularArea() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Á R E A --- R O M B O I D E *****");
        System.out.println("Base: ");
        base = sc.nextDouble();
        System.out.println("Altura: ");
        altura = sc.nextDouble();
        setArea((base*altura));
    }
    public void calcularPerimetro() {
        System.out.println("***** P E R I M E T R O --- R O M B O I D E *****");
        Scanner sc = new Scanner(System.in);
        double perimetro=0;
        for(int i=1; i<=2; i++){
            System.out.println("Lado "+i+":");
            double lado = sc.nextDouble();
           perimetro = perimetro+lado;
        }
        setPerimetro(2*perimetro);
    }
}
