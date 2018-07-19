package net.buildbox.pokeri.provider_caledar;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity
    implements LoaderManager.LoaderCallbacks<Cursor> {
    private SimpleCursorAdapter mAdapter = null;

    // クエリで取得する項目
    private String[] CALENDAR_PROJECTION = new String[]{
        CalendarContract.Events._ID,
        CalendarContract.Events.TITLE,
        CalendarContract.Events.DESCRIPTION
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdapter = new SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2,
            null,
            new String[]{CalendarContract.Events.TITLE, CalendarContract.Events.DESCRIPTION},
            new int[]{android.R.id.text1, android.R.id.text2}, 0);

        ListView calendarView = findViewById(R.id.calendar_view);
        calendarView.setAdapter(mAdapter);

        // 権限の有効化
        MainActivityPermissionsDispatcher.initializeCalendarPermissionWithPermissionCheck(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                // Loaderの初期化
                getSupportLoaderManager().initLoader(0, null, this);
            }
        } else {
            // Loaderの初期化
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        // カレンダーのイベントをコンテンツプロバイダから取得するCursorLoaderの生成
        return new CursorLoader(this,
            CalendarContract.Events.CONTENT_URI,
            CALENDAR_PROJECTION,
            null,
            null,
            CalendarContract.Events.DTSTART + " desc");
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        // SimpleCursorAdapterの中身を空に設定
        mAdapter.swapCursor(null);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        // カレンダーのイベントを読み込んだデータをSimpleCursorAdapterに設定
        mAdapter.swapCursor(data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                // イベントの追加
                addCalendarEvent();
                return true;

            case R.id.action_update:
                // イベントの更新
                updateCalendarEvent();
                return true;

            case R.id.action_delete:
                // イベントの削除
                deleteCalendarEvent();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @NeedsPermission({Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR})
    public void initializeCalendarPermission() {
        Toast.makeText(this, "カレンダーのアクセス権限が有効になりました", Toast.LENGTH_SHORT).show();
    }

    public void addCalendarEvent() {
        // イベント開始・終了時間の設定
        Calendar calStart = Calendar.getInstance();
        calStart.set(2017, 10, 26, 9, 0);
        long startMillis = calStart.getTimeInMillis();
        Calendar calEnd = Calendar.getInstance();
        calEnd.set(2017, 10, 26, 11, 0);
        long endMillis = calEnd.getTimeInMillis();

        // イベントの登録
        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART, startMillis);
        values.put(CalendarContract.Events.DTEND, endMillis);
        values.put(CalendarContract.Events.EVENT_TIMEZONE, Time.getCurrentTimezone());
        values.put(CalendarContract.Events.TITLE, "Androidポケリ");
        values.put(CalendarContract.Events.DESCRIPTION, "Androidポケリイベント");
        values.put(CalendarContract.Events.CALENDAR_ID, 1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                cr.insert(CalendarContract.Events.CONTENT_URI, values);
            }
        } else {
            cr.insert(CalendarContract.Events.CONTENT_URI, values);
        }

        getSupportLoaderManager().restartLoader(0, null, this);
    }

    @NeedsPermission({Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR})
    public void updateCalendarEvent() {
        // イベントの更新
        ContentResolver cr = getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DESCRIPTION, "Androidポケリイベント更新！");
        values.put(CalendarContract.Events.CALENDAR_ID, 1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                cr.update(CalendarContract.Events.CONTENT_URI,
                    values, CalendarContract.Events.TITLE + " = 'Androidポケリ'", null);
            }
        } else {
            cr.update(CalendarContract.Events.CONTENT_URI,
                values, CalendarContract.Events.TITLE + " = 'Androidポケリ'", null);
        }
        getSupportLoaderManager().restartLoader(0, null, this);
    }

    public void deleteCalendarEvent() {
        // イベントの削除
        ContentResolver cr = getContentResolver();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED) {
                cr.delete(CalendarContract.Events.CONTENT_URI,
                    CalendarContract.Events.TITLE + " = 'Androidポケリ'", null);
            }
        } else {
            cr.delete(CalendarContract.Events.CONTENT_URI,
                CalendarContract.Events.TITLE + " = 'Androidポケリ'", null);
        }

        getSupportLoaderManager().restartLoader(0, null, this);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied({Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR})
    void onCalendarPermissionDenied() {
        Toast.makeText(this, "カレンダーのアクセス権限がありません", Toast.LENGTH_SHORT).show();
    }
}
