package src.clientes;

/**
 * Cliente
 */
public class Cliente {
    private int id;
    private String nombre;
    private int telefono;
    private boolean estaDisponible;

    public Cliente(int id, String nombre, int telefono,boolean estaDisponible){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.estaDisponible=estaDisponible;
    }

    public Cliente(int id, String nombre){
        this(id, nombre, 0,true);
    }

    //getters y setters

    public int getId(){
        return id;
    }

    public int getTelefono(){
        return telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setTelefono(int telefono){
        this.telefono = telefono;
    }

    public void setEstaDisponible(boolean estaDisponible){
        this.estaDisponible=estaDisponible;
    }

    public boolean getEstaDisponible(){
        return estaDisponible;
    }

    //fin getters y setters

    public String getInformacion(){
        String resultado = "Id: "+id+" Nombre del cliente: " + nombre +" Disponible: "+estaDisponible;
        return resultado;
    }
    
}