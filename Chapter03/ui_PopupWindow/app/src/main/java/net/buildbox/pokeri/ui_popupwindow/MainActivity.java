package net.buildbox.pokeri.ui_popupwindow;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import net.buildbox.pokeri.ui_popupwindow.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private PopupWindow mPopup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setMainActivity(this);
    }

    public void showPopupWindow(View view) {
        // ポップアップウィンドウ用のレイアウト読み込み
        View popupView = LayoutInflater.from(this).inflate(R.layout.popup_main, null);

        // ポップアップウィンドウの生成
        mPopup = new PopupWindow(this);
        // レイアウトパラメータの設定
        mPopup.setWindowLayoutMode(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT);
        // レイアウトのViewとの紐付け
        mPopup.setContentView(popupView);

        // ポップアップウィンドウの表示
        mPopup.showAsDropDown(mBinding.popupButton);
    }

    // ポップアップウィンドウ上のボタンクリック処理
    public void onPopupClick(View v) {
        mPopup.dismiss();
    }
}
