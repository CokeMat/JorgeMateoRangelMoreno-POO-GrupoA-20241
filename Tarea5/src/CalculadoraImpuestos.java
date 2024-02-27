public class CalculadoraImpuestos {
    int ingresos;
    double porcentajeImpuestos;
    double dividendos;
    double exencion;

    public CalculadoraImpuestos(int ingresos, double porcentajeImpuestos, double dividendos, double exencion){
        this.ingresos=ingresos;
        this.porcentajeImpuestos=porcentajeImpuestos;
        this.dividendos=dividendos;
        this.exencion=exencion;
    }

    void calculadoraImpuestos(){
        System.out.printf("Ingresos: %.2f\n ", ingresos+0.15);
    }
    void calculadoraImpuestos(int ventas, double porcentajeImpuestos){
        System.out.printf("Ventas y porcentaje de ventas: %.2f\n ", ventas*(porcentajeImpuestos/100));
    }
    void calculadoraImpuestos(double dividendos, double execion, double porcentajeImpuestos){
        System.out.printf("Impuestos: %.2f\n ", dividendos*(porcentajeImpuestos/100));
        if(dividendos*(porcentajeImpuestos)>execion){
            System.out.printf("Impuestos menos la execión: %.2f", dividendos*(porcentajeImpuestos/100)-execion);
        }
        else{
            System.out.println(0);
        }
    }
}