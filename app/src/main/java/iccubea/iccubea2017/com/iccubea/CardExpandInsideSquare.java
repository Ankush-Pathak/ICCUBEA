package iccubea.iccubea2017.com.iccubea;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.CardExpand;

/**
 * Created by Aditya Rao on 7/29/2017.
 */

public class CardExpandInsideSquare extends CardExpand{


    String date,speaker,time,venue;
    int index;

    public CardExpandInsideSquare(Context context, int index, String date, String speaker, String time, String venue) {
        super(context, R.layout.expand_card_text_view);
        this.date = date;
        this.speaker = speaker;
        this.time = time;
        this.venue = venue;
        this.index = index;

    }




    @Override

    public  void setupInnerViewElements(ViewGroup parent,View view)
    {
        TextView textViewKeynoteIndex = (TextView) view.findViewById(R.id.cardExpandIndex);
        TextView textViewKeynoteSpeaker = (TextView) view.findViewById(R.id.cardExpandSpeaker);
        TextView textViewKeynoteDate = (TextView) view.findViewById(R.id.cardExpandDate);
        TextView textViewKeynoteTime = (TextView) view.findViewById(R.id.cardExpandTime);
        TextView textViewKeynoteVenue = (TextView) view.findViewById(R.id.cardExpandVenue);



        if(textViewKeynoteIndex != null)
        {
            textViewKeynoteIndex.setText(index);
        }

        if(textViewKeynoteSpeaker != null)
        {
            textViewKeynoteSpeaker.setText(speaker);
        }

        if(textViewKeynoteDate != null)
        {
            textViewKeynoteDate.setText(date);
        }

        if(textViewKeynoteTime != null)
        {
            textViewKeynoteTime.setText(time);
        }

        if(textViewKeynoteVenue != null)
        {
            textViewKeynoteVenue.setText(venue);
        }
    }
}
