package iccubea.iccubea2017.com.iccubea;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Ankush on 21-07-2017.
 */

public class ICCUBEA extends MultiDexApplication {
    @Override
    public void onCreate()
    {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        Log.d("Firebase","Persistence enabled");
    }
    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }
}
