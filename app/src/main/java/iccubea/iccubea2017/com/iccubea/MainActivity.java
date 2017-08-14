package iccubea.iccubea2017.com.iccubea;
/*Coded by Alohamora, the to be greatest programmers earth has seen*/

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;

import android.graphics.Typeface;
import android.os.Build;
import android.os.CountDownTimer;


import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;
import com.roughike.bottombar.OnTabSelectedListener;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Period;


import at.grabner.circleprogress.CircleProgressView;
import at.grabner.circleprogress.TextMode;


public class MainActivity extends AppCompatActivity {
    int flag=0,frag_flag = 1;
    RelativeLayout relativeLayout;
    BlankFragment fragment;
    FragmentManager fragmentManager;
    Button btnMoveUp, buttonProceeding,buttonFeedback, buttonSchedule;
    int height;
    double offset;
    TextView textView;
    Typeface typeface;
    CircleProgressView circleProgressViewSec, circleProgressViewHrs, circleProgressViewMin, circleProgressViewDays;
    DateTime dateTime, dateTimeNow;
    Period periodSec, periodHrs, periodMin, periodDays;
    CountDownTimer countDownTimerSec, countDownTimerHrs, countDownTimerMin, countDownTimerDays;
    int spinnerBarWidth, spinnerTextSize,contourSize,i;
    boolean enableFeedback = false, enableProceeding = false, countDownDone = false;
    DatabaseReference databaseReference;


    BottomBar mbottomBar;
    BottomNavigationView bottomNavigationView;
    int maxHeight,maxWidth;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        System.gc();
        setContentView(R.layout.activity_main);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;

                if(item.getItemId() == R.id.navigation_button_CMT)
                {
                    intent = new Intent(MainActivity.this,CmtLogin.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);

                }
                else if(item.getItemId() == R.id.navigation_button_TrackVenue)
                {

                    intent = new Intent(MainActivity.this,TrackYourPaperTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_Location)
                {
                    //CheckIn checkIn = new CheckIn();
                    intent = new Intent(MainActivity.this,ActivityReachPCCOE.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_Instruction)
                {
                    intent = new Intent(MainActivity.this,GuidelinePresenter.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_About)
                {
                    intent = new Intent(MainActivity.this,AboutTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);


                }
                return true;
            }
        });

