package iccubea.iccubea2017.com.iccubea;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AboutICCUBEAFrag extends Fragment {

    TextView textView;
    View view;
    public AboutICCUBEAFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_about_iccubea, container, false);
        textView = (TextView)view.findViewById(R.id.textViewInfoIccubea);
        Typeface tf= Typeface.createFromAsset(getActivity().getAssets(), "Humanst521_Lt_BT_Light.ttf");
        textView.setTypeface(tf);
        return view;

    }

}
