package net.buildbox.pokeri.map_showmap;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        SupportMapFragment fragment = (SupportMapFragment) fragmentManager.findFragmentById(R.id.map_fragment);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // 表示位置(東京駅)の生成
        LatLng posTokyoStation = new LatLng(35.681382, 139.766084);

        // 東京駅を表示
        CameraPosition.Builder builder = new CameraPosition.Builder()
            .target(posTokyoStation)
            .zoom(13.0f)
            .bearing(0)
            .tilt(25.0f);
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(builder.build()));
    }
}
