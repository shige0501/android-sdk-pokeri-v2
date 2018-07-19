package net.buildbox.pokeri.map_polyline;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMap();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // 線の描画設定
        PolylineOptions options = new PolylineOptions()
            .add(new LatLng(35.689488, 139.691706)) // 東京
            .add(new LatLng(-14.235004, -51.92528)) // ブラジル
            .color(Color.BLUE) // 線の色
            .width(5) // 線の太さ
            .geodesic(true); // 測地線形式の表示

        // 線の描画
        googleMap.addPolyline(options);
    }

    private void initializeMap() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment fragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map_fragment);
        fragment.getMapAsync(this);
    }
}