        flag=0;
        initialise();
//        circleProgressViewMin.setLayoutParams(new RelativeLayout.LayoutParams(pxToDp((int)maxWidth/2),  pxToDp((int)maxHeight/2)));
//        circleProgressViewHrs.setLayoutParams(new RelativeLayout.LayoutParams(pxToDp((int)maxWidth/4),  pxToDp((int)maxHeight/4)));
        //updateDays();
        updateSeconds();
       // btnMoveUp.setOnClickListener(MainActivity.this);
//        btnMoveUp.setOnClickListener(MainActivity.this);
        /*if(getIntent().getExtras()!=null)
        {
            final Bundle bundle = getIntent().getExtras();
            i=bundle.getInt("key");
            if(i==1)
                moveButton();
        }*/
        //sharedPreferences=getSharedPreferences("home", MODE_PRIVATE);
    }


    void initialise() {
        System.gc();
        //fragment = new BlankFragment();
        //fragmentManager = getSupportFragmentManager();

        typeface = Typeface.createFromAsset(getAssets(), "AGENCYR.TTF");
        height = this.getResources().getDisplayMetrics().heightPixels;
        offset = this.getResources().getDisplayMetrics().densityDpi;
        offset = offset * 0.55;

       //  btnMoveUp = (Button) findViewById(R.id.);
       // btnMoveUp.setText("^");
        circleProgressViewSec = (CircleProgressView) findViewById(R.id.circularProgressSec);
        dateTime = new DateTime(2017, 8, 17,10, 30);
        dateTimeNow = DateTime.now();
        //circleProgressViewHrs = (CircleProgressView) findViewById(R.id.circularProgressHrs);
        //circleProgressViewMin = (CircleProgressView) findViewById(R.id.circularProgressMin);
        //circleProgressViewMin.setVisibility(View.INVISIBLE);
        //circleProgressViewHrs.setVisibility(View.INVISIBLE);
       // circleProgressViewDays = (CircleProgressView) findViewById(R.id.circularProgressDays);
        circleProgressViewSec.setTextTypeface(typeface);
//        circleProgressViewMin.setTextTypeface(typeface);
//        circleProgressViewDays.setTextTypeface(typeface);
        spinnerBarWidth = circleProgressViewSec.getBarWidth() - 20;
        spinnerTextSize = circleProgressViewSec.getTextSize() + 45;
        contourSize = 3;
        textView = (TextView) findViewById(R.id.textView2);
        textView.setTypeface(typeface);
        buttonProceeding = (Button)findViewById(R.id.buttonMainAcitivitProceeding);
        buttonFeedback = (Button)findViewById(R.id.buttonMainAcitivtyFeedback);
        buttonSchedule = (Button)findViewById(R.id.buttonMainActivityICCUBEASchedule);
        relativeLayout=(RelativeLayout)findViewById(R.id.relativeLayoutMain);
        databaseReference.keepSynced(true);
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren())
                {
                    Log.d("Firebase","Keys : " + ds.getKey() + " value : " + ds.getValue().toString());
                    if(ds.getKey().equals("enableFeedback") && ds.getValue(Boolean.class)){
                        Log.d("Firebase","Button now visible");
                        buttonFeedback.setVisibility(View.VISIBLE);
                        enableFeedback = true;}

                    if(ds.getKey().equals("enableProceedings") && ds.getValue(Boolean.class)){
                        Log.d("Firebase","Setting proceeding");
                        enableProceeding = true;
                        updateSeconds();
                        if(countDownDone) {
                            circleProgressViewSec.setText("Tap here for proceedings");
                            circleProgressViewSec.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MainActivity.this, ProceedingsActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });

                        }
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
/*
        btnMoveUp = (Button) findViewById(R.id.btnMoveUp);
        btnMoveUp.setText("^");
        circleProgressViewSec = (CircleProgressView) findViewById(R.id.circularProgressSec);
        dateTime = new DateTime(2017, 8, 17,9, 05);
        dateTimeNow = DateTime.now();
        circleProgressViewHrs = (CircleProgressView) findViewById(R.id.circularProgressHrs);
        circleProgressViewMin = (CircleProgressView) findViewById(R.id.circularProgressMin);
        circleProgressViewDays = (CircleProgressView) findViewById(R.id.circularProgressDays);
        circleProgressViewSec.setTextTypeface(typeface);
        circleProgressViewMin.setTextTypeface(typeface);
        circleProgressViewHrs.setTextTypeface(typeface);
        circleProgressViewDays.setTextTypeface(typeface);
        spinnerBarWidth = circleProgressViewSec.getBarWidth() - 25;
        spinnerTextSize = circleProgressViewSec.getTextSize() + 45;
        contourSize = 3;
        textView = (TextView) findViewById(R.id.textView2);
        textView.setTypeface(typeface);
        buttonProceeding = (Button)findViewById(R.id.buttonMainAcitivitProceeding);
*/

