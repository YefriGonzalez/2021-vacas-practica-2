package src.peliculas;

public class Pelicula {
    private String nombre;
    private String categoria;
    private int id;
    private int ano;
    private boolean estaDisponible;

    public Pelicula(int id,String nombre,String categoria,int año,boolean estaDisponible){
        this.id=id;
        this.nombre=nombre;
        this.categoria=categoria;
        this.ano=año;
        this.estaDisponible=estaDisponible;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public int getId(){
        return id;
    }

    public void setCategoria(String categoria){
        this.categoria=categoria;
    }

    public String getCategoria(){
        return categoria;
    }

    public int getAño(){
        return ano;
    }   

    public void setAño(int año){
        this.ano=año;
    }
    
    public void setEstaDisponible(boolean estaDisponible){
        this.estaDisponible=estaDisponible;
    }

    public boolean getEstaDisponible(){
        return estaDisponible;
    }

    public String getInformacion(){
        String resultado = "Id: "+id+". Nombre de Pelicula: " + nombre+". Categoria: "+categoria+". Año: "+ano+". Disponible: "+estaDisponible;
        return resultado;
    }
}
