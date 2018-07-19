package net.buildbox.pokeri.app_listfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;

import net.buildbox.pokeri.app_listfragment.fragment.ColorListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // リストフラグメントの作成
        String[] strColors = {"red", "blue", "green", "yellow", "orange"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this, android.R.layout.simple_list_item_1, strColors);

        ColorListFragment fragment = ColorListFragment.newInstance();
        fragment.setListAdapter(adapter);

        // フラグメントの動的な追加
        getSupportFragmentManager().beginTransaction()
            .add(R.id.main_contents, fragment, ColorListFragment.TAG)
            .commit();
    }
}
