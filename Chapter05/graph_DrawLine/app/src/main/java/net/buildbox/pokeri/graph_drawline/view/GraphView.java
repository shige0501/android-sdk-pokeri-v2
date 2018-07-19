package net.buildbox.pokeri.graph_drawline.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GraphView extends View {
    private Paint mPaint;

    public GraphView(Context context) {
        super(context);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.RED); // 色の設定
        mPaint.setStrokeWidth(16.0f); // 線の太さ

        // 線を描画する
        canvas.drawLine(100.0f, 100.0f, 250.0f, 100.0f, mPaint);

        // 連続で線を描画する
        mPaint.setColor(Color.BLUE);
        float[] points = {
            150.0f, 300.0f, // 1本目：始点
            160.0f, 420.0f, // 1本目：終点
            160.0f, 420.0f, // 2本目：始点
            200.0f, 560.0f // 2本目：終点
        };
        canvas.drawLines(points, mPaint);
    }
}