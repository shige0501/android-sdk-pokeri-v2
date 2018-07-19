package net.buildbox.pokeri.ui_popupmenu;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import net.buildbox.pokeri.ui_popupmenu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);
    }

    public void showPopupMenu(View v) {
        // ポップアップメニューの生成
        PopupMenu popupMenu = new PopupMenu(this, v);

        // XMLのメニューリソースを設定
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());

        // ポップアップメニューがクリックされた時の処理を行う
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item1:
                    case R.id.menu_item2:
                    case R.id.menu_item3:
                        Toast.makeText(
                            getApplicationContext(),
                            item.getTitle() + " の選択",
                            Toast.LENGTH_SHORT).show();
                        return true;
                    default:
                        break;
                }
                return false;
            }
        });

        // ポップアップメニューの表示
        popupMenu.show();
    }
}
