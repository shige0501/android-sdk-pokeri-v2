package net.buildbox.pokeri.device_positiontoaddress;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Geocoder geocoder = new Geocoder(this, Locale.JAPAN);
        // 東京の座標を指定して住所を取得する
        try {
            List<Address> addressList = geocoder.getFromLocation(35.689488, 139.691706, 1);
            // 住所の取得に成功したかチェック
            if (!addressList.isEmpty()) {
                Address address = addressList.get(0);
                StringBuilder addressName = new StringBuilder();
                String buf;
                for (int i = 0; (buf = address.getAddressLine(i)) != null; i++) {
                    addressName.append(buf).append("\n");
                }
                // 取得した住所をトーストで表示
                Toast.makeText(this, "取得した住所: " + addressName, Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
