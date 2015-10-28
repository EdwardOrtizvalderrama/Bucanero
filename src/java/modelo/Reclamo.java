package modelo;


public class Reclamo {
    private String nombre; 
    private int telefono;
    private String tipo;
    private String texto; 

    public Reclamo(String nombre, int telefono, String tipo, String texto) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.tipo = tipo;
        this.texto = texto;      
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }
    
    
}


