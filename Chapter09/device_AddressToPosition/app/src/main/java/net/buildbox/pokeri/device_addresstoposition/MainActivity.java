package net.buildbox.pokeri.device_addresstoposition;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            // 東京ディズニーランドの位置を取得
            List<Address> addressList = geocoder.getFromLocationName("千葉県浦安市舞浜１−１", 1);
            // 取得した1件目の位置情報を取得
            Address address = addressList.get(0);
            double lat = address.getLatitude(); // 緯度
            double lng = address.getLongitude(); // 経度
            // 位置情報をトーストで表示
            Toast.makeText(this, "Latitude: " + lat + ", Longitude: " + lng, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
