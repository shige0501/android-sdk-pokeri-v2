package net.buildbox.pokeri.ui_contextmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // コンテキストメニューの登録
        ListView fruitsListView = findViewById(R.id.fruits_list);
        registerForContextMenu(fruitsListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_main, menu);
    }

    // コンテキストメニューが選択された時の処理
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu1:
            case R.id.menu2:
            case R.id.menu3:
                Toast.makeText(this, item.getTitle() + "の選択", Toast.LENGTH_SHORT).show();
                return true;
            default:
                break;
        }

        return super.onContextItemSelected(item);
    }
}
