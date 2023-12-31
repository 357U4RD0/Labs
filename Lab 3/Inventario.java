//Estuardo Castro, 23890
//16.10.2023
//Crear un inventario que guarde ciertos datos de unos productos ingresados por medio de un csv

import java.util.ArrayList;

public class Inventario{
    public static void main(String[] args){

        //Sé que a lo mejor deseaban que meta todos los productos dentro del array Productos
        //Pero en el ejercicio anterior no me funcionó bien eso, entonces me voy a la segura y los hago separados
        ArrayList<Producto> Productos = new ArrayList<Producto>();
        ArrayList<Bebida> Bebidas = new ArrayList<Bebida>();
        ArrayList<Snack> Snacks = new ArrayList<Snack>();
        
        //Primera cosa que debía de ser capaz de verse
        System.out.println("\n Bienvendo al Inventario de Tiendas la Bendición 😇\n");
        System.out.println("1. La cantidad de productos por cada categoría es:\n");
        System.out.println("Bebidas - " + Bebidas.total() + "\n");
        System.out.println("Snacks - " + Snacks.total() + "\n");
        System.out.println("Otra - " + Productos.total() + "\n");   
        
        //Segunda cosa que se debía de ver
        System.out.println("2. Productos por cada categoría es:\n");
        for(int i=0; i < Bebidas.size(); i++){
            System.out.println("Bebidas:\n");
            System.out.println(i + 1 + ": " + Bebidas.getNombre(i));
        }
        
        for(int i=0; i < Bebidas.size(); i++){
            System.out.println("Snacks:\n");
            System.out.println(i + 1 + ": " + Snacks.getNombre(i));
        }
        
        System.out.println("3. Total de ventas\n");
        System.out.println("Se tuvieron unas ventas totales de: " + TotalVentas());

    }

    //Constructor para obtener el total de las ventas
    public static float TotalVentas(){
        float bebs;
        float sna;

        for(int i=0; i < Bebidas.size(); i++){
            bebs = Bebidas.getPrecio(i);
        }
        for(int i=0; i < Snacks.size(); i++){
            sna = Snacks.getPrecio(i);
        }

        float ventas = (bebs + sna);
        return ventas;
    }
}