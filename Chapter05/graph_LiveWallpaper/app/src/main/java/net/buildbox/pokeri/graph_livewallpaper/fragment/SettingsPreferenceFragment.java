package net.buildbox.pokeri.graph_livewallpaper.fragment;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import net.buildbox.sample.graph_livewallpaper.R;

public class SettingsPreferenceFragment extends PreferenceFragment {

    public SettingsPreferenceFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // プリファレンス画面の設定
        addPreferencesFromResource(R.xml.settings_pref);
    }
}
