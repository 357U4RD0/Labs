//Estuardo Castro 23890
//Lab 4
//Se debe de hacer un programa que sea capaz poder reservar vuelos con la clase Base, y más cosas.
//A su vez que debe de poder guardar a los usuarios y las reservaciones en CSV.

//Cambios entre el análisis y diseño y el código:
//No coloqué los getters en el análisis, porque creí que no los usaría. Pero es casi que esencial ponerlos.
//Cambié usuarioActual de Usuario a Base.

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kayak {
    private static boolean sesionActiva = false;
    private static Base usuarioActual;
    private static List<Base> usuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String archivo = "usuarios.csv";

    public static void main(String[] args) {
        cargarUsuarios();
        mostrarMenu();
    }

    private static void cargarUsuarios() {
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String nombre = parts[0];
                String contraseña = parts[1];
                Base usuario = new Base(nombre, contraseña);
                usuarios.add(usuario);
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios desde el archivo CSV: " + e.getMessage());
        }
    }

    private static void mostrarMenu() {
        System.out.println("¡Bienvenido a Kayak!");
        while (true) {
            System.out.println("\n----- Menú Principal -----");
            if (sesionActiva == true) {
                if (usuarioActual instanceof Base) {
                    System.out.println("1. Realizar una reserva");
                    System.out.println("2. Generar una confirmación");
                    System.out.println("3. Modificar perfil");
                    System.out.println("4. Cerrar sesión");
                }    
            } else {
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Registrarse como usuario Base");
                System.out.println("3. Registrarse como usuario Premium");
                System.out.println("4. Salir");
            }
            
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if (sesionActiva) {
                        usuarioActual.realizarReserva();
                    } else {
                        iniciarSesion();
                    }
                    break;

                case 2:
                    if (sesionActiva) {
                        usuarioActual.generarConfirmacion();
                    } else {
                        Registro();
                    }
                    break;

                case 3:
                    if (sesionActiva && usuarioActual instanceof Base) {
                        usuarioActual.modificarPerfil();
                    } else {
                        System.out.println("\nExcelente desición, solo que para ser Premium debes de pagar $10000");
                        System.out.println("Y como no creíamos que alguien lo fuese a hacer, no ha sido desarrollado");
                        System.out.println("De igual manera, eres un grande 😎\n");
                    }
                    break;

                case 4:
                    if (sesionActiva) {
                        cerrarSesion();
                    } else {
                        System.out.println("\n¡Adios!");
                        System.out.println("Espero que tu uso del programa haya sido agradable\n");
                        System.exit(0);
                    }
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, elige una opción válida.");      
            
            }
        }
    }

    private static void iniciarSesion() {
        System.out.print("Ingresa tu nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        String contraseña = scanner.nextLine();


        for (Base usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario) && usuario.getContraseña().equals(contraseña)) {
                sesionActiva = true;
                usuarioActual = usuario;
                System.out.println("¡Inicio de sesión exitoso!");
                return;
            }
        }

        System.out.println("Nombre de usuario o contraseña incorrectos. Por favor, intenta nuevamente.");
    }

    private static void cerrarSesion() {
        if (sesionActiva){
            sesionActiva = false;
            usuarioActual = null;
            System.out.println("¡Cierre de sesión exitoso!");
        } else {
            System.out.println("No hay ninguna sesión iniciada como para poder cerrarla");
        }
        
    }

    private static void Registro() {
        System.out.print("Ingresa tu nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingresa tu contraseña: ");
        String contraseña = scanner.nextLine();

        Base nuevoUsuario = new Base(nombreUsuario, contraseña);
        usuarios.add(nuevoUsuario);
        sesionActiva = true;
        usuarioActual = nuevoUsuario;

        nuevoUsuario.Guardar();

        System.out.println("¡Registro exitoso como un nuevo usuario Base!");
    }
}