package net.buildbox.pokeri.device_calllog;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
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
    private static final int PERMISSIONS_REQUEST = 758;
    private static final String[] PERMISSIONS = {
        Manifest.permission.READ_CALL_LOG
    };

    private SimpleCursorAdapter mAdapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (PermissionChecker.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED) {
            initializeLoader();
        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSIONS_REQUEST);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initializeLoader();
            } else {
                Toast.makeText(this, "電話アクセスの権限がありません", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // 通話履歴をCursorLoaderで日付の降順で生成
        return new CursorLoader(this,
            CallLog.Calls.CONTENT_URI,
            null,
            null,
            null,
            CallLog.Calls.DEFAULT_SORT_ORDER);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

    private void initializeLoader() {
        // リストビューの設定
        mAdapter = new SimpleCursorAdapter(this,
            android.R.layout.simple_expandable_list_item_2,
            null,
            new String[]{CallLog.Calls.NUMBER, CallLog.Calls.CACHED_NAME},
            new int[]{android.R.id.text1, android.R.id.text2}, 0);
        ListView callLogView = findViewById(R.id.call_log_view);
        callLogView.setAdapter(mAdapter);

        // Loaderの初期化
        getSupportLoaderManager().initLoader(0, null, this);
    }
}
