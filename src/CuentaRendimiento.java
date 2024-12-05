import java.util.ArrayList;
import java.util.List;

public class CuentaRendimiento extends Cuenta{
    static final double RENDIMIENTO = 1.125;
    private List<String> movimientosCuentaRendimiento;

    CuentaRendimiento(int numeroCuenta, double saldo, Cliente propietario) {
        super(numeroCuenta, saldo, propietario);
        movimientosCuentaRendimiento = new ArrayList<String>();
    }

    public void congelarSaldo(int monto){
        this.saldo =+ monto;
        System.out.println("Dinero congelado.");
        System.out.println("Su saldo al finalizar el periodo de 1 año será de: $" + this.saldo * RENDIMIENTO);
    }

    @Override
    public void registroMovimiento(String movimiento) {
        movimientosCuentaRendimiento.add(movimiento);
    }

    @Override
    public void historialMovimiento() {
        for(int i = 0; i < movimientosCuentaRendimiento.size(); i++){
            System.out.println("Movimiento N. " + i + ":" + movimientosCuentaRendimiento.get(i));
        }
    }
}
