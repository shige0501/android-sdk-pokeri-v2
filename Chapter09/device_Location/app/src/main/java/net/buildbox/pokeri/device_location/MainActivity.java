package net.buildbox.pokeri.device_location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity
    implements LocationListener {

    private LocationManager mLocationManager = null;
    private String mProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criteriaインスタンスの生成
        Criteria criteria = new Criteria();
        // 緯度の指定
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        // 電力消費の設定
        criteria.setPowerRequirement(Criteria.POWER_LOW);

        // ロケーションプロバイダの取得
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (mLocationManager != null) {
            mProvider = mLocationManager.getBestProvider(criteria, true);
        }

        // ロケーションプロバイダ名をトーストで表示
        Toast.makeText(this, "provider = " + mProvider, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        MainActivityPermissionsDispatcher.locationUpdatesWithPermissionCheck(this);
    }

    @Override
    protected void onPause() {
        // 位置情報要求の解除
        mLocationManager.removeUpdates(this);
        super.onPause();
    }

    @SuppressLint("MissingPermission")
    @NeedsPermission({Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION})
    public void locationUpdates() {
        // 位置情報の更新
        if (mProvider != null) {
            mLocationManager.requestLocationUpdates(mProvider, 0, 0, this);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        // 緯度・経度の情報をトーストで表示
        Toast.makeText(this,
            "Location: " + location.getLatitude() + ", " + location.getLongitude(),
            Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
    }

    @Override
    public void onProviderEnabled(String s) {
    }

    @Override
    public void onProviderDisabled(String s) {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied({Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION})
    void onLocationPermissionDenied() {
        Toast.makeText(this, "位置情報の権限がありません", Toast.LENGTH_SHORT).show();
    }
}
