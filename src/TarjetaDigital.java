import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TarjetaDigital implements EstadoTarjeta {
    private String numeroTarjeta;
    private String fechaVencimiento;
    private String cvv;
    private int nip;
    private boolean estado;
    private Cliente propietario;
    public List<TarjetaDigital> tarjetas;

    TarjetaDigital(int nip, Cliente propietario) {
        this.numeroTarjeta = generarNumeroTarjeta();
        this.fechaVencimiento = generarFechaVencimiento();
        this.cvv = generarCvv();
        this.nip = nip;
        this.propietario = propietario;
        this.estado = true;
        tarjetas = new ArrayList<>();
    }

    public String generarNumeroTarjeta() {
        SecureRandom random = new SecureRandom();
        StringBuilder numero = new StringBuilder(16);
        for (int i = 0; i < 16; i++) {
            numero.append(random.nextInt(10)); // Genera un dígito entre 0 y 9
        }
        return numero.toString();
    }

    public String generarFechaVencimiento() {

        int añoVencimiento = ThreadLocalRandom.current().nextInt(5,  10);
        int mesVencimiento = ThreadLocalRandom.current().nextInt(1, 13);
        LocalDate fechaVencimiento = LocalDate.of(añoVencimiento, mesVencimiento, 1);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("MM/yy");
        return fechaVencimiento.format(formato);
    }

    public String generarCvv() {
        SecureRandom random = new SecureRandom();
        StringBuilder numero = new StringBuilder(3);
        for (int i = 0; i < 3; i++) {
            numero.append(random.nextInt(10)); // Genera un dígito entre 0 y 9
        }
        return numero.toString();
    }

    @Override
    public void bloquear() {
        this.estado = false;
        System.out.println("Tarjeta " + numeroTarjeta + " bloqueada.");
    }

    @Override
    public void activar() {
        this.estado = true;
        System.out.println("Tarjeta " + numeroTarjeta + " activada.");
    }
}
