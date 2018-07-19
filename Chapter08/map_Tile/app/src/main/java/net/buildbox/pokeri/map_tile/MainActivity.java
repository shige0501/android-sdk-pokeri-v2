package net.buildbox.pokeri.map_tile;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;

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
        // マップを非表示に設定
        googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);

        // 技術評論社のロゴをタイル表示
        TileProvider tileProvider = new UrlTileProvider(146, 27) {
            URL url;
            @Override
            public URL getTileUrl(int x, int y, int zoom) {
                try {
                    // 技術評論社のロゴをURL指定
                    url = new URL("http://image.gihyo.co.jp/assets/templates/gihyojp2007/image/gihyo_logo.png");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

                return url;
            }
        };

        // マップ上にオーバーレイ表示する
        googleMap.addTileOverlay(new TileOverlayOptions().tileProvider(tileProvider));
    }
}
