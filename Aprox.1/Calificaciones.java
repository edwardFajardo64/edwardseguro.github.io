import java.util.Scanner;
public class Calificaciones
{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numeroVendedores = 0, opcionMenu = 0;
        Vendedor[] losVendedores = new Vendedor[50];
        String identificacion, nombre, oficina;
        double caliuno, calidos, calitres;
        double promedio = 0;
        while(opcionMenu != 3){
            System.out.println("\nMenu de Opciones: ");
            System.out.println("1. Adicionar un vendedor: ");
            System.out.println("2. calcular Promedio de calificaciones: ");
            System.out.println("3. Salir ");
            System.out.println("Escoja una opcion.... ");
            opcionMenu = sc.nextInt();
            if(opcionMenu== 1){
                System.out.println("Digite la identificacion del vendedor: ");
                identificacion = sc.next();
                System.out.println("Digite el nombre del vendedor:  ");
                nombre = sc.next();
                System.out.println("Digite la oficina del vendedor: ");
                oficina = sc.next();
                System.out.println("Digite la calificacion uno del vendedor: ");
                caliuno = sc.nextDouble();
                System.out.println("Digite la calificacion dos del vendedor: ");
                calidos = sc.nextDouble();
                System.out.println("Digite la calificacion tres del vendedor: ");
                calitres = sc.nextDouble();
                Vendedor unVendedor = new Vendedor(identificacion, nombre, oficina,caliuno,calidos,calitres);
                losVendedores[numeroVendedores] = unVendedor;
                numeroVendedores++;
            }
            else if(opcionMenu==2){
                for(int i = 0; i < numeroVendedores; i++){
                    promedio = promedio + losVendedores[i].calcularPromedio() / numeroVendedores;       
                }
                System.out.println("\n El Promedio de calificaciones del vendedor es: "+ promedio);
            }
        }
    
    }

}