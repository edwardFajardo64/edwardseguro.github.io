public class Vendedor
{
    String identificacion;
    String nombre;
    String oficina;
    double caliuno;
    double calidos;
    double calitres;
    
    Vendedor(String identificacion, String nombre, String oficina, double caliuno, double calidos, double calitres){
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.oficina = oficina;
        this.caliuno = caliuno;
        this.calidos = calidos;
        this.calitres = calitres;
    }
    
    double calcularPromedio(){
        return (caliuno + calidos + calitres) / 3;
    }
}