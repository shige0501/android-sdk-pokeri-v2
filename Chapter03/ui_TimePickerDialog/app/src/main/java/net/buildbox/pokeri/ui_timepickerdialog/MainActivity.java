package net.buildbox.pokeri.ui_timepickerdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.buildbox.pokeri.ui_timepickerdialog.dialog.MyTimePickerDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showTimePickerDialog(View v) {
        // 時刻ピッカーダイアログの表示
        MyTimePickerDialog newFragment = new MyTimePickerDialog();
        newFragment.show(getSupportFragmentManager(), MyTimePickerDialog.TAG);
    }
}
