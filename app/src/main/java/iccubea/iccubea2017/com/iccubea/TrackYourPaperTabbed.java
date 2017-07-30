package iccubea.iccubea2017.com.iccubea;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class TrackYourPaperTabbed extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_track_your_paper_tabbed);


        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);


        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;

                if(item.getItemId() == R.id.navigation_button_TrackVenue)
                {

                    intent = new Intent(TrackYourPaperTabbed.this,TrackYourPaperTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_CMT)
                {
                    intent = new Intent(TrackYourPaperTabbed.this,CmtLogin.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);


                }
                else if(item.getItemId() == R.id.navigation_button_Location)
                {
                    intent = new Intent(TrackYourPaperTabbed.this,CheckIn.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);

                }
                else if(item.getItemId() == R.id.navigation_button_Instruction)
                {
                    intent = new Intent(TrackYourPaperTabbed.this,Guidelines1.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_About)
                {
                    intent = new Intent(TrackYourPaperTabbed.this,AboutTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        //intent.putExtra("key",1);

        startActivity(intent);
        finish();
        super.onBackPressed();
    }


}
