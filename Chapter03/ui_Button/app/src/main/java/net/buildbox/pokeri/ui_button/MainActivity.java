package net.buildbox.pokeri.ui_button;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onSampleButton(View view) {
        Toast.makeText(this, "ボタンがクリックされました", Toast.LENGTH_LONG).show();
    }
}
