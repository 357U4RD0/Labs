//Esta clase la creé únicamente para ir guardando los usuarios que se cambien a premium, no voy a hacer nada con ellos
//Por lo que nomás crearé el objeto

public class Premium{
    private String nombre;
    private String contraseña;

    public Premium(String nombre, String contraseña){
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getContraseña(){
        return this.contraseña;
    }
}