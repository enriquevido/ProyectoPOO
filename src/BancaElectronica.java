import java.util.Scanner;

public class BancaElectronica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente("Enrique Vidó", "Remolcador 40", "9211471026");

        int opcion;
        do {
            System.out.println("\n=== Menú Banca Electrónica ===");
            System.out.println("1. Aperturar cuenta");
            System.out.println("2. Depositar a cuenta");
            System.out.println("3. Retirar de cuenta");
            System.out.println("4. Consultar saldo");
            System.out.println("5. Generar tarjeta");
            System.out.println("6. Bloquear tarjeta");
            System.out.println("7. Activar tarjeta");
            System.out.println("8. Consultar historial de movimientos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.println("\nSeleccione el tipo de cuenta:");
                    System.out.println("1. Cuenta de Ahorro");
                    System.out.println("2. Cuenta de Rendimiento");
                    System.out.print("Ingrese su elección: ");
                    int tipoCuenta = scanner.nextInt();
                    System.out.print("Ingrese el saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    cliente.aperturarCuenta(tipoCuenta, saldoInicial, cliente);
                    break;

                case 2:
                    System.out.print("Ingrese el número de cuenta: ");
                    int numeroCuentaDep = scanner.nextInt();
                    System.out.print("Ingrese el monto a depositar: ");
                    double montoDep = scanner.nextDouble();
                    cliente.getCuentas().get(numeroCuentaDep).depositar(montoDep);
                    break;

                case 3:
                    System.out.print("Ingrese el número de cuenta: ");
                    int numeroCuentaRet = scanner.nextInt();
                    System.out.print("Ingrese el monto a retirar: ");
                    double montoRet = scanner.nextDouble();
                    cliente.getCuentas().get(numeroCuentaRet).retirar(montoRet);
                    break;

                case 4:
                    System.out.print("Ingrese el número de cuenta: ");
                    int numeroCuentaSaldo = scanner.nextInt();
                    cliente.getCuentas().get(numeroCuentaSaldo).consultarSaldo();
                    break;

                case 5:
                    System.out.print("Ingrese el número de cuenta para vincular la tarjeta: ");
                    int numeroCuentaTarjeta = scanner.nextInt();
                    System.out.print("Ingrese un NIP para la tarjeta: ");
                    int nip = scanner.nextInt();
                    ((CuentaAhorro) cliente.getCuentas().get(numeroCuentaTarjeta)).generarTarjeta(nip, cliente);
                    break;

                case 6:
                    System.out.println("\nIngrese el índice de la tarjeta a bloquear: ");
                    int indiceTarjetaBloq = scanner.nextInt();
                    cliente.getTarjetas().get(indiceTarjetaBloq).bloquear();
                    break;

                case 7:
                    System.out.println("\nIngrese el índice de la tarjeta a activar: ");
                    int indiceTarjetaAct = scanner.nextInt();
                    cliente.getTarjetas().get(indiceTarjetaAct).activar();
                    break;

                case 8:
                    System.out.print("Ingrese el número de cuenta: ");
                    int numeroCuentaHistorial = scanner.nextInt();
                    cliente.getCuentas().get(numeroCuentaHistorial).historialMovimiento();
                    break;

                case 9:
                    System.out.println("Gracias por usar la banca electrónica. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}
