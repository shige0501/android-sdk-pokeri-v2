package net.buildbox.pokeri.map_location;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import net.buildbox.pokeri.map_location.location.LocalLocationSource;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final int PERMISSIONS_REQUEST = 317;
    private static final String[] PERMISSIONS = {
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private GoogleMap mGoogleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMap();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST) {
            if (checkPermission()) {
                mGoogleMap.setMyLocationEnabled(true);
                setLocation();
            } else {
                Toast.makeText(this, "現在地を扱う権限がありません", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap = googleMap;

        // 現在位置の表示を有効化
        if (checkPermission()) {
            googleMap.setMyLocationEnabled(true);
            setLocation();
        } else {
            requestPermission();
        }
    }

    private void initializeMap() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment fragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map_fragment);
        fragment.getMapAsync(this);
    }

    private void setLocation() {
        // 現在位置を設定
        mGoogleMap.setLocationSource(new LocalLocationSource());
    }

    private boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSIONS_REQUEST);
    }
}
