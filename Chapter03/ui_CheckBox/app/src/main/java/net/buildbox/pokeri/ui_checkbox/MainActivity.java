package net.buildbox.pokeri.ui_checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // チェックボックスの状態変化通知
        CheckBox checkState = findViewById(R.id.check_state);
        checkState.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String message = "チェック: " + isChecked;
                Toast.makeText(buttonView.getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
