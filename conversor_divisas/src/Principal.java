import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Menu menu  = new Menu();
        Scanner scanner = new Scanner(System.in);

        String base_code, target_code;
        double monto;

        ConsultaAPI busqueda =  new ConsultaAPI();
        int opcion=0;
        while (opcion != 7) {
            menu.opciones();


            try {
                opcion = scanner.nextInt();
                if (opcion == 7) {
                    System.out.println("Finalizando la ejecución, gracias por su preferencia:)");
                    continue;
                } else if (opcion < 1 || opcion > 7) {
                    System.out.println("Opción no válida\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Elija una opción válida\n");
                continue;
            }
            System.out.println("Ingrese el valor que desea convertir:");
            try {
                monto = scanner.nextDouble();
                if (monto < 0) {
                    System.out.println("Ingrese un valor númerico válido\n");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un valor númerico válido\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    base_code = "USD";
                    target_code = "MXN";
                    busqueda.resultado(base_code, target_code, monto);
                    break;
                case 2:
                    base_code = "MXN";
                    target_code = "USD";
                    busqueda.resultado(base_code, target_code, monto);
                    break;
                case 3:
                    base_code = "USD";
                    target_code = "BRL";
                    busqueda.resultado(base_code, target_code, monto);
                    break;
                case 4:
                    base_code = "USD";
                    target_code = "COP";
                    busqueda.resultado(base_code, target_code, monto);
                    break;
                case 5:
                    base_code = "USD";
                    target_code = "BOB";
                    busqueda.resultado(base_code, target_code, monto);
                    break;
                case 6:
                    base_code = "BOB";
                    target_code = "USD";
                    busqueda.resultado(base_code, target_code, monto);
                    break;
            }
        }
    }

}
