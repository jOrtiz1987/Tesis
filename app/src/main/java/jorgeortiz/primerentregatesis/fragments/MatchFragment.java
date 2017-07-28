package jorgeortiz.primerentregatesis.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import jorgeortiz.primerentregatesis.R;
import jorgeortiz.primerentregatesis.adapters.AdaptadorPreferencia;
import jorgeortiz.primerentregatesis.models.ItemPreferencia;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {
    ArrayList<ItemPreferencia> preferencias;
    ListView lista;

    public MatchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_match, container, false);

        lista = (ListView) v.findViewById(R.id.listView);

        preferencias = new ArrayList<>();
        preferencias.add(new ItemPreferencia());
        preferencias.add(new ItemPreferencia());
        preferencias.add(new ItemPreferencia());
        preferencias.add(new ItemPreferencia());
        preferencias.add(new ItemPreferencia());

        AdaptadorPreferencia adaptadorPreferencias = new AdaptadorPreferencia(getActivity(),R.layout.list_item_preferencia,preferencias);

        lista.setAdapter(adaptadorPreferencias);

        return v;
    }

}
