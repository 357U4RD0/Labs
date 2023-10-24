import java.util.Random;

public class Producto {
    
    //Variables que usaré
    int ID;
    String Nombre;
    int Disponible;
    int Vendidos;
    boolean Estado;
    float Precio;
    Random random = new Random();

    //Objeto Producto
    public Producto(String Nombre, int Disponible, int Vendidos, float Precio) {
        this.Nombre = Nombre;
        this.Disponible = Disponible;
        this.Vendidos = Vendidos; 
        this.Precio = Precio;
        this.Estado = true;
        //Este es para crear una ID que sea de 6 dígitos
        this.ID = (random.nextInt(999999 - 100000 + 1) + 100000);
    }

    public String getNombre(){
        return this.Nombre;
    }

    public float getPrecio(){
        return this.Precio;
    }

    //Considero que esta función me ayudará a conseguir el total de productos
    public int total(){
        int total = (this.Vendidos + this.Disponible);
        return total;
    }
}
