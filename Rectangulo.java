public class Rectangulo {
    double ancho;
    double altura;
    double area;
    double perimetro;

    public Rectangulo (double ancho, double altura){
        this.altura=altura;
        this.ancho=ancho;
    }
    public void calculos() {
        System.out.printf("Medidas rectangulo:\n Ancho: %f\n Altura: %f\n Área: %f\n Perimetro: %f\n", ancho, altura, ancho*altura, 2*(ancho+altura));
        if(ancho==altura){
            System.out.println("Es un cuadrado.");
        }
        System.out.println("*********");
    }
}