package net.buildbox.pokeri.ui_textsize;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button triggerButton = findViewById(R.id.trigger_button);
        triggerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TextViewのテキストサイズを変更する
                TextView helloView = findViewById(R.id.hello_view);
                helloView.setTextSize(24.0f);
            }
        });
    }
}
