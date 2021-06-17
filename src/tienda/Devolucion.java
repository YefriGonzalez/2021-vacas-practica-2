package src.tienda;

import src.clientes.VectorClientes;
import src.peliculas.VectorPeliculas;

public class Devolucion {
    public Devolucion(){
    }

    public void devolucion(){
        int idPeli;
        int idCliente;
        boolean peliculaExiste=false;
        boolean clienteExiste=false;
        idPeli=IngresoDatos.getEntero("Ingrese Id de la pelicula que desea devolver: ",false);
        idCliente=IngresoDatos.getEntero("Ingrese Id de cliente para devolver la pelicula: ",false);
        for(int i=0;i<VectorPeliculas.getContador();i++){
            if(VectorPeliculas.getPeliculas()[i].getId()==idPeli && VectorPeliculas.getPeliculas()[i].getEstaDisponible()==false){
                peliculaExiste=true;
            }
        }
        for(int i=0;i<VectorClientes.getSiguienteCodigo();i++){
            if(VectorClientes.getClientes()[i].getId()==idCliente && VectorClientes.getClientes()[i].getEstaDisponible()==false){
                clienteExiste=true;
            }
        }
        if(clienteExiste==true && peliculaExiste==true){
            for(int i=0;i<VectorPeliculas.getContador();i++){
                for(int j=0;j<VectorClientes.getSiguienteCodigo();j++){
                    if(VectorPeliculas.getPeliculas()[i].getId()==idPeli && VectorClientes.getClientes()[j].getId()==idCliente){
                        VectorPeliculas.getPeliculas()[i].setEstaDisponible(true);
                        VectorClientes.getClientes()[j].setEstaDisponible(true);
                        PrestamoPeliculas.setPrestadas([i]="");
                        System.out.println("--------PELICULA DEVUELTA-----------");
                    }
                }
            }
        } else {
            System.out.println("\nLos datos son incorrectos\n");
        }
    }
}
