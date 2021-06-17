package src.peliculas;
import src.tienda.*;
public class VectorPeliculas {
    private static Pelicula[] pelicula=new Pelicula[50];
    private static int contador;
    
    
    public VectorPeliculas(){
        contador=0;
    }

    public static Pelicula[] getPeliculas(){
        return pelicula;
    }

    public static int getContador(){
        return contador;
    }

    //Agregar peliculas
    public void agregarPelicula(String nombre,String categoria,int ano){
        if(contador>50){
            System.out.println("Limite de peliculas alcanzadas");
        } else {
            pelicula[contador]=new Pelicula(contador,nombre,categoria,ano,true); 
        }
        contador++;
    }

    public void agregarPelicula(){
        String nombre=IngresoDatos.getTexto("Ingrese en nombre de la pelicula: ");
        int categoria=IngresoDatos.getEntero(categoria(),false);
        int ano=IngresoDatos.getEntero("Año de Pelicula: ",false);
        agregarPelicula(nombre,elegirCategorias(categoria),ano);
    }

    public String categoria(){
        System.out.println("Categorias: ");
        System.out.println("1.Accion           2.Drama");
        System.out.println("3.Comedia          4.Terror");
        System.out.println("5.Ciencia Ficcion  5.Aventuras");
        System.out.print("Ingrese en numero de categoria: ");
        return "";
    }

    public String elegirCategorias(int numero){
        String categoria="";
        if(numero==1){
            categoria="Accion";
        } else if(numero==2){
            categoria="Drama";
        } else if(numero==3){
            categoria="Comedia";
        } else if(numero==4){
            categoria="Terror";
        } else if(numero==5){
            categoria="Ciencia Ficcion";
        } else if(numero==6){
            categoria="Aventuras";
        }
        return categoria;
    }

    // Imprimir las peliculas     
    public void mostrarPeliculas(){
        System.out.println("Peliculas de Memorabilia: \n");
        for(int i=0;i<contador;i++){
            System.out.println("--"+i+" Id: "+pelicula[i].getInformacion());
        }
        System.out.println("\n");
    }

    // Ordenamiento de  peliculas por nombre
    public void ordenarPorNombre(boolean ascendente){
        boolean cambio = true;
        for (int i = 0; i <contador; i++) {
            for (int j = 0; j < (contador-i-1); j++) {
                //  String.compareTo(String)
                //   [-oo , + oo]
                if (ascendente)
                    cambio= (pelicula[j].getNombre().compareTo(pelicula[j+1].getNombre()) > 0 );
                else 
                    cambio= (pelicula[j].getNombre().compareTo(pelicula[j+1].getNombre()) < 0 );

                if(cambio ){
                    //clientes i va antes que clientes j <0 descendente
                    Pelicula aux = pelicula[j];
                    pelicula[j] = pelicula[j+1];
                    pelicula[j+1]= aux;
                }
            }
        }

    }

    public void modificarPelicula(int id){   
        int nuevaCategoria;
        int nuevoAño;
        String nuevoNombre;
        for(int i=0;i<contador;i++){
            if(pelicula[i].getId()==id){
                System.out.println("Categoria Actual: "+pelicula[i].getCategoria());
                nuevaCategoria=IngresoDatos.getEntero(categoria(),false);
                pelicula[i].setCategoria(elegirCategorias(nuevaCategoria));
                System.out.println("Año actual: "+pelicula[i].getAño());
                nuevoAño=IngresoDatos.getEntero("Ingrese el nuevo año: ",false);
                pelicula[i].setAño(nuevoAño);
                System.out.println("Nombre Actual: "+pelicula[i].getNombre());
                nuevoNombre=IngresoDatos.getTexto("Ingres el nuevo nombre: ");
                pelicula[i].setNombre(nuevoNombre);
            }
        }
    }


    public void modificarPelicula(){
        int id=IngresoDatos.getEntero("Ingrese el id de la pelicula que desea modificar: ",false);
        modificarPelicula(id);
    }

}
