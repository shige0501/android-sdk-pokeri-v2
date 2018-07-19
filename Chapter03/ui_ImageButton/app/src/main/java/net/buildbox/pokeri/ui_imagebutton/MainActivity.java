package net.buildbox.pokeri.ui_imagebutton;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import net.buildbox.pokeri.ui_imagebutton.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);
    }

    public void onButtonClick(View view) {
        Toast.makeText(this, "イメージ付きボタンのクリック", Toast.LENGTH_LONG).show();
    }
}
