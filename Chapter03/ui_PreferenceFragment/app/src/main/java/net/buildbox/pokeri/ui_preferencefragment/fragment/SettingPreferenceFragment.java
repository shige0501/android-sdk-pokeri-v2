package net.buildbox.pokeri.ui_preferencefragment.fragment;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import net.buildbox.pokeri.ui_preferencefragment.R;

public class SettingPreferenceFragment extends PreferenceFragment {

    public SettingPreferenceFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // プリファレンス画面の設定
        addPreferencesFromResource(R.xml.settings_pref);
    }
}
