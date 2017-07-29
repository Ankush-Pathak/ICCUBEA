package iccubea.iccubea2017.com.iccubea;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.SearchView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

import static iccubea.iccubea2017.com.iccubea.R.id.editTextSearch;

public class ProceedingsActivity extends AppCompatActivity {
    SearchView searchViewProceeding;
    ListView listViewProceeding;
    ImageButton imageButtonFilterByDomain;
    Dialog dialogSelectDomain;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ArrayList<Proceeding> proceedingArrayList, proceedingArrayListFull;
    ArrayAdapter arrayAdapter;
    String domainSelected = "";
    String[] domains = { "Show all tracks",
            "Image Processing and Computer Vision",
            "Computer and Communication Security",
            "Databases and Big Data",
            "HPC, Cloud and Social Network Analysis",
            "IOT and Computer Networks",
            "Signal Processing and Applications",
            "Digital Communication",
            "VLSI and Embedded Systems",
            "Control and Automation",
            "Cognitive and Intelligent Systems"};
    ArrayList displayResultList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proceedings);
        initialise();
    }
    void initialise()
    {
        searchViewProceeding = (SearchView)findViewById(R.id.searchViewProceedingSrch);
        searchViewProceeding.setEnabled(false);
        listViewProceeding = (ListView)findViewById(R.id.listViewProceeding);
        imageButtonFilterByDomain = (ImageButton)findViewById(R.id.imageButtonProceedingFilter);
        proceedingArrayList = new ArrayList<>();
        proceedingArrayListFull = new ArrayList<>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference().child("Proceedings");
        databaseReference.keepSynced(true);
        Log.d("Firebase",databaseReference.toString());
        searchViewProceeding.setQueryHint("Enter paper title");
        searchViewProceeding.setIconified(false);
        searchViewProceeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchViewProceeding.setIconified(!searchViewProceeding.isIconified());
            }
        });
        searchViewProceeding.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                searchListView(s);
                return false;
            }
        });

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("Firebase","Listener added");
                for(DataSnapshot ds: dataSnapshot.getChildren()) {
                    proceedingArrayListFull.add(ds.getValue(Proceeding.class));
                    Log.d("Firebase","Added to list, length of list " + proceedingArrayListFull.size());
                }
                proceedingArrayList = new ArrayList<Proceeding>(proceedingArrayListFull);
                Log.d("Firebase","Called searchview");
                searchListView("");
                searchViewProceeding.setEnabled(true);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("Firebase","Error : " + databaseError.getDetails() + " " + databaseError.getMessage());
            }
        });

        imageButtonFilterByDomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDomainDialog();
            }
        });
        listViewProceeding.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showProceedingDialog(position);
            }
        });
    }
    void searchListView(String s)
    {
        if (s.length() < 2)
            s = "";
        displayResultList = new ArrayList<>();
        proceedingArrayList = new ArrayList<>();
        for(Proceeding p : proceedingArrayListFull)
        {
            if(p.getPaperTitle().toLowerCase().contains(s.toLowerCase()) && p.getDomain().toLowerCase().contains(domainSelected.toLowerCase()))
            {
                proceedingArrayList.add(p);
                displayResultList.add("Title : " + p.getPaperTitle());//+ "\nTrack : " + p.getDomain());
            }
        }
        setAdapter();
    }

    void setDomain(int domainIndex)
    {
        domainSelected = domains[domainIndex];
        if(domainIndex == 0)
            domainSelected = "";
        searchListView("");
    }

    void setAdapter()
    {
        arrayAdapter = new ArrayAdapter(ProceedingsActivity.this, android.R.layout.simple_list_item_1,displayResultList);
        listViewProceeding.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    void showDomainDialog()
    {
        ListView listView;
        ArrayList<String> arrayList = new ArrayList<String>();
        for(String s:domains)
        {
            arrayList.add(s);
        }

        ArrayAdapter arrayAdapter;
        dialogSelectDomain = new Dialog(ProceedingsActivity.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
        dialogSelectDomain.setContentView(R.layout.dialog_domain_select);
        dialogSelectDomain.setTitle("Filter by track :");

        listView = (ListView)dialogSelectDomain.findViewById(R.id.listViewDialogSelectDomain);
        arrayAdapter = new ArrayAdapter(ProceedingsActivity.this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setDomain(position);
                dialogSelectDomain.dismiss();
            }
        });
        dialogSelectDomain.show();
    }

    void showProceedingDialog(final int position)
    {
        final Dialog dialog = new Dialog(ProceedingsActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
        dialog.setContentView(R.layout.dialog_view_proceeding);
        dialog.setTitle("Details : ");
        TextView textViewName, textViewPID,textViewTitle,textViewTrack;
        Button buttonOk, buttonViewProceeding;

        textViewName = (TextView)dialog.findViewById(R.id.textViewAuthorName);
        textViewName.append(proceedingArrayList.get(position).getAuthor());

        textViewTrack = (TextView)dialog.findViewById(R.id.textViewDom);
        textViewTrack.append(proceedingArrayList.get(position).getDomain());

        textViewTitle = (TextView)dialog.findViewById(R.id.textViewPaperTitle);
        textViewTitle.append(proceedingArrayList.get(position).getPaperTitle());

        buttonViewProceeding = (Button)dialog.findViewById(R.id.buttonProceedingViewPaper);
        buttonOk = (Button)dialog.findViewById(R.id.btnOkDialog);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonViewProceeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(proceedingArrayList.get(position).getLink()));
                startActivity(intent);
            }
        });
        dialog.show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(ProceedingsActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
