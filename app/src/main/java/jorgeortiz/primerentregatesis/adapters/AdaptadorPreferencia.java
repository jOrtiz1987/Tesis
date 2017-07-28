package jorgeortiz.primerentregatesis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import jorgeortiz.primerentregatesis.R;
import jorgeortiz.primerentregatesis.models.ItemPreferencia;

/**
 * Created by jorge ortiz on 28/03/16.
 */
public class AdaptadorPreferencia extends ArrayAdapter<ItemPreferencia> {
    Context contexto;
    ArrayList<ItemPreferencia> preferencias;
    int layoutPreferencia;


    public AdaptadorPreferencia(Context context, int resource, ArrayList<ItemPreferencia> objects) {
        super(context, resource, objects);
        this.contexto = context;
        this.layoutPreferencia = resource;
        this.preferencias = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //super.getView(position, convertView, parent);

        LayoutInflater inflater = (LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View layoutPreferenciaAInyectar = inflater.inflate(layoutPreferencia, parent, false);

        ItemPreferencia preferenciaActual = preferencias.get(position);

        ImageView icono = (ImageView) layoutPreferenciaAInyectar.findViewById(R.id.imageViewTipo);
        TextView nombre = (TextView) layoutPreferenciaAInyectar.findViewById(R.id.textViewNombrePersona);

        if(preferenciaActual.getPreferencia()) {
            // Like
            icono.setImageResource(R.drawable.ic_like);
        } else {
            //DisLike
            icono.setImageResource(R.drawable.ic_superlike);
        }

        nombre.setText(preferenciaActual.getUsuario().getNombre());

        return layoutPreferenciaAInyectar;
    }
}
