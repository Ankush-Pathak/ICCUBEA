package iccubea.iccubea2017.com.iccubea;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;


public class FragmentReportingArea extends Fragment {
    ImageView imageView;
    Spinner spinner;
    PhotoViewAttacher photoViewAttacher;
    public FragmentReportingArea() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reporting_area, container, false);
        imageView = (ImageView) view.findViewById(R.id.imageViewCheckInMap);
        spinner = (Spinner)view.findViewById(R.id.spinnerHelpDesk);
        ArrayList categories=new ArrayList<String>();
        categories.add("Contact Help Desk");
        categories.add("Mrs. Bhandarkar");
        categories.add("Mr. Ganesh Deshmukh");
        categories.add("Mr. Sagar Salunke");
        ArrayAdapter dataAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(R.layout.dropdown_newline);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=parent.getItemAtPosition(position).toString();
                System.out.println("In method");
                String phnum,name;

                switch (position)
                {
                    case 0:Typeface tf1= Typeface.createFromAsset(getActivity().getAssets(),"Museo100-Regular.otf");
                        TextView selectedtext=(TextView)parent.getChildAt(0);
                        selectedtext.setTypeface(tf1);
                        selectedtext.setTextSize(21);
                        if(selectedtext!=null)
                        {
                            selectedtext.setTextColor(Color.RED);
                        }
                        break;


                    case 1:
                        name = "Mrunalini Bhandarkar";
                        phnum = "tel:9765381652";
                        displayDialog1(item,phnum,name);
                        break;

                    case 2:
                        name = "Ganesh Deshmukh";
                        phnum = "tel:9423881868";
                        displayDialog1(item,phnum,name);
                        break;
                    case 3:
                        name = "Sagar Salunke";
                        phnum = "tel:9970141188";
                        displayDialog1(item,phnum,name);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }



        });
        // Set the Drawable displayed
        Drawable bitmap = getResources().getDrawable(R.drawable.checkin_map);
        imageView.setImageDrawable(bitmap);

        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        photoViewAttacher = new PhotoViewAttacher(imageView);
        return view;

    }

    public void displayDialog1(String trackName, final String strinNumber,final String name)
    {
        final Dialog dialog1 = new Dialog(getActivity());
        dialog1.setContentView(R.layout.dialogbox);
        dialog1.setTitle("Contact Details");
        TextView textViewName1,textViewTrack1;
        textViewName1=(TextView)dialog1.findViewById(R.id.textViewName1);
        textViewTrack1=(TextView)dialog1.findViewById(R.id.textViewTrack1);
        textViewTrack1.setText("Call : " + trackName);
        textViewName1.setVisibility(View.GONE);
        Button buttonCall;
        buttonCall=(Button)dialog1.findViewById(R.id.buttonCall);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                call(strinNumber);
                dialog1.dismiss();
                Toast.makeText(getContext(), "Calling " + name , Toast.LENGTH_SHORT).show();
            }

        });
        dialog1.show();

    }
    public void call(String num)
    {

        Intent callintent=new Intent(Intent.ACTION_DIAL);
        callintent.setData(Uri.parse(num));
        try
        {
            startActivity(callintent);
        }
        catch(android.content.ActivityNotFoundException e)
        {
            Toast.makeText(getActivity(), "Unable to make call", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }
}
