public class Reserva {
    private String fecha;
    private boolean idaVuelta;
    private int cantidadBoletos;
    private String aerolinea;

    public Reserva(String fecha, boolean idaVuelta, int cantidadBoletos, String aerolinea) {
        this.fecha = fecha;
        this.idaVuelta = idaVuelta;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
    }
}