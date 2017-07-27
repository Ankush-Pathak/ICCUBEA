package iccubea.iccubea2017.com.iccubea;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Akshay on 22/07/17.
 */

public class TabbedPageAdapterForMap extends FragmentPagerAdapter {

    int tabCnt;

    public TabbedPageAdapterForMap(FragmentManager fm , int numberOFTabs) {
        super(fm);
        this.tabCnt = numberOFTabs;
    }
Fragment fragment=null;

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                FragmentReportingArea fragmentReportingArea = new FragmentReportingArea();
                return fragmentReportingArea;
            case 1:
                fragment = new FragmentHowToReach();
                return fragment;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCnt;
    }
}
