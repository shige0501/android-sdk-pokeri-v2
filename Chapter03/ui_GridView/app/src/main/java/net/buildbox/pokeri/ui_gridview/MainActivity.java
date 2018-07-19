package net.buildbox.pokeri.ui_gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // グリッドビューにテキスト一覧を表示
        String[] language = {"Basic", "C/C++", "Java", "Ruby", "Python", "JavaScript",
            "Scala", "PHP", "Haskell", "Objective-C", "C#"};
        GridView gridView = (GridView) findViewById(R.id.grid_view);
        ArrayAdapter<String> adapter
            = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, language);
        gridView.setAdapter(adapter);

        // 選択時の画像を指定
        gridView.setSelector(android.R.drawable.alert_light_frame);

        // セルがクリックされた時の通知
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                GridView gv = (GridView) parent;
                Toast.makeText(getApplicationContext(),
                    (String) gv.getItemAtPosition(position),
                    Toast.LENGTH_SHORT).show();
            }
        });
    }
}
