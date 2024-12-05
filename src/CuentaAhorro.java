import java.util.ArrayList;
import java.util.List;

public class CuentaAhorro extends Cuenta{
    private List<String> movimientosCuentaAhorro;

    CuentaAhorro(int numeroCuenta, double saldo, Cliente propietario) {
        super(numeroCuenta, saldo, propietario);
        movimientosCuentaAhorro = new ArrayList<String>();
    }

    public void generarTarjeta(int nip, Cliente propietario) {
        TarjetaDigital tarjeta = new TarjetaDigital(nip, propietario);
        System.out.println("Tarjeta creada con éxito");
    }

    public void retiroSinTarjeta(double monto){
        this.saldo -= monto;
        registroMovimiento("Retiro sin tarjeta: $" + monto);
        System.out.println("Retiro realizado con éxito.");
    }

    public void transferencia(double monto, String nombreDestinatario){
        this.saldo += monto;
        registroMovimiento("Transferencia a " + nombreDestinatario + ": $" + monto);
        System.out.println("Transferencia realizada con éxito");
    }

    @Override
    public void registroMovimiento(String movimiento) {
        movimientosCuentaAhorro.add(movimiento);
    }

    @Override
    public void historialMovimiento() {
        for(int i = 0; i < movimientosCuentaAhorro.size(); i++){
            System.out.println("Movimiento N. " + i + ":" + movimientosCuentaAhorro.get(i));
        }
    }
}
