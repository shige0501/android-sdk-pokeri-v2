package net.buildbox.pokeri.ui_preferencefragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.buildbox.pokeri.ui_preferencefragment.activity.SettingPreferenceActivity;
import net.buildbox.pokeri.ui_preferencefragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);
    }

    public void onButtonClick(View view) {
        Intent intent = new Intent(SettingPreferenceActivity.createIntent(this));
        startActivity(intent);
    }
}
