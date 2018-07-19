package net.buildbox.pokeri.app_dialogfragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.buildbox.pokeri.app_dialogfragment.databinding.ActivityMainBinding;
import net.buildbox.pokeri.app_dialogfragment.fragment.SampleDialogFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);
    }

    public void onClick(View view) {
        SampleDialogFragment dlgFragment = new SampleDialogFragment();
        dlgFragment.show(getSupportFragmentManager(), SampleDialogFragment.TAG);
    }
}
