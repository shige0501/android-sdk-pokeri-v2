package net.buildbox.pokeri.device_handler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.buildbox.pokeri.device_handler.dialog.CountDownDialog;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onStartCountDown(View view) {
        if (getSupportFragmentManager().findFragmentByTag(CountDownDialog.TAG) == null) {
            // プログレスダイアログの表示
            CountDownDialog dialog = new CountDownDialog();
            dialog.show(getSupportFragmentManager(), CountDownDialog.TAG);
        }
    }
}
