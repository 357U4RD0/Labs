import java.io.FileWriter;
import java.io.IOException;

public class Confirmacion {
    private String Tarjeta;
    private int cuotas;
    private String claseVuelo;
    private String Asiento;
    private int Maletas;

    public Confirmacion(String numeroTarjeta, int cuotas, String claseVuelo, String numeroAsiento, int cantidadMaletas) {
        this.Tarjeta = numeroTarjeta;
        this.cuotas = cuotas;
        this.claseVuelo = claseVuelo;
        this.Asiento = numeroAsiento;
        this.Maletas = cantidadMaletas;
    }

    public void guardar() {
        try {
            FileWriter writer = new FileWriter("confirmaciones.csv", true);
            writer.append(Tarjeta);
            writer.append(",");
            writer.append(Integer.toString(cuotas));
            writer.append(",");
            writer.append(claseVuelo);
            writer.append(",");
            writer.append(Asiento);
            writer.append(",");
            writer.append(Integer.toString(Maletas));
            writer.append("\n");
            writer.close();
            System.out.println("¡Confirmación guardada en el archivo CSV!");
        } catch (IOException e) {
            System.out.println("No se pudo guardar la confirmación en el archivo CSV.");
        }
    }
}
