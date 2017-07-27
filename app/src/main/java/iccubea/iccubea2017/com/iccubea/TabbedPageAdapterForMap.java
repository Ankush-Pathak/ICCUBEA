package iccubea.iccubea2017.com.iccubea;



import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.media.session.MediaSessionCompat;
import android.widget.Toast;

/**
 * Created by Akshay on 22/07/17.
 */

public class TabbedPageAdapterForMap extends FragmentPagerAdapter {

    int tabCnt;
    Context reachPCCOE;

    public TabbedPageAdapterForMap(Context mContext, FragmentManager fm , int numberOFTabs) {
        super(fm);
        this.tabCnt = numberOFTabs;
        this.reachPCCOE = mContext;
    }
Fragment fragment=null;
    ConnectivityManager check;// = (ConnectivityManager) reachPCCOE.getSystemService(Context.CONNECTIVITY_SERVICE);


    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                FragmentReportingArea fragmentReportingArea = new FragmentReportingArea();
                return fragmentReportingArea;
            case 1:
                check = (ConnectivityManager) reachPCCOE.getSystemService(Context.CONNECTIVITY_SERVICE);
                if(check.getActiveNetworkInfo() != null)
                {
                    fragment = new FragmentHowToReach();
                    return fragment;
                }

                else {
                    fragment = new OfflineMapFragment();
                    return fragment;
                }



            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCnt;
    }
}
