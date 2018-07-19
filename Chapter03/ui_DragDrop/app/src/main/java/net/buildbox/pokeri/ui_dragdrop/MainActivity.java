package net.buildbox.pokeri.ui_dragdrop;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import net.buildbox.pokeri.ui_dragdrop.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // タッチリスナーの登録
        binding.dragView.setOnTouchListener(this);

        binding.dropView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                if (event.getAction() == DragEvent.ACTION_DROP) {
                    ClipData clipData = event.getClipData();
                    for (int i = 0; i < clipData.getItemCount(); i++) {
                        // ドラッグ開始時に渡したClipDataのテキストを表示
                        ClipData.Item item = clipData.getItemAt(i);
                        Toast.makeText(getApplicationContext(),
                            item.coerceToText(getApplicationContext()),
                            Toast.LENGTH_SHORT).show();
                    }
                }

                return false;
            }
        });
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        view.performClick();
        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                // ドラッグ処理の開始
                ClipData clipData = ClipData.newPlainText("label", "ドロップしました!");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    view.startDragAndDrop(clipData, new View.DragShadowBuilder(view), null, 0);
                } else {
                    view.startDrag(clipData, new View.DragShadowBuilder(view), null, 0);
                }
                return true;
        }
        return false;
    }
}
