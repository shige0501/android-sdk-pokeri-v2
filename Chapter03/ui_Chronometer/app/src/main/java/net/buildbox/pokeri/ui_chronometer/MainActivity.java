package net.buildbox.pokeri.ui_chronometer;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Chronometer;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // クロノメーターの初期化
        Chronometer chronometer = findViewById(R.id.chronometer);
        chronometer.setBase(SystemClock.elapsedRealtime());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Chronometer chronometer = findViewById(R.id.chronometer);

        switch (item.getItemId()) {
            case R.id.menu_start:
                chronometer.start();
                return true;
            case R.id.menu_stop:
                chronometer.stop();
                Toast.makeText(this, "time: " + chronometer.getText(),
                    Toast.LENGTH_SHORT).show();
                chronometer.setBase(SystemClock.elapsedRealtime());
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
