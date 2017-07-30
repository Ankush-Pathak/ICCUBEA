package iccubea.iccubea2017.com.iccubea;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GuidelinePresenter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guildline_presenter);
        BottomNavigationView bottomNavigationView;

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavViewGuide);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;

                if(item.getItemId() == R.id.navigation_button_TrackVenue)
                {

                    intent = new Intent(GuidelinePresenter.this,TrackYourPaperTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_CMT)
                {
                    intent = new Intent(GuidelinePresenter.this,CmtLogin.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);

                }
                else if(item.getItemId() == R.id.navigation_button_Location)
                {
                    //CheckIn checkIn = new CheckIn();
                    intent = new Intent(GuidelinePresenter.this,ActivityReachPCCOE.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_Instruction)
                {
                    intent = new Intent(GuidelinePresenter.this,GuidelinePresenter.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_About)
                {
                    intent = new Intent(GuidelinePresenter.this,AboutTabbed.class);
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
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
