package jorgeortiz.primerentregatesis.models;

/**
 * Created by Yoshi on 28/03/2017.
 */

public class ItemPreferencia {

    EdificioHistorico edificioHistorico;
    Usuario usuario;
    Boolean preferencia;

    public ItemPreferencia(){
        usuario = new Usuario();
    }

    public EdificioHistorico getEdificioHistorico() {
        return edificioHistorico;
    }

    public void setEdificioHistorico(EdificioHistorico edificioHistorico) {
        this.edificioHistorico = edificioHistorico;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Boolean preferencia) {
        this.preferencia = preferencia;
    }
}
