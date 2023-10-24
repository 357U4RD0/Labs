public class Snack extends Producto {
    int Gramos;
    String Sabor;
    String Tamaño;

    public Snack(String Nombre, int Disponible, int Vendidos, float Precio, int Gramos, String Sabor, String Tamaño){
        super(Nombre, Disponible, Vendidos, Precio);
        this.Estado = true;
        this.ID = (random.nextInt(999999 - 100000 + 1) + 100000);
        this.Gramos = Gramos;
        this.Sabor = Sabor;
        this.Tamaño = Tamaño;
    }
}
