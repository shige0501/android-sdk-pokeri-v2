package net.buildbox.pokeri.ui_timepickerdialog.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;
import android.widget.Toast;

public class MyTimePickerDialog extends DialogFragment
    implements TimePickerDialog.OnTimeSetListener {
    public static final String TAG = MyTimePickerDialog.class.getSimpleName();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Activity activity = getActivity();
        if (activity == null) {
            throw new IllegalStateException("activity is null");
        }

        // 時刻ピッカーダイアログを呼び出す（初期値に12:34を直接指定）
        return new TimePickerDialog(
            activity,
            this,
            12, 34, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        // 時刻ピッカーダイアログで設定された値をToastで表示
        Toast.makeText(getActivity(),
            "結果は" + hourOfDay + "時" + minute + "分です。",
            Toast.LENGTH_SHORT).show();
    }
}