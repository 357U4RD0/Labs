//Estuardo Castro 23890
//Lab 4
//Se debe de hacer un programa que sea capaz poder reservar vuelos con la clase Base, y más cosas.
//A su vez que debe de poder guardar a los usuarios y las reservaciones en CSV.

//Cambios entre el análisis y diseño y el código:
//No coloqué los getters en el análisis, porque creí que no los usaría. Pero es casi que esencial ponerlos.
//Cambié usuarioActual de Usuario a Base.

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kayak {
    private static boolean sesionActiva = false;
    private static Base usuarioActual;
    private static Premium UsuAct;
    private static List<Base> usuarios = new ArrayList<>();
    private static List<Premium> prem = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
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
                        System.out.println("Debes iniciar sesión para generar una confirmación.");
                    }
                    break;
                case 3:
                    if (sesionActiva) {
                        usuarioActual.modificarPerfil();
                    } else {
                        System.out.println("Debes iniciar sesión para modificar tu perfil.");
                    }
                    break;
                case 4:
                    if (sesionActiva && usuarioActual instanceof Base) {
                        cambiarPlan();
                    } else {
                        Registro();
                    }
                    break;
                case 5:
                    if (sesionActiva) {
                        cerrarSesion();
                    } else {
                        System.out.println("¡Hasta pronto!");
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
        sesionActiva = false;
        usuarioActual = null;
        System.out.println("¡Cierre de sesión exitoso!");
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

        System.out.println("¡Registro exitoso como un nuevo usuario Base!");
    }

    private static void cambiarPlan() {
        System.out.print("¿Estás seguro(a) de cambiar a plan Premium? (Si/No): ");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("Si")) {
            Premium nuevoPrem = new Premium(usuarioActual.getNombre(), usuarioActual.getContraseña());
            usuarios.remove(usuarioActual);
            prem.add(nuevoPrem);
            UsuAct = nuevoPrem;

            System.out.println("\n¡Muy bien!");
            System.out.println("Has hecho una de las mejores desiciones de toda tu vida, no te arrepentirás 😉👍");
        }
    }
}