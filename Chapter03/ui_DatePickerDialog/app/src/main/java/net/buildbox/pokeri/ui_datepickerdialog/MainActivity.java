package net.buildbox.pokeri.ui_datepickerdialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.buildbox.pokeri.ui_datepickerdialog.dialog.MyDatePickerDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDatePickerDialog(View v) {
        // 日付ピッカーダイアログの表示
        MyDatePickerDialog dialog = new MyDatePickerDialog();
        dialog.show(getSupportFragmentManager(), MyDatePickerDialog.TAG);
    }
}
