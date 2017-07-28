package jorgeortiz.primerentregatesis.models;

/**
 * Created by Yoshi on 28/03/2017.
 */

public class Usuario {
    Integer id;
    String nombre="";

    public Usuario(){
        nombre = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
