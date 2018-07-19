package net.buildbox.pokeri.app_dialogfragment.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class SampleDialogFragment extends DialogFragment {
    public static final String TAG = SampleDialogFragment.class.getSimpleName();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Activity activity = getActivity();
        if (activity == null) {
            throw new IllegalStateException("activity is null");
        }

        // アラートダイアログの構築
        return new AlertDialog.Builder(activity)
            .setTitle("サンプルダイアログ")
            .setMessage("サンプルメッセージ")
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dismiss();
                }
            })
            .show();
    }
}
