package jorgeortiz.primerentregatesis.models;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Yoshi on 28/03/2017.
 */

public class EdificioHistorico {
    String nombre = "";
    String descripcion = "";
    LatLng coordenadas;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LatLng getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(LatLng coordenadas) {
        this.coordenadas = coordenadas;
    }
}
