package net.buildbox.pokeri.ui_expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 親要素のリスト生成
        ArrayList<HashMap<String, String>> groupData = new ArrayList<>();

        // 親要素の項目生成
        HashMap<String, String> mapGroupItem = new HashMap<>();
        mapGroupItem.put("book", "書籍");

        // 親要素のリストに項目追加
        groupData.add(mapGroupItem);

        // 子要素のリスト生成
        ArrayList<ArrayList<HashMap<String, String>>> childData = new ArrayList<>();

        // 子要素の項目生成
        ArrayList<HashMap<String, String>> childGroup = new ArrayList<>();
        HashMap<String, String> mapChildItem1 = new HashMap<>();
        mapChildItem1.put("book", "Android SDKポケットリファレンス");
        mapChildItem1.put("publish", "技術評論社");
        HashMap<String, String> mapChildItem2 = new HashMap<>();
        mapChildItem2.put("book", "Software Design");
        mapChildItem2.put("publish", "技術評論社");
        HashMap<String, String> mapChildItem3 = new HashMap<>();
        mapChildItem3.put("book", "初めてのAndroid 第3版");
        mapChildItem3.put("publish", "オライリージャパン");

        // 子要素をグループ化
        childGroup.add(mapChildItem1);
        childGroup.add(mapChildItem2);
        childGroup.add(mapChildItem3);

        // 子要素をリストに追加
        childData.add(childGroup);

        // アダプタの生成
        SimpleExpandableListAdapter adapter = new SimpleExpandableListAdapter(
            this,
            groupData,
            android.R.layout.simple_expandable_list_item_1,
            new String[]{"book"},
            new int[]{android.R.id.text1},
            childData,
            android.R.layout.simple_expandable_list_item_1,
            new String[]{"book"},
            new int[]{android.R.id.text1});

        // アダプタの設定
        ExpandableListView expandableListView = findViewById(R.id.expandableListView);
        expandableListView.setAdapter(adapter);

        // 子要素がクリックされた時の処理
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @SuppressWarnings("unchecked")
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // 出版社の表示
                SimpleExpandableListAdapter adapter =
                    (SimpleExpandableListAdapter) parent.getExpandableListAdapter();
                HashMap<String, String> childData =
                    (HashMap<String, String>) adapter.getChild(groupPosition, childPosition);
                Toast.makeText(getApplicationContext(), "出版社は『" +
                    childData.get("publish") + "』です。", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }
}
