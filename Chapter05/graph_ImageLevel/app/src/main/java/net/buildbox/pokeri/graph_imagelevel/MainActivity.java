package net.buildbox.pokeri.graph_imagelevel;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;

import net.buildbox.pokeri.graph_imagelevel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 画像リソースの読み込み
        mBinding.imageTarget.setImageResource(R.drawable.flight_level);

        mBinding.levelToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                // トグルの選択状態をみて画像レベルの切替
                if (checked) {
                    mBinding.imageTarget.setImageLevel(1);
                } else {
                    mBinding.imageTarget.setImageLevel(0);
                }
            }
        });
    }
}
