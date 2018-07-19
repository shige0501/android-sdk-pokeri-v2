package net.buildbox.pokeri.app_activitylifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "call onCreate()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "call onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "call onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "call onResume()");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "call onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "call onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "call onDestroy().");
        super.onDestroy();
    }
}
