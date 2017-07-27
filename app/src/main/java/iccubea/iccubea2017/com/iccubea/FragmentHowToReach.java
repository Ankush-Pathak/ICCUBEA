package iccubea.iccubea2017.com.iccubea;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class FragmentHowToReach extends Fragment {

    private GoogleMap mMap;
   // TrackGPS trackGPS;
    ArrayList markerPoints= new ArrayList();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        SupportMapFragment mapFragment;

        View view = inflater.inflate(R.layout.fragment_how_to_reach, container, false);



            if (getActivity().getSupportFragmentManager().findFragmentById(R.id.mapFragment) == null) {
                mapFragment = SupportMapFragment.newInstance();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.mapFragment, mapFragment).commit();
            } else
                mapFragment = (SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.mapFragment);
            mapFragment.getMapAsync(new OnMapReadyCallback() {
                @Override
                public void onMapReady(GoogleMap googleMap) {
                    mMap = googleMap;
                    // trackGPS = new TrackGPS(FragmentHowToReach.this);


                    LatLng iccubea2017 = new LatLng(18.651371, 73.761701);

                    Marker marker = mMap.addMarker(new MarkerOptions().position(iccubea2017).title("ICCUBEA 2017"));
                    marker.showInfoWindow();
                    float zoomLevel = 16.0f;

                    mMap.animateCamera(CameraUpdateFactory.newLatLng(iccubea2017));

                    mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(iccubea2017, zoomLevel));

               /* Polyline line = mMap.addPolyline(new PolylineOptions()
                        .add(new LatLng(51.5, -0.1), new LatLng(40.7, -74.0))
                        .width(5)
                        .color(Color.RED));*/


                }


            });

        {
            Intent intent = new Intent(getActivity(),map_zoom.class);
            startActivity(intent);

        }

        return view;
    }





    //@Override
    /*public void onMapReady(GoogleMap googleMap) {


    }*/
}
