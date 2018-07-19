package net.buildbox.pokeri.media_frameanimation;

import android.databinding.DataBindingUtil;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import net.buildbox.pokeri.media_frameanimation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // 背景の設定
        mBinding.animationView.setBackgroundResource(R.drawable.pic_animation);

        AnimationDrawable animationDrawable = (AnimationDrawable) mBinding.animationView.getBackground();
        animationDrawable.start();
    }
}
