import java.util.List;
import java.util.Scanner;

class Base implements Usuario {
    private String nombre;
    private String contraseña;
    private static Scanner scanner = new Scanner(System.in);
    private boolean sesionActiva = false;
    private Usuario usuarioActual = null;
    private List<Base> usuarios;


    public Base(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contraseña = contraseña;
    }

    @Override
    public void realizarReserva() {
        if (!sesionActiva || !(usuarioActual instanceof Base)) {
            System.out.println("Debes iniciar sesión como usuario base para realizar una reserva.");
            return;
        }

        // Lógica para realizar una reserva
    }

    @Override
    public void generarConfirmacion() {
        if (!sesionActiva || !(usuarioActual instanceof Base)) {
            System.out.println("Debes iniciar sesión como usuario base para generar una confirmación.");
            return;
        }

        // Lógica para generar una confirmación
    }

    @Override
    public void modificarPerfil() {
        if (!sesionActiva || !(usuarioActual instanceof Base)) {
            System.out.println("Debes iniciar sesión como usuario base para modificar tu perfil.");
            return;
        }

        // Lógica para modificar el perfil de un usuario base
    }
}