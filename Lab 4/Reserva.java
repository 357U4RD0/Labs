public class Reserva {
    private String fecha;
    private String tipoVuelo;
    private int cantidadBoletos;
    private String aerolinea;

    public Reserva(String fecha, String tipoVuelo, int cantidadBoletos, String aerolinea) {
        this.fecha = fecha;
        this.tipoVuelo = tipoVuelo;
        this.cantidadBoletos = cantidadBoletos;
        this.aerolinea = aerolinea;
    }
}