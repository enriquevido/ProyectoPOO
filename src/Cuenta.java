import java.util.ArrayList;
import java.util.List;

public abstract class Cuenta {
    private int numeroCuenta;
    public double saldo;
    private Cliente propietario;
    public static List<Cuenta> cuentas;

    Cuenta(int numeroCuenta, double saldo, Cliente propietario) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.propietario = propietario;
        cuentas.add(this);
    }

    public void depositar(double monto) {
        saldo += monto;
        registroMovimiento("Deposito: $" + monto);
    }

    public void retirar(double monto) {
        if(saldo >= monto) {
            saldo -= monto;
            registroMovimiento("Retiro: $" + monto);
            System.out.println("Retiro realizado con éxito!");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    public abstract void registroMovimiento(String movimiento);
    public abstract void historialMovimiento();

    public void consultarSaldo(){
        System.out.println("Saldo actual: $" + saldo);
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getPropietario() {
        return propietario.getNombre();
    }
}
