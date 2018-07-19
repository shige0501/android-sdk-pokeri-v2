package net.buildbox.pokeri.device_network.network;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkTask extends AsyncTask<Void, Void, Bitmap> {
    private NetworkListener mNetworkListener;

    @Override
    protected Bitmap doInBackground(Void... params) {
        HttpURLConnection connection = null;
        URL url;
        String urlString = "http://chart.apis.google.com/chart?chs=450x450&cht=qr&chl=http://www.gihyo.co.jp/";
        Bitmap bitmap = null;

        try {
            url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setInstanceFollowRedirects(false);
            connection.setDoInput(true);
            connection.setDoOutput(false);
            connection.connect();

            // データの取得
            int status = connection.getResponseCode();
            if (status == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (mNetworkListener != null) {
            mNetworkListener.onSuccess(bitmap);
        }
    }

    public NetworkTask setNetworkListener(NetworkListener listener) {
        mNetworkListener = listener;
        return this;
    }

    public interface NetworkListener {
        void onSuccess(Bitmap bitmap);
    }
}