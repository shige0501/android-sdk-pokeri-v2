package net.buildbox.pokeri.ui_alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showAlertDialog(View view) {
        new AlertDialog.Builder(this)
            .setTitle("test")
            .setMessage("アラートダイアログです。\nAndroid SDKポケリ")
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // OKがクリックされた時の処理
                    Toast.makeText(getApplicationContext(), "OKクリック", Toast.LENGTH_SHORT).show();
                }
            })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Cancelがクリックされた時の処理
                    Toast.makeText(getApplicationContext(), "Cancelクリック", Toast.LENGTH_SHORT).show();
                }
            })
            .setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Newtralがクリックされた時の処理
                    Toast.makeText(getApplicationContext(), "Neutralクリック", Toast.LENGTH_SHORT).show();
                }
            })
            .create()
            .show();
    }
}
