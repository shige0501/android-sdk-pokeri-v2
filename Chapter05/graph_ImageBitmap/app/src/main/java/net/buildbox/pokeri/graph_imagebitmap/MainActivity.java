package net.buildbox.pokeri.graph_imagebitmap;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.buildbox.pokeri.graph_imagebitmap.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // ビットマップ形式で読み込み
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        binding.imageTarget.setImageBitmap(bitmap);
    }
}
