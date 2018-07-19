package net.buildbox.pokeri.ui_datepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Lollipop の不具合により、レイアウトで android:datePickerMode="spinner" を指定しないと正常に呼び出されない
    // http://stackoverflow.com/questions/31609777/ondatechanged-is-not-called-in-date-picker-android-lollipop
    private DatePicker.OnDateChangedListener mListener = new DatePicker.OnDateChangedListener() {
        @Override
        public void onDateChanged(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
            // 日付が変更された時にToastを出力
            Toast.makeText(
                view.getContext(),
                year + "/" + (monthOfYear + 1) + "/" + dayOfMonth + "です。",
                Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2017/07/01でDatePickerを初期化し、変更時のイベントを受け取るリスナーの設定
        DatePicker datePicker = (DatePicker) findViewById(R.id.date_picker);
        datePicker.init(2017, 6, 1, mListener);
    }
}
