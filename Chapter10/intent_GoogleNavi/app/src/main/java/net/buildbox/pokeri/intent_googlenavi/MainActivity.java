package net.buildbox.pokeri.intent_googlenavi;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button navigationButton = findViewById(R.id.navigation_button);
        navigationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Googleマップナビで広島駅までのルート案内を呼び出す
                // この呼び出し方法は公式には公表されていません
                Uri uri = Uri.parse("google.navigation:q=広島駅");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }
}
