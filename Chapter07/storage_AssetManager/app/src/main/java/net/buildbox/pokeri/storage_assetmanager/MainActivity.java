package net.buildbox.pokeri.storage_assetmanager;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AssetManagerの取得
        AssetManager assetManager = getAssets();
        try {
            // 『data』ディレクトリ内のファイル一覧を取得
            String[] fileList = assetManager.list("data");
            TextView tv_list1 = findViewById(R.id.data_filelist);
            showList(tv_list1, fileList);

            // 『data/gif』ディレクトリ内のファイル一覧取得
            fileList = assetManager.list("data/gif");
            TextView tv_list2 = findViewById(R.id.gif_filelist);
            showList(tv_list2, fileList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ファイルの一覧を展開
    public void showList(TextView tv, String[] list) {
        for (String filePath : list) {
            tv.setText(String.format("%s%s\n", tv.getText(), filePath));
        }
    }
}
