package net.buildbox.pokeri.ui_listpopupwindow;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import net.buildbox.pokeri.ui_listpopupwindow.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private ListPopupWindow mListPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initializePopup();

        mBinding.popupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ポップアップの表示
                mListPopup.show();
            }
        });
    }

    private void initializePopup() {
        // リストポップアップウィンドウの生成
        mListPopup = new ListPopupWindow(this);

        // Adapterの設定
        String[] fruits = {"Apple", "Orange", "Grape", "Mango"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, fruits);
        mListPopup.setAdapter(adapter);

        // 表示位置の設定
        mListPopup.setVerticalOffset(20);
        mListPopup.setHorizontalOffset(100);

        // リスト上のアイテムがクリックされた時の処理を行うリスナー登録
        mListPopup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // リスト上のアイテムがクリックされた時の処理
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position,
                                    long id) {
                String fruit = (String) adapter.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), fruit + "が選択されました。", Toast.LENGTH_SHORT).show();
                mListPopup.dismiss();
            }
        });

        // 紐付けるビューの設定
        mListPopup.setAnchorView(mBinding.popupButton);
    }
}
