package net.buildbox.pokeri.media_tweenanimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView appIconView = findViewById(R.id.app_icon);

        appIconView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // アニメーションの設定
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.sample);
                // アニメーション後の状態を保持
                animation.setFillAfter(true);
                // アニメーションの開始
                view.startAnimation(animation);
            }
        });
    }
}
