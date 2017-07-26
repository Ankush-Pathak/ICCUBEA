package iccubea.iccubea2017.com.iccubea;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {
    ImageView pccoe,ieee,iccubea;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);
        pccoe=(ImageView)findViewById(R.id.pccoe);
        ieee=(ImageView)findViewById(R.id.ieee);
        iccubea=(ImageView)findViewById(R.id.iccbea);
        btn = (Button)findViewById(R.id.btnWelcome);
        tv1=(TextView)findViewById(R.id.textView4);
        tv2=(TextView)findViewById(R.id.textView5);
        tv3=(TextView)findViewById(R.id.textView6);
        //tv4=(TextView)findViewById(R.id.textView7);
        tv5=(TextView)findViewById(R.id.textView8);
        tv6=(TextView)findViewById(R.id.textView9);
        tv7=(TextView)findViewById(R.id.textView10);
        btn.setBackgroundResource(R.drawable.next_first);

        Typeface tf= Typeface.createFromAsset(getAssets(), "Humanst521_Lt_BT_Light.ttf");
        tv1.setTypeface(tf);
        //tv4.setTypeface(tf);
        Animation animation = AnimationUtils.loadAnimation(Welcome.this,android.R.anim.fade_in);
        animation.setDuration(5000);


        ieee.startAnimation(animation);
        pccoe.startAnimation(animation);
        iccubea.startAnimation(animation);
        tv1.setAnimation(animation);
        tv2.setAnimation(animation);
        tv3.setAnimation(animation);
        //tv4.setAnimation(animation);
        tv5.setAnimation(animation);
        tv6.setAnimation(animation);
        tv7.setAnimation(animation);
        //Toast.makeText(this,"Please tolerate a few bugs, app is currently in beta testing!",Toast.LENGTH_LONG).show();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Welcome.this,MainActivity.class);
                btn.setBackgroundResource(R.drawable.next_first_animate);
                startActivity(intent);
                finish();
            }
        });



    }
}
