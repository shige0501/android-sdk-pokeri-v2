package net.buildbox.pokeri.device_handler.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class CountDownDialog extends DialogFragment {
    public static final String TAG = CountDownDialog.class.getSimpleName();
    private static final int COUNT_MAX = 10;
    private static Handler mHandler = new Handler(Looper.getMainLooper());

    private int mCount = COUNT_MAX;


    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            mCount--;

            if (0 <= mCount) {
                AlertDialog dialog = (AlertDialog) getDialog();
                dialog.setMessage(String.valueOf(mCount));

                // 500ミリ秒後にメッセージの送信
                mHandler.postDelayed(mRunnable, 500);
            } else {
                // ダイアログの終了
                dismiss();
            }
        }
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Activity targetActivity = getActivity();
        if (targetActivity == null) {
            throw new IllegalStateException("activity is null");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                // スレッド内でUI操作を行うために、Handlerに処理を要求する
                mHandler.post(mRunnable);
            }
        }).start();

        return new AlertDialog.Builder(targetActivity)
            .setTitle("カウントダウン")
            .setMessage(String.valueOf(COUNT_MAX))
            .create();
    }
}