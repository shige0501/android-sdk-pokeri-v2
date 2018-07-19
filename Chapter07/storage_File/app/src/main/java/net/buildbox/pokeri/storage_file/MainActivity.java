package net.buildbox.pokeri.storage_file;

import android.Manifest;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // ファイルからの読み込み
    public void onReadEvent(View v) {
        MainActivityPermissionsDispatcher.readFileWithPermissionCheck(this);
    }

    // ファイルへの書き込み
    public void onWriteEvent(View v) {
        MainActivityPermissionsDispatcher.writeFileWithPermissionCheck(this);
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    public void readFile() {
        try {
            FileInputStream file = openFileInput("pokeri.txt");
            BufferedReader inBuf = new BufferedReader(new InputStreamReader(file));
            EditText etWriteText = findViewById(R.id.etWriteText);
            String temp = inBuf.readLine();
            while (temp != null) {
                etWriteText.setText(String.format("%s%s\n", etWriteText.getText().toString(), temp));

                temp = inBuf.readLine();
            }

            inBuf.close();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    public void writeFile() {
        try {
            EditText etWriteText = findViewById(R.id.etWriteText);
            FileOutputStream fos = openFileOutput("pokeri.txt", Context.MODE_PRIVATE);
            BufferedWriter outBuf = new BufferedWriter(new OutputStreamWriter(fos));
            outBuf.write(etWriteText.getText().toString());
            outBuf.flush();

            outBuf.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void onWriteExternalStorageDenied() {
        Toast.makeText(this, "書き込みの権限がありません", Toast.LENGTH_SHORT).show();
    }
}
