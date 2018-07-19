package net.buildbox.pokeri.ui_recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.buildbox.pokeri.ui_recyclerview.adapter.SampleRecyclerAdapter;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeRecyclerView();
    }

    private void initializeRecyclerView() {
        // リストビューの読み込み
        List<String> items = Arrays.asList("C/C++", "Objective-C", "Fortran",
            "Java", "Scala", "Basic", "Ruby", "JavaScript",
            "Python", "PHP", "C#", "COBOL", "LISP", "Scheme",
            "Haskell", "Erlang", "ASP", "HTML");

        SampleRecyclerAdapter adapter = new SampleRecyclerAdapter(this);
        adapter.clear();
        adapter.addAll(items);

        RecyclerView recyclerView = findViewById(R.id.sample_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        // 区切り線の描画
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
            this, new LinearLayoutManager(this).getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
