package net.buildbox.pokeri.storage_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import net.buildbox.pokeri.storage_sqlite.database.DBCursorLoader;
import net.buildbox.pokeri.storage_sqlite.database.SQLiteDBHelper;

public class MainActivity extends AppCompatActivity
    implements LoaderManager.LoaderCallbacks<Cursor> {
    private SimpleCursorAdapter mAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リストビューの設定
        mAdapter = new SimpleCursorAdapter(this,
            android.R.layout.simple_expandable_list_item_2,
            null,
            new String[]{"book", "type"},
            new int[]{android.R.id.text1, android.R.id.text2}, 0);
        ListView bookListView = findViewById(R.id.book_list_view);
        bookListView.setAdapter(mAdapter);

        // Loaderの初期化
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        SQLiteDBHelper dbHelper = SQLiteDBHelper.getInstance(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        switch (item.getItemId()) {
            case R.id.action_insert:
                // 挿入処理
                values.put("book", "Androidポケリ");
                values.put("type", "test");
                db.insert(SQLiteDBHelper.DB_TABLE, null, values);

                getSupportLoaderManager().restartLoader(0, null, this);
                break;
            case R.id.action_update:
                // 更新処理
                values.put("book", "Android SDK技術書");
                db.update(SQLiteDBHelper.DB_TABLE, values, "book = 'Androidポケリ'", null);

                getSupportLoaderManager().restartLoader(0, null, this);
                break;
            case R.id.action_delete:
                // 削除処理
                db.delete(SQLiteDBHelper.DB_TABLE, "book like 'Android%'", null);

                getSupportLoaderManager().restartLoader(0, null, this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new DBCursorLoader(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
