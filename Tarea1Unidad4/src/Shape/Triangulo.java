package Shape;

import Shape.utils.tipoFigura;

import java.util.Scanner;

public class Triangulo extends Shape{
    private double base, altura;

    public Triangulo() {
        super(tipoFigura.TRIANGULO);
        this.base = base;
        this.altura = altura;
    }
    public void triangulo(){
        System.out.println("Selecciono la figura triángulo");
        calcularArea();
        calcularPerimetro();
        mostrarDatos();
    }
    @Override
    public void calcularArea() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Á R E A --- T R I Á N G U L O *****");
        System.out.println("Base: ");
        base = sc.nextDouble();
        System.out.println("Altura: ");
        altura = sc.nextDouble();
        setArea((base*altura)/2);
    }
    public void calcularPerimetro() {
        System.out.println("***** P E R I M E T R O --- T R I Á N G U L O *****");
        Scanner sc = new Scanner(System.in);
        double perimetro=0;
        for(int i=1; i<=3; i++){
            System.out.println("Lado "+i+":");
            double lado = sc.nextDouble();
           perimetro = perimetro+lado;
        }
        setPerimetro(perimetro);
    }
}
