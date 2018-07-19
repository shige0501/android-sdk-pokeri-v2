package net.buildbox.pokeri.ui_event;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(net.buildbox.pokeri.ui_event.R.layout.activity_main);

        Button eventButton = findViewById(net.buildbox.pokeri.ui_event.R.id.event_button);
        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                    "ボタンクリック", Toast.LENGTH_SHORT).show();
            }
        });

        eventButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(getApplicationContext(),
                    "長押しされました", Toast.LENGTH_SHORT).show();
                // trueを返すと、後続のOnClickイベントがコールバック処理されなくなります
                return true;
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Toast.makeText(getApplicationContext(),
                    "画面タッチから手を離しました", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
