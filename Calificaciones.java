import java.util.Scanner;
public class Calificaciones
{
    public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            int numeroVendedores;
            Vendedor[] losVendedores = new Vendedor[50];
            String identificacion, nombre, oficina;
            double cali1, cali2, cali3;
            double promedio = 0;
            System.out.println("Digite la cantidad de vendedores: ");
            numeroVendedores = sc.nextInt();
            
            for(int i = 0; i < numeroVendedores; i++){
                System.out.println("Digite la identificacion del vendedor: ");
                identificacion = sc.next();
                System.out.println("Digite nombre del vendedor: ");
                nombre = sc.next();
                System.out.println("Digite la oficina del vendedor: ");
                oficina = sc.next();
                System.out.println("Digite la calificacion 1 del vendedor: ");
                cali1 = sc.nextDouble();
                System.out.println("Digite la calificacion 2 del vendedor: ");
                cali2 = sc.nextDouble();
                System.out.println("Digite la calificacion 3 del vendedor: ");
                cali3 = sc.nextDouble();
                Vendedor unVendedor = new Vendedor();
                unVendedor.identificacion = identificacion;
                unVendedor.nombre = nombre;
                unVendedor.oficina = oficina;
                unVendedor.caliuno = cali1;
                unVendedor.calidos = cali2;
                unVendedor.calitres = cali3;
                losVendedores[i] = unVendedor;
            }
            for(int i = 0; i < numeroVendedores; i++){
                double sum =(losVendedores[i].caliuno +losVendedores[i].calidos +losVendedores[i].calitres)/3;
                promedio = promedio + sum / numeroVendedores;
            }
            System.out.println("El promedio de calificaciones es: "+ promedio);
    }
}