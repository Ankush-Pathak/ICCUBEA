package iccubea.iccubea2017.com.iccubea;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

import android.view.View;
import android.view.ViewGroup;
public class Guidelines1 extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


  //  BottomNavigationView bottomNavigationView;
   // BottomBar mbottomBar;
  BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines1);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
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

                    intent = new Intent(Guidelines1.this,TrackYourPaperTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_CMT)
                {
                    intent = new Intent(Guidelines1.this,CmtLogin.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);

                }
                else if(item.getItemId() == R.id.navigation_button_Location)
                {
                    //CheckIn checkIn = new CheckIn();
                    intent = new Intent(Guidelines1.this,ActivityReachPCCOE.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() == R.id.navigation_button_About)
                {
                    intent = new Intent(Guidelines1.this,AboutTabbed.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                else if(item.getItemId() ==R.id.navigation_button_Instruction)
                {
                    intent = new Intent(Guidelines1.this,Guidelines1.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0,0);
                }
                return true;
            }
        });

        /*
        mbottomBar = BottomBar.attach(this,savedInstanceState);
        mbottomBar.setItemsFromMenu(R.menu.bottom_navigation_main, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(@IdRes int menuItemId) {
                Intent intent;
                if(menuItemId == R.id.navigation_button_TrackVenue)
                {

                  intent = new Intent(Guidelines1.this,TrackYourPaper.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
                else if(menuItemId == R.id.navigation_button_CMT)
                {
                    intent = new Intent(Guidelines1.this,CmtLogin.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);

                }
                else if(menuItemId == R.id.navigation_button_Location)
                {
                    //CheckIn checkIn = new CheckIn();
                    intent = new Intent(Guidelines1.this,CheckIn.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
                else if(menuItemId == R.id.navigation_button_Instruction)
                {
                    /*intent = new Intent(Guidelines1.this,Guidelines1.class);
                    startActivity(intent);
                    overridePendingTransition(0,0);
                }
                else if(menuItemId == R.id.navigation_button_About)
                {
                    intent = new Intent(Guidelines1.this,About.class);
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
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

    }

/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guidelines1, menu);
        return true;
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_guidelines1, container, false);
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position)
            {
                case 0: BlankFragment1 blankFragment1 = new BlankFragment1();
                    return blankFragment1;
                case 1: BlankFragment2 blankFragment2 = new BlankFragment2();
                    return blankFragment2;
                case 2: BlankFragment3 blankFragment3 = new BlankFragment3();
                    return blankFragment3 ;
            }
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "INSTRUCTIONS FOR AUTHOR";
                case 1:
                    return "PRESENTATION GUIDELINES";
                case 2:
                    return "IMPORTANT NOTICE";
            }
            return null;
        }
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Guidelines1.this,MainActivity.class);
        //intent.putExtra("key",1);

        startActivity(intent);
        finish();
    }
}
