package net.buildbox.pokeri.storage_clipboard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_copy = findViewById(R.id.btn_copy);
        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText et_target = findViewById(R.id.et_target);
                // 設定するテキストを含んだClipDataのアイテムを生成
                ClipData.Item item = new ClipData.Item(et_target.getText());

                // MIMETYPEの設定
                String[] mimeType = new String[1];
                mimeType[0] = ClipDescription.MIMETYPE_TEXT_PLAIN;

                // ClipDataの生成
                ClipData clipData = new ClipData(new ClipDescription("text_plain", mimeType), item);

                // ClipDataをClipManagerに設定
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                if (clipboardManager != null) {
                    clipboardManager.setPrimaryClip(clipData);
                }
            }
        });

        Button btn_toastClipboard = findViewById(R.id.btn_toastClipboard);
        btn_toastClipboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                if (clipboardManager != null) {
                    // ClipDataの取得
                    ClipData clipData = clipboardManager.getPrimaryClip();
                    // アイテムの取得
                    ClipData.Item item = clipData.getItemAt(0);
                    // テキストの取得
                    String toastText = item.getText().toString();
                    Toast.makeText(getApplicationContext(), "Text: " + toastText, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
