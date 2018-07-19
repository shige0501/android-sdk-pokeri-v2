package net.buildbox.sample.ui_toastorigin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button originToastButton = findViewById(R.id.origin_toast_button);
        originToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // カスタムビューの読み込み
                LayoutInflater layoutInflater = getLayoutInflater();
                View customView = layoutInflater.inflate(
                    R.layout.toast_origin, (ViewGroup) findViewById(R.id.root_view));
                // トーストの生成
                Toast orgToast = Toast.makeText(view.getContext(), "", Toast.LENGTH_LONG);
                // トーストの表示位置の設定
                orgToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                // カスタムビューの設定
                orgToast.setView(customView);
                // トーストの表示
                orgToast.show();
            }
        });
    }
}
