package net.buildbox.pokeri.graph_surfaceview.view;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SampleSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder mHolder;

    public SampleSurfaceView(Context context) {
        super(context);

        // SurfaceHolderを取得し、描画処理用のコールバックを登録する
        mHolder = getHolder();
        mHolder.addCallback(this);
    }

    // SurfaceView生成時のコールバック処理
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // 描画用スレッドの実行開始
        new Thread(new Runnable() {
            @Override
            public void run() {
                Canvas canvas = mHolder.lockCanvas();
                if (canvas != null) {
                    // 背景色を青に変更
                    canvas.drawColor(Color.BLUE);

                    // 四角形の描画
                    Rect rect = new Rect(100, 100, 500, 500);
                    Paint paint = new Paint();
                    paint.setColor(Color.YELLOW);
                    canvas.drawRect(rect, paint);
                    mHolder.unlockCanvasAndPost(canvas);
                }
            }
        }).start();
    }

    // SurfaceView変更時のコールバック処理
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
    }

    // SurfaceView破棄時のコールバック処理
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }
}