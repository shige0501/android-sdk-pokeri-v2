package net.buildbox.pokeri.app_application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showStartTime(View view) {
        Toast.makeText(this, "アプリ起動時間: " + MyApplication.getStartTime(), Toast.LENGTH_SHORT).show();
    }
}
