package net.buildbox.pokeri.system_applicationlist;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // インストール済みのアプリケーション一覧の取得
        ArrayList<String> applicationList = new ArrayList<>();
        PackageManager packageMgr = getPackageManager();
        List<ApplicationInfo> applicationInfo = packageMgr.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo info : applicationInfo) {
            applicationList.add(packageMgr.getApplicationLabel(info).toString());
        }

        // リスト表示
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, applicationList);
        ListView applicationListView = findViewById(R.id.application_list_view);
        applicationListView.setAdapter(adapter);
    }
}
