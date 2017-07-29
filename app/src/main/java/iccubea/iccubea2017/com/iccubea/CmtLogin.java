package iccubea.iccubea2017.com.iccubea;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import android.os.*;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

//import java.util.logging.Handler;


public class CmtLogin extends AppCompatActivity {
    WebView cmt;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    Handler handler;

   // BottomBar mbottomBar;
  //  BottomNavigationView bottomNavigationView;
    private GoogleApiClient client;

    BottomNavigationView bottomNavigationView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmt_login);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;

                if(item.getItemId() == R.id.navigation_button_TrackVenue)
                {

                    intent = new Intent(CmtLogin.this,TrackYourPaperTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_CMT)
                {
                    /*intent = new Intent(MainActivity.this,CmtLogin.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                    */
                }
                else if(item.getItemId() == R.id.navigation_button_Location)
                {
                    //CheckIn checkIn = new CheckIn();
                    intent = new Intent(CmtLogin.this,ActivityReachPCCOE.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_Instruction)
                {
                    intent = new Intent(CmtLogin.this,GuidelinePresenter.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_About)
                {
                    intent = new Intent(CmtLogin.this,AboutTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                return true;
            }
        });


       /* mbottomBar = BottomBar.attach(this,savedInstanceState);
        mbottomBar.setItemsFromMenu(R.menu.bottom_navigation_main, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(@IdRes int menuItemId) {
                Intent intent;
                if(menuItemId == R.id.navigation_button_TrackVenue)
                {

                   intent = new Intent(CmtLogin.this,TrackYourPaper.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
                else if(menuItemId == R.id.navigation_button_CMT)
                {
                  /*  intent = new Intent(TrackYourPaper.this,CmtLogin.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);

                }
                else if(menuItemId == R.id.navigation_button_Location)
                {
                    //CheckIn checkIn = new CheckIn();
                    intent = new Intent(CmtLogin.this,CheckIn.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
                else if(menuItemId == R.id.navigation_button_Instruction)
                {
                    intent = new Intent(CmtLogin.this,Guidelines1.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
                else if(menuItemId == R.id.navigation_button_About)
                {
                    intent = new Intent(CmtLogin.this,About.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
            }
        });
        mbottomBar.mapColorForTab(0,"#F44366");
        mbottomBar.mapColorForTab(1,"#9C2780");
        mbottomBar.mapColorForTab(2,"#F44366");
        mbottomBar.mapColorForTab(3,"#9C2780");
        mbottomBar.mapColorForTab(4,"#F44366");

        */
        cmt = (WebView) findViewById(R.id.webView);
        cmt.getSettings().setJavaScriptEnabled(true);

        ConnectivityManager check = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        final ProgressDialog progressDialog = new ProgressDialog(CmtLogin.this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(true);
        progressDialog.setIndeterminate(true);


        int flag = 1;


        if (check.getActiveNetworkInfo() != null
                && check.getActiveNetworkInfo().isAvailable()
                && check.getActiveNetworkInfo().isConnected()) {
            flag = 0;

        } else {

            Toast.makeText(CmtLogin.this, "No Active Internet Connection.", Toast.LENGTH_LONG).show();


        }


        if (flag == 0) {


            cmt.loadUrl("https://cmt3.research.microsoft.com/User/Login?ReturnUrl=%2FICCUBEA2017");


           /* while(cmt.getProgress()!=50)
            {
                progressDialog.setProgress(cmt.getProgress());
            }*/
            cmt.setWebViewClient(new WebViewClient() {
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    progressDialog.show();
                }

                public void onPageFinished(WebView view, String url) {
                    progressDialog.dismiss();
                }
            });


        }


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(CmtLogin.this,MainActivity.class);

        //intent.putExtra("key",1);

        startActivity(intent);
        finish();
    }
}


