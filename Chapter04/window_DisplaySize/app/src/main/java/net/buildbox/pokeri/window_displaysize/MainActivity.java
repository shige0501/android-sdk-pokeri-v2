package net.buildbox.pokeri.window_displaysize;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.Toast;

import net.buildbox.pokeri.window_displaysize.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        showDisplaySize();
    }

    private void showDisplaySize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        String message = "幅: "
            + displayMetrics.widthPixels
            + ", 高さ: "
            + displayMetrics.heightPixels;

        mBinding.displaySizeView.setText(message);
    }
}
