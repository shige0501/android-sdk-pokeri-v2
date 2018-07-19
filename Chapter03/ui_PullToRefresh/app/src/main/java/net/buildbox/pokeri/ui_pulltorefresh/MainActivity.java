package net.buildbox.pokeri.ui_pulltorefresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler = new Handler(Looper.getMainLooper());
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeListView();
        initializeSwipeRefresh();
    }

    private void initializeListView() {
        // リストビューの初期化
        ListView listView = findViewById(R.id.list_view);
        String[] language = {"C/C++", "Objective-C", "Fortran",
            "Java", "Scala", "Basic", "Ruby", "JavaScript",
            "Python", "PHP", "C#", "COBOL", "LISP", "Scheme",
            "Haskell", "Erlang", "ASP", "HTML"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this, android.R.layout.simple_list_item_1, language);

        // アダプタの設定
        listView.setAdapter(adapter);
    }

    private void initializeSwipeRefresh() {
        mSwipeRefreshLayout = findViewById(R.id.refresh_layout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // 5秒後にToastを表示してPullToRefreshを終了する
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Android SDKポケットリファレンスを改訂しました", Toast.LENGTH_SHORT).show();
                        mSwipeRefreshLayout.setRefreshing(false);
                    }
                }, 5000);
            }
        });
    }
}
