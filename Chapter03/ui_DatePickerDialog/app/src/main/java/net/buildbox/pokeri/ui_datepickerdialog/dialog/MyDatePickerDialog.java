package net.buildbox.pokeri.ui_datepickerdialog.dialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.Toast;

public class MyDatePickerDialog extends DialogFragment
    implements android.app.DatePickerDialog.OnDateSetListener {
    public static final String TAG = MyDatePickerDialog.class.getSimpleName();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Activity activity = getActivity();
        if (activity == null) {
            throw new IllegalStateException("activity is null");
        }
        // 日付ピッカーダイアログを呼び出す（初期値に2017/03/01を直接指定）
        return new DatePickerDialog(
            activity,
            this,
            2017, 2, 1);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear,
                          int dayOfMonth) {
        // 日付ピッカーダイアログで設定された値をToastで表示
        Toast.makeText(getActivity(),
            "結果は" + year + "年" + (monthOfYear + 1) + "月" + dayOfMonth + "日です。",
            Toast.LENGTH_SHORT).show();
    }
}