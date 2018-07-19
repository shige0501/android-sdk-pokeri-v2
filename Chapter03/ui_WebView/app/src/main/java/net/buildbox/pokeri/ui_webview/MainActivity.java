package net.buildbox.pokeri.ui_webview;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // JavaScriptの有効化
        WebView webView = findViewById(R.id.web_view);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        // WebViewClientの設定
        webView.setWebViewClient(new WebViewClient() {
            // Webページ読み込み開始時
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.d(TAG, "Webページ読み込み開始");
            }

            // Webページ読み込み完了時
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.d(TAG, "Webページ読み込み完了");
            }
        });

        // ピンチ操作による拡大・縮小の有効化
        settings.setBuiltInZoomControls(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        WebView webView = findViewById(R.id.web_view);

        switch (item.getItemId()) {
            case R.id.menu_load_url:
                // 指定したURLのサイト読み込み
                webView.loadUrl("http://www.gihyo.co.jp/");
                return true;
            case R.id.menu_load_asset:
                // assetsからのサイト読み込み
                webView.loadUrl("file:///android_asset/hello.html");
                return true;
            case R.id.menu_load_data:
                // HTMLソースからの読み込み
                String srcHtml =
                    "<!DOCTYPE html><html><head>" +
                        "<meta charset='UTF-8'>" +
                        "<title>Android API ポケットリファレンス　サンプル</title>" +
                        "</head><body>" +
                        "HTMLソースの文字列から直接HTMLとしてWebViewに表示するサンプルです。" +
                        "</body></html>";
                webView.loadDataWithBaseURL(null, srcHtml, "text/html", "UTF-8", null);
                return true;
            case R.id.menu_back:
                // 前のページに戻る
                webView.goBack();
                return true;
            case R.id.menu_forward:
                // 次のページに進む
                webView.goForward();
                return true;
            case R.id.menu_2back:
                // ２ステップ前のページに戻る
                webView.goBackOrForward(-2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
