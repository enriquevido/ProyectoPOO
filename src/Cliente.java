import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String direccion;
    private String telefono;
    public List<Cuenta> cuentas;
    public List<TarjetaDigital> tarjetas;

    Cliente(String name, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuentas = new ArrayList<>();
        this.tarjetas = new ArrayList<>();
    }

    public void aperturarCuenta(int tipoCuenta, double saldoInicial, Cliente propietario) {
        Cuenta nuevaCuenta = null;
        if(tipoCuenta == 1){
            nuevaCuenta = new CuentaAhorro(cuentas.size(), saldoInicial, propietario);
            System.out.println("Cuenta tipo ahorro aperturada con éxito!");
        } else if(tipoCuenta == 2) {
            nuevaCuenta = new CuentaRendimiento(cuentas.size(), saldoInicial, propietario);
            System.out.println("Cuenta tipo rendimiento aperturada con éxito!");
        }
        cuentas.add(nuevaCuenta);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public List<TarjetaDigital> getTarjetas() {
        return tarjetas;
    }

}
