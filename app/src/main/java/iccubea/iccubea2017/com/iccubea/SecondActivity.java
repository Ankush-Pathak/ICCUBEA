package iccubea.iccubea2017.com.iccubea;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.gc();
        setContentView(R.layout.activity_second);
        //for title
        Typeface tf = Typeface.createFromAsset(getAssets(), "Museo300-Regular.otf");
        TextView tv = (TextView) findViewById(R.id.abt_pccoe_title);
        tv.setTypeface(tf);

        //for content
        Typeface tf2 = Typeface.createFromAsset(getAssets(), "Museo100-Regular.otf");
        TextView tv2 = (TextView) findViewById(R.id.infoPccoe);
        tv2.setTypeface(tf2);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,About.class);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        finish();
    }
}