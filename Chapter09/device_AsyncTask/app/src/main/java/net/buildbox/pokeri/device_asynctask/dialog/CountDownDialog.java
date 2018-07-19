package net.buildbox.pokeri.device_asynctask.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

public class CountDownDialog extends DialogFragment {
    public static final String TAG = CountDownDialog.class.getSimpleName();
    private static final int COUNT_MAX = 10;
    private CountDownTask mCountDownTask = null;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Activity targetActivity = getActivity();
        if (targetActivity == null) {
            throw new IllegalStateException("activity is null");
        }

        AlertDialog dialog = new AlertDialog.Builder(targetActivity)
            .setTitle("カウントダウン")
            .setMessage(String.valueOf(COUNT_MAX))
            .create();

        mCountDownTask = new CountDownTask(dialog);
        mCountDownTask.execute();

        return dialog;
    }

    @Override
    public void onDestroy() {
        if (mCountDownTask != null && mCountDownTask.getStatus() != AsyncTask.Status.FINISHED) {
            mCountDownTask.cancel(true);
            mCountDownTask = null;
        }

        super.onDestroy();
    }

    private static class CountDownTask extends AsyncTask<Void, Integer, Long> {
        private AlertDialog mDialog;
        private int mCount = COUNT_MAX;

        CountDownTask(AlertDialog dialog) {
            mDialog = dialog;
        }

        @Override
        protected Long doInBackground(Void... params) {
            while (0 <= mCount) {
                if (isCancelled()) {
                    // ダイアログ終了でキャンセルされたら処理を終了する
                    Log.d(TAG, "CountDownTaskの終了");
                    break;
                }

                // 500ミリ秒の待ち処理
                SystemClock.sleep(500);

                publishProgress(--mCount);
            }
            return 0L;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mDialog.dismiss();
        }

        @Override
        protected void onPostExecute(Long result) {
            super.onPostExecute(result);

            mDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            mDialog.setMessage(String.valueOf(mCount));
        }
    }
}