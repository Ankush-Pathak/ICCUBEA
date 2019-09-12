package iccubea.iccubea2017.com.iccubea;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramotion.foldingcell.FoldingCell;



public class QuickTalksFrag extends Fragment {

    FoldingCell fcqt1, fcqt2, fcqt3, fcqt4, fcqt5;

    public QuickTalksFrag() {
        // Required empty public constructor
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quick_talks, container, false);

        fcqt1 = (FoldingCell) view.findViewById(R.id.folding_cellQuickTalk1);
        // attach click listener to folding cell
        fcqt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              fcqt1.toggle(false);
            }
        });

        fcqt2 = (FoldingCell) view.findViewById(R.id.folding_cellQuickTalk2);
        // attach click listener to folding cell
        fcqt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcqt2.toggle(false);
            }
        });


        fcqt3 = (FoldingCell) view.findViewById(R.id.folding_cellQuickTalk3);
        // attach click listener to folding cell
        fcqt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcqt3.toggle(false);
            }
        });


        fcqt4 = (FoldingCell) view.findViewById(R.id.folding_cellQuickTalk4);
        // attach click listener to folding cell
        fcqt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcqt4.toggle(false);
            }
        });

        fcqt5 = (FoldingCell) view.findViewById(R.id.folding_cellQuickTalk5);
        // attach click listener to folding cell
        fcqt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcqt5.toggle(false);
            }
        });

        return view;
    }

    
    
}
