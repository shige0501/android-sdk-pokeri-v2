package net.buildbox.pokeri.map_polygon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMap();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // ポリゴンの描画
        PolygonOptions options = new PolygonOptions()
            .addAll(createRectangle(new LatLng(70, 100), 10, 10)) // 描画座標
            .addHole(createRectangle(new LatLng(75, 90), 3, 3)) // 抜き取る場所
            .strokeColor(Color.BLACK) // 線の設定
            .strokeWidth(4); // 線の幅
        googleMap.addPolygon(options);
    }

    private List<LatLng> createRectangle(LatLng center, double width, double height) {
        return Arrays.asList(
            new LatLng(center.latitude - height, center.longitude - width),
            new LatLng(center.latitude - height, center.longitude + width),
            new LatLng(center.latitude + height, center.longitude + width),
            new LatLng(center.latitude + height, center.longitude - width),
            new LatLng(center.latitude - height, center.longitude - width));
    }

    private void initializeMap() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment fragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map_fragment);
        fragment.getMapAsync(this);
    }
}
