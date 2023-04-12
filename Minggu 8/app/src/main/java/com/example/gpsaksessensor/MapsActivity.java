package com.example.gpsaksessensor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.gpsaksessensor.databinding.ActivityMapsBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    final private int REQUEST_COARSE_ACCESS = 123;
    boolean permissionGranted = false;
    private GoogleMap gMap;
    SupportMapFragment supportMapFragment;
    FusedLocationProviderClient Client;
    LocationManager locationManager;
    LocationListener locationListener;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
        Client = LocationServices.getFusedLocationProviderClient(this);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        locationListener = new myLocationListener();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
           getCurrentLocation();
        }else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
    }

    private void getCurrentLocation(){
        @SuppressLint("MissingPermission")
        Task<Location> task = Client.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {

                if (location != null){
                    supportMapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(@NonNull GoogleMap googleMap) {

                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                            MarkerOptions options = new MarkerOptions().position(latLng).title("I Am There");
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20));
                            googleMap.addMarker(options);

                        }
                    });
                }
            }
        });
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
////            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_COARSE_ACCESS);
////            return;
//
//        } else {
//            permissionGranted = false;
//        }
//        if (permissionGranted) {
//            locationManager.removeUpdates(locationListener);
//        }
//    }

//    @SuppressLint("MissingPermission")
//    @Override
//    protected void onResume() {
//        super.onResume();
//        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
//                locationListener);
//        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0,
//                locationListener);
//
//    }

    /**
     * Manipulates the map once available.x
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == 44) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                permissionGranted = true;
                getCurrentLocation();
            } else {
                permissionGranted = false;
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions,
                    grantResults);
        }

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        gMap = googleMap;

        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                markerOptions.title(latLng.latitude + " : "+latLng.longitude);
                gMap.clear();
                gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15));
                gMap.addMarker(markerOptions);
            }
        });

    }

//    private class myLocationListener implements LocationListener{
//
//        @Override
//        public void onLocationChanged(@NonNull Location location) {
//            Toast.makeText(getBaseContext(), "Location Changed : Lat:  \"" +
//                    "+ location.getLatitude() + \n" + " \" Lng: \n"
//                    + location.getLongitude(), Toast.LENGTH_SHORT).show();
//            LatLng p = new LatLng((int) (location.getLatitude()), (int)(location.getLongitude()));
//            mMap.moveCamera(CameraUpdateFactory.newLatLng(p));
//            mMap.animateCamera(CameraUpdateFactory.zoomTo(7));
//        }
//
//        @Override
//        public void onProviderEnabled(@NonNull String provider) {
//            Toast.makeText(getBaseContext(), provider + " Enable",
//                    Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onProviderDisabled(@NonNull String provider) {
//            Toast.makeText(getBaseContext(), provider + " Disabled",
//                    Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            String statusString = "";
//            switch (status){
//                case LocationProvider.AVAILABLE:
//                    statusString = "Available";
//                case LocationProvider.OUT_OF_SERVICE:
//                    statusString = "Out of Service";
//                case LocationProvider.TEMPORARILY_UNAVAILABLE:
//                    statusString = "Temporarily Unavailable";
//            }
//            Toast.makeText(getBaseContext(), provider + " ",
//                    Toast.LENGTH_SHORT).show();
//        }
//    }
}