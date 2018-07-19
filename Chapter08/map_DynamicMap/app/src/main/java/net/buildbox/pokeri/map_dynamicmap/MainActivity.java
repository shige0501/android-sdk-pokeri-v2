package net.buildbox.pokeri.map_dynamicmap;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final String MAPFRAGMENT_TAG = SupportMapFragment.class.getSimpleName();
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
    }

    public void showGoogleMap(View view) {
        // Googleマップの動的な追加
        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment fragment = (SupportMapFragment) fragmentManager.findFragmentByTag(MAPFRAGMENT_TAG);
        if (fragment == null) {
            // SupportMapFragmentのオブジェクトを生成
            fragment = SupportMapFragment.newInstance();
            // フラグメントの追加
            fragmentManager.beginTransaction()
                .add(R.id.map_layout, fragment, MAPFRAGMENT_TAG)
                .commitNow();
        }

        fragment.getMapAsync(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST) {
            if (checkPermission()) {
                mGoogleMap.setMyLocationEnabled(true);
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

        // 表示位置(東京駅)の生成
        LatLng posTokyoStation = new LatLng(35.681382, 139.766084);

        // 東京駅を表示
        CameraPosition.Builder builder = new CameraPosition.Builder()
            .target(posTokyoStation)
            .zoom(13.0f)
            .bearing(0)
            .tilt(25.0f);
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(builder.build()));

        // ピンの設定
        MarkerOptions options = new MarkerOptions()
            .position(posTokyoStation)
            .title("東京駅");
        googleMap.addMarker(options);

        // マップ上のクリックイベント処理
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                Toast.makeText(getApplicationContext(),
                    "クリック座標: " + latLng.latitude + ", " + latLng.longitude, Toast.LENGTH_SHORT).show();
            }
        });

        // マップ上の長押しイベント処理
        googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Toast.makeText(getApplicationContext(),
                    "長押し座標: " + latLng.latitude + ", " + latLng.longitude, Toast.LENGTH_SHORT).show();
            }
        });

        // 表示タイプの設定
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (checkPermission()) {
            googleMap.setMyLocationEnabled(true);
        } else {
            requestPermission();
        }
    }

    private boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSIONS_REQUEST);
    }
}
