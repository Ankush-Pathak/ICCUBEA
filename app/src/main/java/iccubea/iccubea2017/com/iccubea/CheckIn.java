package iccubea.iccubea2017.com.iccubea;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import android.os.Handler;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import uk.co.senab.photoview.PhotoViewAttacher;


import uk.co.senab.photoview.PhotoViewAttacher;


public class CheckIn extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Button call;
    ArrayList<String> categories;
    ArrayAdapter<String> dataadapter;
    Spinner spinner;
    Handler handler;
    PhotoViewAttacher photoViewAttacher;
    ImageView imageView;
    BottomNavigationView bottomNavigationView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_in);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;

                if(item.getItemId() == R.id.navigation_button_TrackVenue)
                {

                    intent = new Intent(CheckIn.this,TrackYourPaperTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_CMT)
                {
                    intent = new Intent(CheckIn.this,CmtLogin.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);


                }
                else if(item.getItemId() == R.id.navigation_button_Location)
                {
                    intent = new Intent(CheckIn.this,ActivityReachPCCOE.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_Instruction)
                {
                    intent = new Intent(CheckIn.this,Guidelines1.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_About)
                {
                    intent = new Intent(CheckIn.this,AboutTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                return true;
            }
        });



        categories=new ArrayList<String>();
        categories.add("Contact Us");
        categories.add("Incharge 1 : Dr.Sonali Patil");
        categories.add("Incharge 2 : Mrs.Smita Chavan");
        categories.add("Incharge 3 : Mr.Ketan Desale");
        dataadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories);
        dataadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner=(Spinner)findViewById(R.id.spinner2);
        spinner.setAdapter(dataadapter);
        spinner.setOnItemSelectedListener(this);
        imageView = (ImageView) findViewById(R.id.imageView3);

        // Set the Drawable displayed
        Drawable bitmap = getResources().getDrawable(R.drawable.checkin_map);
        imageView.setImageDrawable(bitmap);
		//
        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        photoViewAttacher = new PhotoViewAttacher(imageView);

        }


        @Override
        public void onBackPressed() {

            //intent.putExtra("key",1);
            Intent intent = new Intent(CheckIn.this, MainActivity.class);
            intent.putExtra("key",1);

            startActivity(intent);
            finish();
            super.onBackPressed();
        }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item=parent.getItemAtPosition(position).toString();
        switch (position)
        {
            case 0:TextView tv1=(TextView)parent.getChildAt(0);
                Typeface tf1= Typeface.createFromAsset(getAssets(),"Museo100-Regular.otf");
                tv1.setTypeface(tf1);
                tv1.setTextSize(21);
                if(tv1!=null)
                {
                    tv1.setTextColor(Color.RED);
                }
                break;
            case 1:Toast.makeText(parent.getContext(), "Calling " + item, Toast.LENGTH_SHORT).show();
                call("tel:9226094990");
                break;
            case 2:Toast.makeText(parent.getContext(), "Calling " + item, Toast.LENGTH_SHORT).show();
                call("tel:9503998794");
                break;
            case 3:Toast.makeText(parent.getContext(), "Calling " + item, Toast.LENGTH_SHORT).show();
                call("tel:9960859064");
                break;
        }
        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                spinner.setSelection(0);
            }
        },1500);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

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
                Toast.makeText(this, "Unable to make call", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }


        }
    }

