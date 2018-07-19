package net.buildbox.pokeri.ui_spinner;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import net.buildbox.pokeri.ui_spinner.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        final String[] items = {"10代", "20代", "30代", "40代", "50代以上"};

        // アダプタにアイテムを追加
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_spinner_item,
            items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // アダプタの設定
        mBinding.ageSpinner.setAdapter(adapter);
        // スピナーのタイトル設定
        mBinding.ageSpinner.setPrompt("年齢の選択");
        // ポジションの指定
        mBinding.ageSpinner.setSelection(3);

        mBinding.ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                String item = (String) mBinding.ageSpinner.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                    item + " が選択されました", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
