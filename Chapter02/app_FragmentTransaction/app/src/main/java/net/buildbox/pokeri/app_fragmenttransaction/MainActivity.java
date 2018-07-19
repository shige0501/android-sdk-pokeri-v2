package net.buildbox.pokeri.app_fragmenttransaction;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.buildbox.pokeri.app_fragmenttransaction.databinding.ActivityMainBinding;
import net.buildbox.pokeri.app_fragmenttransaction.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);
    }

    public void onClick(View view) {
        // フラグメントの動的な追加
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_contents, MainFragment.newInstance(++mCount), MainFragment.TAG);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
