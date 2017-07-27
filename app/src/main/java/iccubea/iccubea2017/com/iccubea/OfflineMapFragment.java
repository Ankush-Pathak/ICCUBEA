package iccubea.iccubea2017.com.iccubea;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import uk.co.senab.photoview.PhotoViewAttacher;


public class OfflineMapFragment extends Fragment {


    public OfflineMapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offline_map, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageViewOfflineMap);

        // Set the Drawable displayed
        Drawable bitmap = getResources().getDrawable(R.drawable.map);
        imageView.setImageDrawable(bitmap);
        // Attach a PhotoViewAttacher, which takes care of all of the zooming functionality.
        PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(imageView);
        return view;
    }


}
