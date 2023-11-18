import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Base implements Usuario {
    private String nombre;
    private String contraseña;

    public Base(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    @Override
    public void realizarReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la fecha de viaje: ");
        String fechaViaje = scanner.nextLine();
        System.out.print("¿Es un vuelo de ida y vuelta? (Sí/No): ");
        boolean idaVuelta = scanner.nextLine().equalsIgnoreCase("Sí");
        System.out.print("Ingresa la cantidad de boletos: ");
        int cantidadBoletos = scanner.nextInt();
        scanner.nextLine(); // Consumir la línea en blanco
        System.out.print("Ingresa la aerolínea: ");
        String aerolinea = scanner.nextLine();

        Reserva reserva = new Reserva(fechaViaje, idaVuelta, cantidadBoletos, aerolinea);

        System.out.println("Reserva realizada con éxito!");
        scanner.close();
    }

    @Override
    public void generarConfirmacion() {
        Scanner scanner = new Scanner(System.in);

        if (!tieneReserva()) {
            System.out.println("Debes realizar una reserva antes de generar una confirmación.");
            return;
        }

        System.out.print("Ingresa el número de tarjeta: ");
        String numeroTarjeta = scanner.nextLine();
        System.out.print("Ingresa la cantidad de cuotas (1 hasta 24): ");
        int cuotas = scanner.nextInt();
        scanner.nextLine();

        // Obtener la reserva del usuario actual (pendiente)
        Confirmacion confirmacion = new Confirmacion(numeroTarjeta, cuotas, "ClaseEconomica", "AsientoNoAsignado", 1);
        confirmacion.guardar();
        System.out.println("Confirmación generada con éxito!");
        scanner.close();
    }

    @Override
    public void modificarPerfil() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Cambiar contraseña");
        System.out.println("2. Aplicar cupón");
        System.out.println("3. Volver al menú principal");

        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.print("Ingresa la nueva contraseña: ");
                String nuevaContraseña = scanner.nextLine();
                setContraseña(nuevaContraseña);
                System.out.println("Contraseña cambiada con éxito!");
                break;
            
            case 2:
                System.out.println("Aplicado, ahora eres más rico por haberte ahorrado ese 10% 🤑👌");
                break;

            case 3:
                System.out.println("Muy bien, con esto hecho, volvemos al menú");
                break;
            default:
                System.out.println("Opción inválida. Volviendo al menú principal.");
        
        scanner.close();
        }
    }

    public void Guardar() {
        try {
            FileWriter writer = new FileWriter("Usuarios.csv");
            writer.append(this.nombre);
            writer.append(",");
            writer.append(this.contraseña);
            // Agrega más campos según sea necesario
            writer.append("\n");
            writer.close();
            System.out.println("El usuario se ha guardado");
        } catch (IOException e) {
            System.out.println("No se pudo guardar el usuario en el archivo CSV.");
        }
    }
    
    public void setContraseña(String nuevaContra){
        this.contraseña = nuevaContra;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getContraseña(){
        return this.contraseña;
    }

    public boolean tieneReserva(){
        return false;
    }
}