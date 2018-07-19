package net.buildbox.pokeri.device_sendsms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST = 361;
    private static final String[] PERMISSIONS = {
        Manifest.permission.SEND_SMS,
        Manifest.permission.READ_PHONE_STATE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST) {
            if (isGranted(grantResults)) {
                sendSms();
            } else {
                Toast.makeText(this, "SMS送信の権限が許可されていません", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    public void onClickEvent(View v) {
        if (PermissionChecker.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED &&
            PermissionChecker.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            sendSms();
        } else {
            ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSIONS_REQUEST);
        }
    }

    private boolean isGranted(int[] grantResults) {
        for (int result: grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    private void sendSms() {
        SmsManager smsManager = SmsManager.getDefault();
        // 送信先の電話番号を設定する
        String destinationAddress = "0123456789";
        // 送信するテキストを設定する
        String text = "Hello, Android SDKポケットリファレンス！";
        // 送信する
        smsManager.sendTextMessage(destinationAddress, null, text, null, null);
    }
}
