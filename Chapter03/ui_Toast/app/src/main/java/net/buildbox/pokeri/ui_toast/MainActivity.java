package net.buildbox.pokeri.ui_toast;

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

    public void onShowToast(View view) {
        // トーストの表示
        Toast.makeText(this,
            "ボタンがクリックされました",
            Toast.LENGTH_LONG).show();
    }
}
