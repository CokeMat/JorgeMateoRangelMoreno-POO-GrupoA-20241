package Shape;

import Shape.utils.tipoFigura;

import java.util.Scanner;

public class Circulo extends Shape{
    private final double pi = 3.141593;
    private double radio;
    Scanner sc = new Scanner(System.in);

    public Circulo() {
        super(tipoFigura.CIRCULO);
    }
    public void circulo(){
        System.out.println("Selecciono la figura círculo");
        calcularArea();
        calcularPerimetro();
        mostrarDatos();
    }
    @Override
    public void calcularArea() {
        System.out.println("***** Á R E A --- C Í R C U L O *****");
        System.out.println("Radio:");
        radio = sc.nextDouble();
        setArea(pi*(radio*radio));
    }
    public void calcularPerimetro() {
        setPerimetro(2 * (pi * radio));
    }

}
