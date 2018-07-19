package net.buildbox.pokeri.map_overlay;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMap();
    }

    private void initializeMap() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment fragment =
            (SupportMapFragment) fragmentManager.findFragmentById(R.id.map_fragment);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // 東京駅の位置を指定
        LatLng location = new LatLng(35.681382, 139.766084);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 11));

        // 貼り付ける画像の生成
        BitmapDescriptor descriptor =
            BitmapDescriptorFactory.fromResource(android.R.drawable.sym_def_app_icon);

        // オーバーレイの設定
        GroundOverlayOptions options = new GroundOverlayOptions()
            .image(descriptor)
            .anchor(0, 1)
            .position(location, 5000f, 4000f);
        GroundOverlay overlay = googleMap.addGroundOverlay(options);
        overlay.setTransparency(0.4f);
    }
}
