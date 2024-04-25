package Shape;

import Shape.utils.tipoFigura;

import java.util.Scanner;

public class Trapecio extends Shape{
    private double BASE, base, altura;

    public Trapecio() {
        super(tipoFigura.TRAPECIO);
        this.base = base;
        this.altura = altura;
        this.BASE = BASE;
    }

    public double getBASE() {
        return BASE;
    }

    public void setBASE(double BASE) {
        this.BASE = BASE;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public void trapecio(){
        System.out.println("Selecciono la figura trapecio");
        calcularArea();
        calcularPerimetro();
        mostrarDatos();
    }
    @Override
    public void calcularArea() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Á R E A --- T R A P E C I O *****");
        System.out.println("Base mayor: ");
        BASE = sc.nextDouble();
        setBASE(BASE);
        System.out.println("Base menor: ");
        base = sc.nextDouble();
        setBase(base);
        System.out.println("Altura: ");
        altura = sc.nextDouble();
        setArea(altura*(base+BASE)/2);
    }
    public void calcularPerimetro() {
        System.out.println("***** P E R I M E T R O --- T R A P E C I O *****");
        Scanner sc = new Scanner(System.in);
        double Lado1 = getBASE(), Lado2 = getBase();
        double perimetro=Lado2+Lado1;
        System.out.println("Lado 1: "+Lado1+"\nLado 2: "+Lado2);
        for(int i=3; i<=4; i++){
            System.out.printf("Lado "+i+": ");
            double lado = sc.nextDouble();
            perimetro = perimetro+lado;
        }
        setPerimetro(perimetro);
    }
}
