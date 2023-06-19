import java.util.Scanner;

public class aseguradora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de vendedores a evaluar: ");
        int numVendedores = scanner.nextInt();

        VendedorSeguros[] vendedores = new VendedorSeguros[numVendedores];//arreglo de obj, num de vendedores

        for (int i = 0; i < numVendedores; i++) {//bucle para pedir datos
            System.out.println("\nVendedor #" + (i + 1));
            System.out.print("Ingrese el nombre del vendedor: ");
            scanner.nextLine();
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el número de identificación del vendedor: ");
            int identificacion = scanner.nextInt();
            System.out.print("Ingrese el número de oficina del vendedor: ");
            int oficina = scanner.nextInt();

            vendedores[i] = new VendedorSeguros(identificacion, nombre, oficina);//obj con la info para el arreglo vendedores

            System.out.println("Ingrese las calificaciones (del 1 al 5) para el vendedor " + nombre + ":");
            for (int j = 0; j < 3; j++) {// para pedir notas
                System.out.print("Calificación #" + (j + 1) + ": ");
                int calificacion = scanner.nextInt();
                vendedores[i].agregarCalificacion(calificacion);//metodo agregarCalificacion
            }
        }

        System.out.println("\nPromedio de calificaciones individuales:");
        for (VendedorSeguros vendedor : vendedores) {//metodo calcularPromedio
            System.out.println("Nombre: " + vendedor.getNombre() +
                    " | Identificación: " + vendedor.getIdentificacion() +
                    " | Oficina: " + vendedor.getOficina() +
                    " | Promedio: " + vendedor.calcularPromedio());
        }

        System.out.println("\nPromedio general del grupo: " + calcularPromedioGeneral(vendedores));
    }

    public static double calcularPromedioGeneral(VendedorSeguros[] vendedores) {
        double sumatoriaCalificaciones = 0;
        int totalCalificaciones = 0;

        for (VendedorSeguros vendedor : vendedores) {
            sumatoriaCalificaciones += vendedor.sumarCalificaciones();
            totalCalificaciones += vendedor.getNumCalificaciones();
        }

        if (totalCalificaciones > 0) {
            return sumatoriaCalificaciones / totalCalificaciones;
        } else {
            return 0;
        }
    }
}

class VendedorSeguros {
    private int identificacion;
    private String nombre;
    private int oficina;
    private int[] calificaciones;
    private int numCalificaciones;
//metodos
    public VendedorSeguros(int identificacion, String nombre, int oficina) {//inicia los atributos(id,nombre,oficina)arreglos numcal
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.oficina = oficina;
        this.calificaciones = new int[3];
        this.numCalificaciones = 0;
    }

    public void agregarCalificacion(int calificacion) {//agregar una calificación al vendedor, que no sea mas de 3
        if (numCalificaciones < 3) {
            calificaciones[numCalificaciones] = calificacion;
            numCalificaciones++;
        }
    }

    public double calcularPromedio() {//Suma las calificaciones del arreglo calificaciones y divide enre el num de calificaciones
        int sumatoriaCalificaciones = 0;

        for (int calificacion : calificaciones) {//recorrer el arreglo de calificaciones y las suma 
            sumatoriaCalificaciones += calificacion;
        }

        if (numCalificaciones > 0) {//verifica si el vendedor tiene al menos una calificación y divide
            return (double) sumatoriaCalificaciones / numCalificaciones;
        } else {
            return 0;
        }
    }

    public int getIdentificacion() {//obtener los valores de los atributos de la clase
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getOficina() {
        return oficina;
    }

    public int sumarCalificaciones() {
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma += calificacion;
        }
        return suma;
    }

    public int getNumCalificaciones() {
        return numCalificaciones;
    }
}
