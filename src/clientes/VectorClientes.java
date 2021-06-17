package src.clientes;

import src.tienda.*;

public class VectorClientes {
    private static Cliente[] clientes = new Cliente[50];
    private static int siguienteCodigo;

    public VectorClientes(){
        siguienteCodigo = 0;
    }

    public static int getSiguienteCodigo(){
        return siguienteCodigo;
    }

    public static  Cliente[] getClientes(){
        return clientes;
    }

    //agregar clientes
    public void agregarCliente(String nombre, int telefono){
        if (siguienteCodigo > 50){
            System.out.println("Límite de clientes alcanzado");
        }
        else{
            clientes[(siguienteCodigo)] = new Cliente(siguienteCodigo, nombre, telefono,true);
        }
        siguienteCodigo++;
    }

    public void agregarCliente(){
        String nombre = IngresoDatos.getTexto("Ingrese el nombre del cliente: ");
        int telefono = IngresoDatos.getEntero("Ingrese el número de telefono: ", false);
        agregarCliente(nombre, telefono);
    }



    // fin agregar clientes

    public void mostrarClientes(){
        System.out.println("\n Clientes de memorabilia");
        for (int i = 0; i <siguienteCodigo; i++) {
            System.out.println("--"+i+") "+clientes[i].getInformacion());
            //System.out.println("--"+i+") "+clientes[i].getId() + " nombre "+clientes[i].getNombre()+ " telefono "+clientes[i].getTelefono());
            
        }

        System.out.println("\n\n");
    }


    //Ordenamiento
    public void ordenarPorNombre(boolean ascendente){
        boolean cambio = true;

        for (int i = 0; i < siguienteCodigo; i++) {
            for (int j = 0; j < (siguienteCodigo-i-1); j++) {
                //  String.compareTo(String)
                //   [-oo , + oo]
                if (ascendente)
                    cambio= (clientes[j].getNombre().compareTo(clientes[j+1].getNombre()) > 0 );
                else 
                    cambio= (clientes[j].getNombre().compareTo(clientes[j+1].getNombre()) < 0 );

                if(cambio ){
                    //clientes i va antes que clientes j <0 descendente
                    Cliente aux = clientes[j];
                    clientes[j] = clientes[j+1];
                    clientes[j+1]= aux;
                }
            }
        }

    }


    
}
