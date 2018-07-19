package net.buildbox.pokeri.ui_radiobutton;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import net.buildbox.pokeri.ui_radiobutton.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.colorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.white_radio_button:
                        mBinding.rootContainer.setBackgroundColor(Color.WHITE);
                        break;
                    case R.id.red_radio_button:
                        mBinding.rootContainer.setBackgroundColor(Color.RED);
                        break;
                    case R.id.yellow_radio_button:
                        mBinding.rootContainer.setBackgroundColor(Color.YELLOW);
                        break;
                }
            }
        });
    }
}
