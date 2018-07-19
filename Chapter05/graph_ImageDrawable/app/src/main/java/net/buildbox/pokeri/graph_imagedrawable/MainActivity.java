package net.buildbox.pokeri.graph_imagedrawable;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import net.buildbox.pokeri.graph_imagedrawable.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Drawable形式で読み込み
        BitmapDrawable drawable = (BitmapDrawable) ContextCompat.getDrawable(this, R.drawable.dog);
        if (drawable != null) {
            drawable.setAlpha(50);
            binding.imageTarget.setImageDrawable(drawable);
        }
    }
}
