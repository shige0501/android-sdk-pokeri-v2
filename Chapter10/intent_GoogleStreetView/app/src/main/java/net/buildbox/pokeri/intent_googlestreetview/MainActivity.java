package net.buildbox.pokeri.intent_googlestreetview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button streetViewButton = findViewById(R.id.street_view_button);
        streetViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 広島市内のストリートビューを呼び出す
                Uri uri = Uri.parse("google.streetview:cbll=34.000600, 132.083868");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setPackage("com.google.android.apps.maps");
                startActivity(intent);
            }
        });
    }
}
