package net.buildbox.pokeri.app_imageshare;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // URI形式での画像表示
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            String action = intent.getAction();
            if (bundle != null && action != null && action.equals(Intent.ACTION_SEND)) {
                Object uriString = bundle.get(Intent.EXTRA_STREAM);
                if (uriString != null) {
                    Uri uri = Uri.parse(uriString.toString());

                    if (uri != null) {
                        ImageView shareImageView = findViewById(R.id.share_image_view);
                        shareImageView.setImageURI(uri);
                    }
                }
            }
        }
    }
}
