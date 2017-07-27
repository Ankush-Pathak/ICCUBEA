package iccubea.iccubea2017.com.iccubea;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class map_zoom extends Activity {
    ImageView imageView;
    PhotoViewAttacher photoViewAttacher;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom_map);
        imageView = (ImageView) findViewById(R.id.imageView2);

        // Set the Drawable displayed
        Drawable bitmap = getResources().getDrawable(R.drawable.map);
        imageView.setImageDrawable(bitmap);

        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        photoViewAttacher = new PhotoViewAttacher(imageView);

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("key",1);
        startActivity(intent);
        finish();
    }
}