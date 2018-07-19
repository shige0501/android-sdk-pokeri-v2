package net.buildbox.pokeri.device_readsms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.content.PermissionChecker;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
    implements LoaderManager.LoaderCallbacks<Cursor> {
    // SMSのURI
    private static final Uri SMS_URI = Uri.parse("content://sms/");
    private static final int PERMISSIONS_REQUEST = 165;
    private static final String[] PERMISSIONS = {
        Manifest.permission.READ_SMS
    };

    private SimpleCursorAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (PermissionChecker.checkSelfPermission(this, Manifest.permission.READ_SMS) == PackageManager.PERMISSION_GRANTED) {
            initializeSms();
        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSIONS_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initializeSms();
            } else {
                Toast.makeText(this, "SMS読み込みの権限がありません", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // 日付で降順に並べてSMSのデータをCursorLoaderで生成
        return new CursorLoader(this, SMS_URI, null, null, null, "date desc");
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

    private void initializeSms() {
        // リストビューの設定
        mAdapter = new SimpleCursorAdapter(this,
            android.R.layout.simple_expandable_list_item_2,
            null,
            new String[]{"address", "body"},
            new int[]{android.R.id.text1, android.R.id.text2}, 0);
        ListView lv_sms = findViewById(R.id.sms_view);
        lv_sms.setAdapter(mAdapter);

        // Loaderの初期化
        getSupportLoaderManager().initLoader(0, null, this);
    }
}
