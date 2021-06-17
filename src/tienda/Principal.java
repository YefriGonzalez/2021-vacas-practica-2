package src.tienda;

import src.clientes.VectorClientes;
import src.peliculas.*;
public class Principal {

    public static void main(String[] args){
        Principal p = new Principal();
    }

    private VectorClientes tablaClientes = new VectorClientes();
    private VectorPeliculas tablaPeliculas=new VectorPeliculas();
    private PrestamoPeliculas p1=new PrestamoPeliculas();
    private Devolucion dv=new Devolucion();

    public Principal(){

        int menu = 0;

        while(menu >= 0){
            System.out.println("Bienvenido a memorabilia \n");
            System.out.println("1) Ingreso de clientes");
            System.out.println("2) Mostrar clientes");
            System.out.println("3) Ordenar Clientes en forma Ascendente");
            System.out.println("4) Ordenar Clientes en forma Descendente");
            System.out.println("5) Ingreso de peliculas");
            System.out.println("6) Mostrar Peliculas");
            System.out.println("7) Ordenar Peliculas en forma Ascendente");
            System.out.println("8) Ordenar Peliculas en fomra Descendente");
            System.out.println("9) Modificar Pelicula");
            System.out.println("10) Alquilar Pelicula");
            System.out.println("11) Devolver Pelicula");
            System.out.println("-1) Salir");
            System.out.println("\n");
            menu = IngresoDatos.getEntero("Ingrese la opción ", true);

            if (menu == 1 ){
                //ingreso de datos
                tablaClientes.agregarCliente();
            }
            if (menu == 2){
                //mostrar clientes
                tablaClientes.mostrarClientes();
            }
            if (menu == 3){
                //mostrar clientes
                System.out.println("Desordenado:");
                tablaClientes.mostrarClientes();
                System.out.println("\nOrdenado:");
                tablaClientes.ordenarPorNombre(true);
                tablaClientes.mostrarClientes();
            }
            if (menu == 4){
                //mostrar clientes
                System.out.println("Desordenado:");
                tablaClientes.mostrarClientes();
                System.out.println("\n\nOrdenado:");
                tablaClientes.ordenarPorNombre(false);
                tablaClientes.mostrarClientes();
            }
            if(menu==5){
                tablaPeliculas.agregarPelicula();
            }
            if(menu==6){
                tablaPeliculas.mostrarPeliculas();
            }
            if(menu==7){
                System.out.println("Desordenado:");
                tablaPeliculas.mostrarPeliculas();
                System.out.println("\nOrdenado:");
                tablaPeliculas.ordenarPorNombre(true);
            } 
            if(menu==8){
                System.out.println("Desordenado:");
                tablaPeliculas.mostrarPeliculas();
                System.out.println("\nOrdenado:");
                tablaPeliculas.ordenarPorNombre(false);
            }
            if(menu==9){
                tablaPeliculas.mostrarPeliculas();
                tablaPeliculas.modificarPelicula();
                tablaPeliculas.mostrarPeliculas();
            }
            if(menu==10){
                tablaClientes.mostrarClientes();
                tablaPeliculas.mostrarPeliculas();
                p1.alquiler();
                p1.mostrarDatos();
            }
            if(menu==11){
                p1.mostrarDatos();
                dv.devolucion();
                tablaClientes.mostrarClientes();
                tablaPeliculas.mostrarPeliculas();
            }
        }
    }
}
