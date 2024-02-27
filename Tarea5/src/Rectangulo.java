public class Rectangulo {
    double ancho;
    double alto;

    public Rectangulo (double ancho, double alto){
        this.ancho=ancho;
        this.alto=alto;
    }

    void area(){
        System.out.printf("El área del rectángulo de %.3f de alto y de %.3f de ancho es igual a %.2f\n", alto, ancho, alto*ancho);
    }
    void perimetro(){
        System.out.printf("El perimetro del rectángulo de %.3f de alto y de %.3f de ancho es igual a %.2f\n", alto, ancho, 2*alto+2*ancho);
    }

    void area(int ancho, int alto){
        System.out.printf("El área del rectángulo de %d de alto y de %d de ancho es igual a %d\n", alto, ancho, alto*ancho);
    }
    void perimetro(int ancho, int alto){
        System.out.printf("El perimetro del rectángulo de %d de alto y de %d de ancho es igual a %d\n", alto, ancho, 2*alto+2*ancho);
    }
}