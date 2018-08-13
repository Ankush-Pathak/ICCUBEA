package iccubea.iccubea2017.com.iccubea;


import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrackYourPaperPresentatorFragment extends Fragment implements AdapterView.OnItemSelectedListener{
    ArrayList<String> resultsIds,resultsDom,resultsLoc,resultsDat,resultsTime,resultsName,resultsTitle,resultsSessionChairs;
    SQLiteDatabase sqLiteDatabase;
    Spinner spinner;
    Cursor databasePaper;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    SearchView editTextSearch;
    ListView listView;
    ArrayList<String> displayResultList;
    ArrayAdapter<String> displayResult;
    TextView textView;
    ArrayAdapter<String> dataAdapter;
    List<String> categories;
    Handler handler;
    TextView textview;
    View view;
    ArrayList<Paper> paper, paperDisplay;
    boolean searchViewEnable;

    public TrackYourPaperPresentatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_track_your_paper_presentator, container, false);
        initialise();
        editTextSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (searchViewEnable) {
                    if (newText.length() > 1) {
                        search();
                    }
                    else
                    {
                        listView.setAdapter(null);
                    }
                }
                else {
                        listView.setAdapter(null);
                        Toast.makeText(getActivity(), "Retriving data, ensure data connection.",Toast.LENGTH_LONG).show();
                    }


                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                displayDialog(i);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }



    public void initialise()
    {

        //sqLiteDatabase = ((TrackYourPaperTabbed)getActivity()).sqLiteDatabase;
        editTextSearch = (SearchView)view.findViewById(R.id.editTextSearch);
        editTextSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(searchViewEnable == false)
                {
                    Toast.makeText(getActivity(), "Retriving data, ensure data connection.",Toast.LENGTH_LONG).show();
                }
                editTextSearch.setIconified(!editTextSearch.isIconified());
            }
        });

        editTextSearch.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextSearch.setQueryHint("Author name, PID or Track");
            }
        });
        editTextSearch.setIconified(false);
        paper = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Presenters");
        databaseReference.keepSynced(true);
        searchViewEnable = false;
        editTextSearch.setEnabled(false);

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren())
                {
                    paper.add(ds.getValue(Paper.class));
                }
                searchViewEnable = true;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listView = (ListView)view.findViewById(R.id.listView);
        textView = (TextView)view.findViewById(R.id.textViewHelper);
        resultsDom = new ArrayList();
        resultsIds = new ArrayList();
        resultsLoc = new ArrayList();
        resultsDat = new ArrayList();
        resultsTime = new ArrayList();
        resultsName = new ArrayList();
        resultsTitle = new ArrayList<>();
        resultsSessionChairs = new ArrayList<>();


        //For Contact
        spinner=(Spinner)view.findViewById(R.id.spinner);
        categories=new ArrayList<String>();
        categories.add("Contact respective Incharges");
        categories.add( "Image Processing and Computer Vision");
        categories.add("Computer and Communication Security");
        categories.add("Databases and Big Data");
        categories.add("HPC, Cloud and Social Network Analysis");
        categories.add("IOT and Computer Networks");
        categories.add("Signal Processing and Applications");
        categories.add("Digital Communication");
        categories.add("VLSI and Embedded Systems");
        categories.add("Control and Automation");
        categories.add("Cognitive and Intelligent Systems");
        dataAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,categories);
        dataAdapter.setDropDownViewResource(R.layout.dropdown_newline);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(this);

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


    public void search()
    {
        int i = 0;
        textView.setText("In search not found!");
        //Toast.makeText(this,"In search.",Toast.LENGTH_SHORT).show();
        displayResultList = new ArrayList<>();
        String idOrDomain;

        idOrDomain = editTextSearch.getQuery().toString();
        if(idOrDomain == null)
            idOrDomain = "445sdsd";

        /*databasePaper = sqLiteDatabase.rawQuery("SELECT * FROM data WHERE paper_id LIKE '" + idOrDomain + "' or track LIKE '%" + idOrDomain + "%' or author LIKE '%" + idOrDomain + "%'",null);
        databasePaper.moveToFirst();
        while (databasePaper.isAfterLast() == false)
        {
            if(i > 499)
                break;
            resultsIds[i] = databasePaper.getString(1);
            resultsDom[i] = databasePaper.getString(6);
            resultsLoc[i] = databasePaper.getString(7);
            resultsDat[i] = databasePaper.getString(5);
            resultsTime[i] = databasePaper.getString(8);
            resultsName[i] = databasePaper.getString(3);
            displayResultList.add("Name : " + databasePaper.getString(3) + "\nPaper Id : " + databasePaper.getString(1) + "\nDomain : " + databasePaper.getString(6));
            databasePaper.moveToNext();
            i++;

            displayFinalList();
        }
        i = 0;*/

        resultsDom = new ArrayList();
        resultsIds = new ArrayList();
        resultsLoc = new ArrayList();
        resultsDat = new ArrayList();
        resultsTime = new ArrayList();
        resultsName = new ArrayList();
        resultsTitle = new ArrayList<>();
        resultsSessionChairs = new ArrayList<>();
        displayResultList = new ArrayList<>();
        for(Paper p : paper)
        {
            if(String.valueOf(p.getPid()).contains(idOrDomain.toLowerCase()) || p.getAuthor().toLowerCase().contains(idOrDomain.toLowerCase()) || p.getTrack().toLowerCase().contains(idOrDomain.toLowerCase()))
            {
                resultsIds.add(String.valueOf(p.getPid()));
                resultsDom.add(p.getTrack());
                resultsLoc.add(p.getLocation());
                resultsDat.add(p.getDate());
                resultsTime.add(p.getTime());
                resultsName.add(p.getAuthor());
                resultsTitle.add(p.getTitle());
                resultsSessionChairs.add(p.getSession_chairs());
                SpannableString name, paperId, track;
                name = new SpannableString("Name");
                name.setSpan(new StyleSpan(Typeface.BOLD),0,"Name".length(),0);
                paperId = new SpannableString("PaperID");
                paperId.setSpan(new StyleSpan(Typeface.BOLD),0,"PaperID".length(),0);
                track = new SpannableString("Track");
                track.setSpan(new StyleSpan(Typeface.BOLD),0,"Track".length(),0);
                displayResultList.add(name + " : " + p.getAuthor().substring(0,Math.min(15,p.getAuthor().length())) + "\n" + paperId + " : " + String.valueOf(p.getPid()) + "\n" + track + " : " + p.getTrack());
            }
        }
        displayFinalList();
    }
    public void displayFinalList()
    {

        textView.setText("In search found!");
        displayResult = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,displayResultList);
        listView.setAdapter(displayResult);
    }

    /*@Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(getActivity(),MainActivity.class);
        intent.putExtra("key",1);
        startActivity(intent);
        getActivity().finish();
    }*/
    public void displayDialog(int i)
    {
        final Dialog dialog = new Dialog(getActivity(),android.R.style.Theme_DeviceDefault_Light_Dialog);
        dialog.setContentView(R.layout.customdialog);

        dialog.setTitle("Details : ");
        TextView textViewId,textViewDom,textViewDate,textViewVen,textViewTime,textViewName,textViewTitle,textViewSessionChairs;
        Button btnOk;
        textViewDate = (TextView)dialog.findViewById(R.id.textViewDate);
        textViewDom = (TextView)dialog.findViewById(R.id.textViewDom);
        textViewId = (TextView)dialog.findViewById(R.id.textViewID);
        textViewVen = (TextView)dialog.findViewById(R.id.textViewVenue);
        textViewTime = (TextView)dialog.findViewById(R.id.textViewTime);
        textViewName = (TextView)dialog.findViewById(R.id.textViewAuthorName);
        textViewTitle = (TextView)dialog.findViewById(R.id.textViewPaperTitle);
        textViewSessionChairs = (TextView)dialog.findViewById(R.id.textViewSessionChair);

        textViewDate.append(" " + resultsDat.get(i));
        textViewDom.append(" " + resultsDom.get(i));
        textViewTime.append(" " + resultsTime.get(i));
        textViewVen.append(" " + resultsLoc.get(i));
        textViewId.append(" " + resultsIds.get(i));
        textViewSessionChairs.append(" " + resultsSessionChairs.get(i));
        textViewName.append(" " + resultsName.get(i));
        textViewTitle.append(" " + resultsTitle.get(i));
        btnOk = (Button)dialog.findViewById(R.id.btnOkDialog);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    public void displayDialog1(String trackName, final String strinNumber,final String name)
    {
        final Dialog dialog1 = new Dialog(getActivity());
        dialog1.setContentView(R.layout.dialogbox);
        dialog1.setTitle("Contact Details");
        TextView textViewName1,textViewTrack1;
        textViewName1=(TextView)dialog1.findViewById(R.id.textViewName1);
        textViewTrack1=(TextView)dialog1.findViewById(R.id.textViewTrack1);
        textViewTrack1.append(trackName);
        textViewName1.append(name);
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
                name="Dr. Pravin Futane";
                phnum="tel:9823033342";
                displayDialog1(item,phnum,name);
                break;

            case 3:
                name = "Mr. R. A. Patil";
                phnum = "tel:9766830968";
                displayDialog1(item,phnum,name);


                break;
            case 5:
                name = "Mr. S.S. Sambare";
                phnum = "tel:9689907628";
                displayDialog1(item, phnum, name);


                break;
            case 4:
                name = "Mrs. S. A. Gore";
                phnum = "tel:9860643053";
                displayDialog1(item,phnum,name);


                break;
            case 6:
                name = "Dr. N. B. Chopade";
                phnum = "tel:9423722805";
                displayDialog1(item,phnum,name);


                break;
            case 7:
                name = "Dr. K. Kinage";
                phnum="tel:9552969900";
                displayDialog1(item,phnum,name);


                break;
            case 8:
                name = "Dr. M.T. Kolate";
                phnum="tel:9860446160";
                displayDialog1(item,phnum,name);


                break;
            case 9:
                name = "Prof. A. R. Suryawanshi";
                phnum = "tel:9422376016";
                displayDialog1(item,phnum,name);


                break;
            case 10:
                name = "Dr. K. Rajeswari";
                phnum = "tel:7066892206";
                displayDialog1(item, phnum, name);


                break;
            case 2:
                name = "Prof. J. Katti";
                phnum = "tel:9766625746";
                displayDialog1(item,phnum,name);


                break;
          /*  case 11:
                name="Prof Santvana Gudhade";
                phnum="tel:8380095194";
                displayDialog1(item,phnum,name);


                break;
            case 12:
                name="Dr.Jayant Umale";
                phnum="tel:9226094961";
                displayDialog1(item,phnum,name);


                break;
            case 13:
                name="Prof S S Deshmukh";
                phnum="tel:9226094981";
                displayDialog1(item,phnum,name);


                break;
            case 14:
                name="Prof Rahul Patil";
                phnum="tel:9226094975";
                displayDialog1(item,phnum,name);


                break;
            case 15:
                name="Prof S S Sambare";
                phnum="tel:9226094964";
                displayDialog1(item,phnum,name);


                break;
            */
        }
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                spinner.setSelection(0);
            }
        }, 1800);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
