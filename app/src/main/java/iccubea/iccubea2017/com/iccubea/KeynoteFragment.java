package iccubea.iccubea2017.com.iccubea;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramotion.foldingcell.FoldingCell;


public class KeynoteFragment extends Fragment {

    FoldingCell fcInauguration, fcKeynote1, fcKeynote2, fcKeynote3, fcKeynote4, fcKeynote5;
    public KeynoteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_keynote, container, false);

        fcInauguration = (FoldingCell) view.findViewById(R.id.folding_cellInauguration);
        // attach click listener to folding cell
        fcInauguration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcInauguration.toggle(false);
            }
        });
        fcKeynote1 = (FoldingCell) view.findViewById(R.id.folding_cellKeynote1);
        // attach click listener to folding cell
        fcKeynote1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcKeynote1.toggle(false);
            }
        });
        fcKeynote2 = (FoldingCell) view.findViewById(R.id.folding_cellKeynote2);
        // attach click listener to folding cell
        fcKeynote2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcKeynote2.toggle(false);
            }
        });

        fcKeynote3 = (FoldingCell) view.findViewById(R.id.folding_cellKeynote3);
        // attach click listener to folding cell
        fcKeynote3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcKeynote3.toggle(false);
            }
        });
        fcKeynote4 = (FoldingCell) view.findViewById(R.id.folding_cellKeynote4);
        // attach click listener to folding cell
        fcKeynote4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcKeynote4.toggle(false);
            }
        });

        fcKeynote5 = (FoldingCell) view.findViewById(R.id.folding_cellKeynote5);
        // attach click listener to folding cell
        fcKeynote5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fcKeynote5.toggle(false);
            }
        });
        return view;
    }


}
