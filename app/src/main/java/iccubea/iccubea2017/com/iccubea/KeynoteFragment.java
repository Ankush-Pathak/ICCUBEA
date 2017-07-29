package iccubea.iccubea2017.com.iccubea;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardExpand;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardViewNative;


public class KeynoteFragment extends Fragment {


    public KeynoteFragment() {
        // Required empty public constructor
    }


    Card card;
    CardHeader cardHeader;
    CardViewNative cardViewNative;
    CardExpandInsideSquare innerSquare;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment



        View view =inflater.inflate(R.layout.fragment_keynote, container, false);
        card = new Card(getContext());
        cardHeader = new CardHeader(getContext());
        card.addCardHeader(cardHeader);




        cardHeader.setTitle("Keynote Speaker 1");
        cardHeader.setButtonExpandVisible(true);
        CardExpand cardExpand = new CardExpand(getContext());
        cardExpand.setTitle("Details");
        card.addCardExpand(cardExpand);

        cardViewNative = (CardViewNative) view.findViewById(R.id.cardKeynoteSpeaker1);
        cardViewNative.setCard(card);



        innerSquare = new CardExpandInsideSquare(getActivity(),1,"17/7/17","Dr. Sonali Patil","11:00 am", "Seminar Hall");



        cardHeader.setTitle("Keynote Speaker 2 \n Dr. Jayant Umale");
        cardHeader.setButtonExpandVisible(true);
        CardExpand cardExpand2 = new CardExpand(getContext());
        cardExpand2.setTitle("Details");
        card.addCardExpand(cardExpand2);

        cardViewNative = (CardViewNative) view.findViewById(R.id.cardKeynoteSpeaker2);
        cardViewNative.setCard(card);

        innerSquare = new CardExpandInsideSquare(getActivity(),2,"17/7/17","Dr.Jayant Umale","1:00 pm", "Room no 201");



        cardHeader.setTitle("Keynote Speaker 3 \n Dr. K. Rajeswari");
        cardHeader.setButtonExpandVisible(true);
        CardExpand cardExpand3 = new CardExpand(getContext());
        cardExpand3.setTitle("Details");
        card.addCardExpand(cardExpand3);


        cardViewNative = (CardViewNative) view.findViewById(R.id.cardKeynoteSpeaker3);
        cardViewNative.setCard(card);

        innerSquare = new CardExpandInsideSquare(getActivity(),3,"18/7/17","Dr. K. Rajeswari","10:00 am","LRDC");




        return inflater.inflate(R.layout.fragment_keynote, container, false);
    }


}
