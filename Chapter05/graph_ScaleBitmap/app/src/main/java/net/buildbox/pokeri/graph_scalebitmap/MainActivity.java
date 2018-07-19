package net.buildbox.pokeri.graph_scalebitmap;

import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.buildbox.pokeri.graph_scalebitmap.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        Bitmap normalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        // 縮小したビットマップの作成
        Bitmap scaleBitmap = Bitmap.createScaledBitmap(normalBitmap,
            normalBitmap.getWidth() / 2,
            normalBitmap.getHeight() / 2,
            true);
        binding.normalBitmap.setImageBitmap(normalBitmap);
        binding.scaleBitmap.setImageBitmap(scaleBitmap);
    }
}