/*

        relativeLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    relativeLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    //noinspection deprecation
                    relativeLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                maxHeight = circleProgressViewSec.getHeight();
                maxWidth = circleProgressViewSec.getWidth();
            }
        });
*/
        if(!enableFeedback)
            buttonFeedback.setVisibility(View.GONE);
        buttonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPre = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
                boolean submittedFeedback = sharedPre.getBoolean("hasSubmittedFeedback",false);
                if(submittedFeedback)
                    Toast.makeText(MainActivity.this,"You have already submitted feedback",Toast.LENGTH_LONG).show();
                else {
                    Intent intent = new Intent(MainActivity.this, FeedbackActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        buttonSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showScheduleDialog();
            }
        });

    }

    /*void moveButton() {
        btnMoveUp.setVisibility(View.INVISIBLE);
        fragmentManager.beginTransaction().replace(R.id.mainactivity_fragment,fragment).commit();
        flag=1;
    }*/



    void updateSeconds() {


        circleProgressViewSec.setBarColor(Color.parseColor("#009688"));
        circleProgressViewSec.setMaxValue(59);
        circleProgressViewSec.setValueAnimated(100);
        circleProgressViewSec.setMaxValue(60);
        //circleProgressViewSec.setValueAnimated(100);
        //circleProgressViewSec.setText(String.valueOf(period.getDays()));
        //circleProgressViewSec.setTextSize(spinnerTextSize);
        circleProgressViewSec.setShowTextWhileSpinning(false);
        circleProgressViewSec.setTextMode(TextMode.TEXT);
        //circleProgressViewSec.setTextTypeface(typeface);
        circleProgressViewSec.setContourSize(contourSize);
        circleProgressViewSec.setRimWidth(0);
        circleProgressViewSec.setBarWidth(spinnerBarWidth);
        dateTimeNow = DateTime.now();
        if (!dateTimeNow.isAfter(dateTime)) {
            countDownTimerSec = new CountDownTimer(dateTime.getMillis(), 1000) {
                @Override
                public void onTick(long l) {
                    dateTimeNow = DateTime.now();
                    periodSec = new Period(dateTimeNow, dateTime);
                    periodHrs = new Period(dateTimeNow, dateTime);
                    periodMin = new Period(dateTimeNow, dateTime);
                    periodDays = new Period(dateTimeNow, dateTime);
                    if(periodSec.getSeconds() == 0 && periodDays.getDays() == 0 && periodHrs.getHours() == 0)
                    {
                        circleProgressViewSec.setValue(0);
                        countDownTimerSec.cancel();
                        //countDownTimerDays.cancel();
                        //countDownTimerHrs.cancel();
                        //countDownTimerMin.cancel();
                        countDownDone = true;
                        startActivity(new Intent(MainActivity.this,MainActivity.class));
                        finish();
                        TextView textView = (TextView)findViewById(R.id.textView2);
                        textView.setText("Welcome to ICCUBEA 2017!");
                        textView.setTextColor(Color.parseColor("#ff7043"));
                        if(enableProceeding)
                        {
                            circleProgressViewSec.setText("Tap here for proceedings");
                            circleProgressViewSec.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent intent = new Intent(MainActivity.this,ProceedingsActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            });
                        }
                        else
                        {
                            circleProgressViewSec.setText("Watch this space for proceedings");
                        }

                    }
                    if(periodSec.getSeconds() == 60 || periodSec.getSeconds() == 59)
                    {
                        String text=String.valueOf(Days.daysBetween(dateTimeNow, dateTime).getDays()) + " Days : "
                                +String.valueOf(periodHrs.getHours()) + " Hrs : "
                                +String.valueOf(periodMin.getMinutes()) + " Min : "
                                +String.valueOf(periodSec.getSeconds()) + " Sec";
                        circleProgressViewSec.setText(text);
                        circleProgressViewSec.setValue(periodSec.getSeconds());
                    }
                    else {


                        String text = String.valueOf(Days.daysBetween(dateTimeNow, dateTime).getDays()) + " Days : "
                                + String.valueOf(periodHrs.getHours()) + " Hrs : "
                                + String.valueOf(periodMin.getMinutes()) + " Min : "
                                + String.valueOf(periodSec.getSeconds()) + " Sec";
                        circleProgressViewSec.setText(text);
                        circleProgressViewSec.setValueAnimated(periodSec.getSeconds());
                    }
                    //if (periodSec.getSeconds() == 59) {
                        //circleProgressViewHrs.setText(String.valueOf(periodHrs.getHours()) + "hrs");

                       // circleProgressViewHrs.setValueAnimated(periodHrs.getHours());
                        //circleProgressViewMin.setText(String.valueOf(periodMin.getMinutes()) + "min");
                        //circleProgressViewMin.setValueAnimated(periodMin.getMinutes());
                        //circleProgressViewDays.setText(String.valueOf(Days.daysBetween(dateTimeNow, dateTime).getDays()) + "days");
                       // circleProgressViewDays.setValueAnimated(Days.daysBetween(dateTimeNow, dateTime).getDays());
                   // }
                }

                @Override
                public void onFinish()
                {

                    Toast.makeText(getApplicationContext(),"Conference concluded on 17th of August",Toast.LENGTH_LONG).show();
                }
            }.start();
        }
        else
        {
//            circleProgressViewDays.setValue(0);
//            circleProgressViewDays.setText("0days");
            circleProgressViewSec.setValue(0);
            circleProgressViewSec.setText("0 Day : 0 Hrs : 0 Min : 0 Sec");
//            circleProgressViewMin.setValue(0);
//            circleProgressViewMin.setText("0min");
//            circleProgressViewHrs.setValue(0);
//            circleProgressViewHrs.setText("0hrs");
            TextView textView = (TextView)findViewById(R.id.textView2);
            textView.setText("Welcome to ICCUBEA 2017!");
            textView.setTextColor(Color.parseColor("#ff7043"));
            frag_flag = 0;
            countDownDone = true;
            if(enableProceeding)
            {
                circleProgressViewSec.setText("Tap here for proceedings");
                circleProgressViewSec.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this,ProceedingsActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
            else
            {
                circleProgressViewSec.setText("Watch this space for proceedings");
            }

            //moveButton();
        }
        //circleProgressViewSec.setValueAnimated(0,60,60000);
    }


    /*void updateHrs() {


        circleProgressViewHrs.setBarColor(Color.parseColor("#ff7043"));
        circleProgressViewHrs.setMaxValue(24);
        //circleProgressViewSec.setValueAnimated(100);
        //circleProgressViewSec.setText(String.valueOf(period.getDays()));
        circleProgressViewHrs.setTextSize(spinnerTextSize);
        circleProgressViewHrs.setShowTextWhileSpinning(false);
        circleProgressViewHrs.setTextMode(TextMode.TEXT);
        circleProgressViewHrs.setContourSize(contourSize);
        circleProgressViewHrs.setRimWidth(0);
        circleProgressViewHrs.setBarWidth(spinnerBarWidth);
        if (!dateTimeNow.isAfter(dateTime)) {
            countDownTimerHrs = new CountDownTimer(dateTime.getMillis(), 1000 * 60 * 60) {
                @Override
                public void onTick(long l) {
                    dateTimeNow = DateTime.now();
                    periodHrs = new Period(dateTimeNow, dateTime);
                    //circleProgressViewHrs.setText(String.valueOf(periodHrs.getHours()) + "hrs");
                    circleProgressViewHrs.setValueAnimated(periodHrs.getHours());

                }

                @Override
                public void onFinish() {

                }
            }.start();
        } else {
//            circleProgressViewDays.setValue(0);
//            circleProgressViewDays.setText("0days");
//            circleProgressViewSec.setValue(0);
//            circleProgressViewSec.setText("0sec");
//            circleProgressViewMin.setValue(0);
//            circleProgressViewMin.setText("0min");
//            circleProgressViewHrs.setValue(0);
//            circleProgressViewHrs.setText("0hrs");
           TextView textView = (TextView)findViewById(R.id.textView2);
            textView.setText("Welcome to ICCUBEA 2017!");
            textView.setTextColor(Color.parseColor("#ff7043"));
            frag_flag = 0;
            //moveButton();
        }
        //circleProgressViewSec.setValueAnimated(0,60,60000);
    }*/

    /*void updateMin() {

        circleProgressViewMin.setBarColor(Color.parseColor("#ff7043"));
        circleProgressViewMin.setMaxValue(60);
        //circleProgressViewSec.setValueAnimated(100);
        //circleProgressViewSec.setText(String.valueOf(period.getDays()));
        circleProgressViewMin.setTextSize(spinnerTextSize);
        circleProgressViewMin.setShowTextWhileSpinning(false);
        circleProgressViewMin.setTextMode(TextMode.TEXT);
        circleProgressViewMin.setContourSize(contourSize);
        circleProgressViewMin.setRimWidth(0);
        circleProgressViewMin.setBarWidth(spinnerBarWidth);
        if (!dateTimeNow.isAfter(dateTime)) {
            countDownTimerMin = new CountDownTimer(dateTime.getMillis(), 1000 * 30) {
                @Override
                public void onTick(long l) {
                    dateTimeNow = DateTime.now();
                    periodMin = new Period(dateTimeNow, dateTime);
                    //circleProgressViewMin.setText(String.valueOf(periodMin.getMinutes()) + "min");
                    circleProgressViewMin.setValueAnimated(periodMin.getMinutes());

                }

                @Override
                public void onFinish() {

                }
            }.start();
        } else {
//            circleProgressViewDays.setValue(0);
//            circleProgressViewDays.setText("0days");
//            circleProgressViewSec.setValue(0);
//            circleProgressViewSec.setText("0sec");
//            circleProgressViewMin.setValue(0);
//            circleProgressViewMin.setText("0min");
//            circleProgressViewHrs.setValue(0);
//            circleProgressViewHrs.setText("0hrs");
            TextView textView = (TextView)findViewById(R.id.textView2);
            textView.setText("Welcome to ICCUBEA 2017!");
            textView.setTextColor(Color.parseColor("#ff7043"));
            frag_flag = 0;
            //moveButton();
        }
        //circleProgressViewSec.setValueAnimated(0,60,60000);
    }*/
