package src.tienda;

import src.clientes.VectorClientes;
import src.peliculas.VectorPeliculas;

public class PrestamoPeliculas {
    private static String[] prestadas=new String[10000]; 
    private int contador;
    private static int[] vecesPrestadas=new int[50];
    public PrestamoPeliculas(){
        contador=0;
        inicializarVecesPrestadas();
    }

    public static int[] getVecesPrestadas(){
        return vecesPrestadas;
        
    }

    public static void setPrestadas(String[] prestada){
        prestadas=prestada;
    }

    public void inicializarVecesPrestadas(){
        for(int i=0;i<vecesPrestadas.length;i++){
            vecesPrestadas[i]=0;
        }
    }

    public  void alquiler(){
        int idPeli;
        int idCliente;
        int dias;
        boolean peliculaExiste=false;
        boolean clienteExiste=false;
        idPeli=IngresoDatos.getEntero("Ingrese Id de la pelicula que desea alquilar: ",false);
        idCliente=IngresoDatos.getEntero("Ingrese Id de cliente para alquilar la pelicula: ",false);
        dias=IngresoDatos.getEntero("Ingrese la cantidad de dias de alquiler: ", false);
        for(int i=0;i<VectorPeliculas.getContador();i++){
            if(VectorPeliculas.getPeliculas()[i].getId()==idPeli && VectorPeliculas.getPeliculas()[i].getEstaDisponible()==true){
                peliculaExiste=true;
            }
        }
        for(int i=0;i<VectorClientes.getSiguienteCodigo();i++){
            if(VectorClientes.getClientes()[i].getId()==idCliente && VectorClientes.getClientes()[i].getEstaDisponible()==true){
                clienteExiste=true;
            }
        }
        if(clienteExiste==true && peliculaExiste==true){
            for(int i=0;i<VectorPeliculas.getContador();i++){
                for(int j=0;j<VectorClientes.getSiguienteCodigo();j++){
                    if(VectorPeliculas.getPeliculas()[i].getId()==idPeli && VectorClientes.getClientes()[j].getId()==idCliente){
                        VectorPeliculas.getPeliculas()[i].setEstaDisponible(false);
                        VectorClientes.getClientes()[j].setEstaDisponible(false);
                        vecesPrestadas[i]++;
                        prestadas[contador]="Id Pelicula: "+idPeli+". Id Cliente: "+idCliente+". Cantidad de dias: "+dias;
                        System.out.println("--------PELICULA ALQUILADA-----------");
                        contador++;
                    }
                }
            }
        } else {
            System.out.println("\nLos datos son incorrectos\n");
        }
    }

    public void mostrarDatos(){
        System.out.println("\nAlquiladas: \n");
        for(int i=0;i<contador;i++){
            System.out.println(prestadas[i]);
        }
        System.out.println("\n");
    }

}
