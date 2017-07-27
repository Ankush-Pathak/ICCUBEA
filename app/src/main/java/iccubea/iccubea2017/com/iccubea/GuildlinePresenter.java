package iccubea.iccubea2017.com.iccubea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GuildlinePresenter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guildline_presenter);
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("key",1);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}
