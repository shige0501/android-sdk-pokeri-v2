package net.buildbox.pokeri.provider_contacts;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {
    private static final String PHONE_NUMBER = "0120345678";

    private Cursor mCursor = null;

    // クエリで取得する項目
    private String[] CONTACTS_PROJECTION = new String[]{
        ContactsContract.CommonDataKinds.Phone._ID,
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityPermissionsDispatcher.readContactsWithPermissionCheck(this);
    }

    @NeedsPermission({Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_CONTACTS})
    public void readContacts() {
        // 連絡先の情報取得
        ContentResolver resolver = getContentResolver();
        mCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            CONTACTS_PROJECTION, null, null, null);
        if (mCursor != null) {
            SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_2,
                mCursor,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER},
                new int[]{android.R.id.text1, android.R.id.text2}, 0);

            ListView contactsView = findViewById(R.id.contacts_view);
            contactsView.setAdapter(adapter);
        }
    }

    @Override
    protected void onDestroy() {
        if (mCursor != null) {
            mCursor.close();
            mCursor = null;
        }
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ContentValues values = new ContentValues();

        switch (item.getItemId()) {
            case R.id.action_insert: // 連絡先の追加
                Cursor cursor = getContentResolver().query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    CONTACTS_PROJECTION,
                    ContactsContract.CommonDataKinds.Phone.NUMBER + "='" + PHONE_NUMBER + "'", null, null);
                if (cursor != null && cursor.getCount() > 0) {
                    Toast.makeText(this, "この電話番号は既に登録されています", Toast.LENGTH_SHORT).show();
                    cursor.close();
                    return false;
                }

                // 連絡先の追加
                Uri rawContactUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, values);

                // 名前の設定
                long rawContactId = ContentUris.parseId(rawContactUri);
                values.clear();
                values.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
                values.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, "Androidポケリ");
                getContentResolver().insert(ContactsContract.Data.CONTENT_URI, values);

                // 自宅番号の設定
                Uri phoneUri = Uri.withAppendedPath(rawContactUri, ContactsContract.Contacts.Data.CONTENT_DIRECTORY);
                values.clear();
                values.put(ContactsContract.CommonDataKinds.Phone.TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_HOME);
                values.put(ContactsContract.CommonDataKinds.Phone.IS_SUPER_PRIMARY, 1);
                values.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE);
                values.put(ContactsContract.CommonDataKinds.Phone.NUMBER, PHONE_NUMBER);
                getContentResolver().insert(phoneUri, values);

                ListView contactsView = findViewById(R.id.contacts_view);
                SimpleCursorAdapter adapter = (SimpleCursorAdapter) contactsView.getAdapter();
                adapter.notifyDataSetChanged();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @NeedsPermission({Manifest.permission.WRITE_CONTACTS, Manifest.permission.READ_CONTACTS})
    void onReadContactsDenied() {
        Toast.makeText(this, "連絡先を書き込む権限がありません", Toast.LENGTH_SHORT).show();
    }
}