/*
    void updateDays() {

        circleProgressViewDays.setBarColor(Color.parseColor("#ff7043"));
        circleProgressViewDays.setMaxValue(10);
        //circleProgressViewSec.setValueAnimated(100);
        //circleProgressViewSec.setText(String.valueOf(period.getDays()));
        circleProgressViewDays.setTextSize(spinnerTextSize);
        circleProgressViewDays.setShowTextWhileSpinning(false);
        circleProgressViewDays.setTextMode(TextMode.TEXT);
        circleProgressViewDays.setContourSize(contourSize);
        circleProgressViewDays.setRimWidth(0);
        circleProgressViewDays.setBarWidth(spinnerBarWidth);
        dateTimeNow = DateTime.now();
        periodDays = new Period(dateTimeNow, dateTime);

        /*circleProgressViewDays.setText(String.valueOf(Days.daysBetween(dateTimeNow, dateTime).getDays()));
        circleProgressViewDays.setValueAnimated(Days.daysBetween(dateTimeNow, dateTime).getDays());

        */
   /*if (!dateTimeNow.isAfter(dateTime)) {

            countDownTimerDays = new CountDownTimer(dateTime.getMillis(), 1000 * 60 * 60) {
                @Override
                public void onTick(long l) {
                    dateTimeNow = DateTime.now();
                    periodDays = new Period(dateTimeNow, dateTime);
                    circleProgressViewDays.setText(String.valueOf(Days.daysBetween(dateTimeNow, dateTime).getDays()) + "days");
                    circleProgressViewDays.setValueAnimated(Days.daysBetween(dateTimeNow, dateTime).getDays());

                }

                @Override
                public void onFinish() {

                }
            }.start();
        } else {
            circleProgressViewDays.setValue(0);
            circleProgressViewDays.setText("0days");
            circleProgressViewSec.setValue(0);
            circleProgressViewSec.setText("0sec");
            circleProgressViewMin.setValue(0);
            circleProgressViewMin.setText("0min");
            circleProgressViewHrs.setValue(0);
            circleProgressViewHrs.setText("0hrs");
            TextView textView = (TextView)findViewById(R.id.textView2);
            textView.setText("Welcome to cPGCON 2016!");
            textView.setTextColor(Color.parseColor("#ff7043"));
            frag_flag = 0;
            moveButton();
        }

        circleProgressViewSec.setValueAnimated(0,60,60000);
    }*/



    /*@Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnAbout:

                //Toast.makeText(this, "In btnMoveUp", Toast.LENGTH_LONG).show();
                if (btnMoveUp.getText() == "^") {
                    //moveButton();
                    btnMoveUp.setVisibility(View.INVISIBLE);
                    break;
                }
                countDownTimerSec.cancel();

        }

    }*/

    void showScheduleDialog()
    {
        final Dialog dialog = new Dialog(MainActivity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
        dialog.setContentView(R.layout.dialog_iccubea_schedule);
        dialog.setTitle("ICCUBEA 2017 Schedule");
        Button buttonOk;
        buttonOk = (Button)dialog.findViewById(R.id.buttonDialogScheduleOk);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        if(flag == 1 && frag_flag == 1)
        {
            removeFragment();
            flag=0;
        }
        else {
            finish();
            super.onBackPressed();
        }


    }
    public void removeFragment()
    {
        fragmentManager.beginTransaction().remove(fragment).commit();
        btnMoveUp.setVisibility(View.VISIBLE);
    }



}
