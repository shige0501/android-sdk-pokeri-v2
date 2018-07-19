package net.buildbox.pokeri.intent_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int SUB_REQUEST = 919;
    private static final int INTENT_REQUEST = 619;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button activityButton = findViewById(R.id.activity_button);
        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 別Activityの呼び出し
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });

        Button returnButton = findViewById(R.id.return_button);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 値を返すActivityの呼び出し
                Intent intent = new Intent(getApplicationContext(), ReturnActivity.class);
                startActivityForResult(intent, SUB_REQUEST);
            }
        });

        Button intentButton = findViewById(R.id.intent_button);
        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intentを返すActivityの呼び出し
                Intent intent = new Intent(getApplicationContext(), IntentActivity.class);
                startActivityForResult(intent, INTENT_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SUB_REQUEST:
                Toast.makeText(this, "戻り値: " + resultCode, Toast.LENGTH_SHORT).show();
                break;
            case INTENT_REQUEST:
                Toast.makeText(this, "戻り値: " + data.getStringExtra("return_text"), Toast.LENGTH_SHORT).show();
                break;
            default:
                super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
