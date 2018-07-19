package net.buildbox.pokeri.map_location.location;

import android.location.Location;

import com.google.android.gms.maps.LocationSource;

public class LocalLocationSource implements LocationSource {
    @Override
    public void activate(OnLocationChangedListener onLocationChangedListener) {
        // 位置情報の設定(ディズニーランド)
        Location location = new Location("LocalLocation");
        location.setLatitude(35.632547); // 緯度
        location.setLongitude(139.88133); // 経度
        location.setAccuracy(100); // 精度
        onLocationChangedListener.onLocationChanged(location);
    }

    @Override
    public void deactivate() {
    }
}
