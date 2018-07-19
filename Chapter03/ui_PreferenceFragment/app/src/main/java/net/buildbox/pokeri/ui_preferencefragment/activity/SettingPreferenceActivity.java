package net.buildbox.pokeri.ui_preferencefragment.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.buildbox.pokeri.ui_preferencefragment.R;

public class SettingPreferenceActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, SettingPreferenceActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_preference);
    }
}
