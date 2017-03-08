package jorgeortiz.primerentregatesis.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.maps.SupportMapFragment;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import jorgeortiz.primerentregatesis.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private static final int MY_LOCATION_REQUEST_CODE = 1 ;
    //private int i = 0;


    @Override
    public void onCreate(Bundle savedInstanceState){
        System.out.println("Aplicacion de GPS");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        LocationManager milocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            System.out.println("No tiene Permiso");
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                //milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_LOCATION_REQUEST_CODE);
                //milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            }
        }else{
            System.out.println("Ya tiene Permiso");
            milocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_LOCATION_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        //Toast.makeText(this, "Inicio Mapa ", Toast.LENGTH_LONG).show();
    }


    public void onLocationChanged(Location loc) {
        mMap.clear();
        //System.out.println("Cambiando Ubicacion");
        //loc.getLatitude();
        //loc.getLongitude();
        //String coordenadas = "Mis coordenadas son: " + "Latitud = " + loc.getLatitude() + "Longitud = " + loc.getLongitude();
        //System.out.println(coordenadas);
        //Toast.makeText(this, "Coordenadas " + loc.getLatitude() + loc.getLongitude(), Toast.LENGTH_LONG).show();
        LatLng actual = new LatLng(loc.getLatitude(), loc.getLongitude());
        //mMap.addMarker(new MarkerOptions().position(actual).title("Ubicacion Actual " + i));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(actual, 15));
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(actual, 20);
        mMap.animateCamera(cameraUpdate);
        mMap.addMarker(new MarkerOptions().position(actual).title("UbicacionActual"));
        //mMap.getUiSettings().setZoomControlsEnabled(false);
        //Toast.makeText(this, "Inicio Mapa " + i, Toast.LENGTH_LONG).show();
        //i++;


    }

    public void onProviderDisabled(String provider) {
        //System.out.println("GPS Desactivado");
    }

    public void onProviderEnabled(String provider) {
        //System.out.println("GPS Activado");
    }

    public void onStatusChanged(String provider, int status, Bundle extras){}

}
