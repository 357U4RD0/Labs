public class Bebida extends Producto {
    int ml;
    String Tipo;

    //Objeto Bebida
    public Bebida(String Nombre, int Disponible, int Vendidos, float Precio, int ml, String Tipo){
        super(Nombre, Disponible, Vendidos, Precio);
        this.Estado = true;
        this.ID = (random.nextInt(999999 - 100000 + 1) + 100000);
        this.ml = ml;
        this.Tipo = Tipo;
    }
}
