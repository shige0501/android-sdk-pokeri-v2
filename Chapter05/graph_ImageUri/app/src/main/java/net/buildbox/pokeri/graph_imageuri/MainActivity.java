package net.buildbox.pokeri.graph_imageuri;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.buildbox.pokeri.graph_imageuri.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        if (Intent.ACTION_SEND.equals(getIntent().getAction())) {
            Uri uri = null;
            try {
                Bundle bundle = getIntent().getExtras();
                if (bundle != null) {
                    Object streamObject = bundle.get(Intent.EXTRA_STREAM);
                    if (streamObject != null) {
                        uri = Uri.parse(streamObject.toString());
                    }
                }
            } catch (Exception e) { // エラー時の処理を実装してください
                e.printStackTrace();
            }

            if (uri != null) {
                binding.imageTarget.setImageURI(uri);
            }
        }
    }
}
