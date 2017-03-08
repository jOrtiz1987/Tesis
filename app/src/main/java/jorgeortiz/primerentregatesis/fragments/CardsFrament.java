package jorgeortiz.primerentregatesis.fragments;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.andtinder.model.CardModel;
import com.andtinder.model.Orientations;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
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

        CardModel card = new CardModel("1", "Catedral", getActivity().getDrawable(R.drawable.picture1));
        CardModel card2 = new CardModel("2", "Catedral goes here", getActivity().getDrawable(R.drawable.picture2));
        CardModel card3 = new CardModel("3", "Description Catedral here", getActivity().getDrawable(R.drawable.picture3));

        card.setOnCardDimissedListener(this);
        card2.setOnCardDimissedListener(this);
        card3.setOnCardDimissedListener(this);

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(getActivity());
        adapter.add(card);
        adapter.add(card2);
        adapter.add(card3);
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