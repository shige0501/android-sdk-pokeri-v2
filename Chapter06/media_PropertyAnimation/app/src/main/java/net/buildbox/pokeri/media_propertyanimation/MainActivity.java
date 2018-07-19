package net.buildbox.pokeri.media_propertyanimation;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView helloView = findViewById(R.id.hello_view);
        helloView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // TextViewをフェードアウトするアニメーションの実施
                ObjectAnimator.ofFloat(view, "alpha", 0.0f).start();
            }
        });
    }
}
