package Shape;
import Shape.utils.tipoFigura;

public abstract class Shape {
    private double perimetro;
    private double area;
    private tipoFigura tipoFigura;

    public Shape(tipoFigura tipoFigura) {
        this.tipoFigura = tipoFigura;
    }

    //Getters y setters
    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public tipoFigura getTipoFigura() {
        return tipoFigura;
    }

    public void setTipoFigura(tipoFigura tipoFigura) {
        this.tipoFigura = tipoFigura;
    }
    //Métodos abstractos
    public abstract void calcularPerimetro();

    public abstract void calcularArea();

    //Método para mostrar datos
    public void mostrarDatos() {
        System.out.println("\"***** D A T O S -- DE - LA -- F I G U R A *****\"");
        System.out.printf("\nFigura: "+getTipoFigura()+"\nPerimetro: %.2fu \nÁrea: %.2fu^2\n\n", getPerimetro() ,getArea());
    }
}
