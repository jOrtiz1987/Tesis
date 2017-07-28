package jorgeortiz.primerentregatesis.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

import java.util.List;

import jorgeortiz.primerentregatesis.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CardsFrament extends Fragment implements CardModel.OnCardDimissedListener {


    List<CardModel> barajaCartas;
    private CardContainer mCardContainer;
    private SimpleCardStackAdapter adapter;
    private CardModel.OnCardDimissedListener listener;
    CardModel card = null;
    String nick, sexo, id;
    int width, height;

    public CardsFrament() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_cards, container, false);

        mCardContainer = (CardContainer) v.findViewById(R.id.layoutview);
        mCardContainer.setOrientation(Orientations.Orientation.Ordered);

        CardModel card = new CardModel("1", "Iglesia Santo Domingo", getActivity().getDrawable(R.drawable.edificio11));
        CardModel card2 = new CardModel("2", "Museo Ciencias", getActivity().getDrawable(R.drawable.edificio1));
        CardModel card3 = new CardModel("3", "Museo Francisco Goytia", getActivity().getDrawable(R.drawable.edificio2));
        //CardModel card4 = new CardModel("4", "Museo de Guadalupe", getActivity().getDrawable(R.drawable.edificio3));
        CardModel card5 = new CardModel("5", "Museo Pedro Coronel", getActivity().getDrawable(R.drawable.edificio4));
        //CardModel card6 = new CardModel("6", "Plaza Bicentenario", getActivity().getDrawable(R.drawable.edificio5));
        //CardModel card7 = new CardModel("7", "Plaza De Armas", getActivity().getDrawable(R.drawable.edificio6));
        //CardModel card8 = new CardModel("8", "Plaza Independencia", getActivity().getDrawable(R.drawable.edificio7));
        //CardModel card9 = new CardModel("9", "Plazuela De Garcia", getActivity().getDrawable(R.drawable.edificio8));
        CardModel card10 = new CardModel("10", "Plazuela Fransisco Goytia", getActivity().getDrawable(R.drawable.edificio9));
        //CardModel card11 = new CardModel("11", "Plazuela Miguel Auza", getActivity().getDrawable(R.drawable.edificio10));

        card.setOnCardDimissedListener(this);
        card2.setOnCardDimissedListener(this);
        card3.setOnCardDimissedListener(this);
        //card4.setOnCardDimissedListener(this);
        card5.setOnCardDimissedListener(this);
        //card6.setOnCardDimissedListener(this);
        //card7.setOnCardDimissedListener(this);
        //card8.setOnCardDimissedListener(this);
        //card9.setOnCardDimissedListener(this);
        card10.setOnCardDimissedListener(this);
        //card11.setOnCardDimissedListener(this);


        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(getActivity());
        adapter.add(card);
        adapter.add(card2);
        adapter.add(card3);
        //adapter.add(card4);
        adapter.add(card5);
        //adapter.add(card6);
        //adapter.add(card7);
        //adapter.add(card8);
        //adapter.add(card9);
        adapter.add(card10);
        //adapter.add(card11);
        mCardContainer.setAdapter(adapter);



        // Dimensiones del CardContainer
        RelativeLayout layout = (RelativeLayout)v.findViewById(R.id.layoutCards);
        width = layout.getMeasuredWidth();
        height = layout.getMeasuredHeight();

        return v;
    }

    @Override
    public void onLike() {

    }

    @Override
    public void onDislike() {

    }



}