package net.buildbox.pokeri.device_asynctask;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import net.buildbox.pokeri.device_asynctask.dialog.CountDownDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartAsyncTask(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag(CountDownDialog.TAG) == null) {
            CountDownDialog dialog = new CountDownDialog();
            dialog.show(fragmentManager, CountDownDialog.TAG);
        }
    }
}
