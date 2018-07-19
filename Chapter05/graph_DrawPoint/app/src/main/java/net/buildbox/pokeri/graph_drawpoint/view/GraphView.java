package net.buildbox.pokeri.graph_drawpoint.view;

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
        mPaint.setStrokeWidth(32.0f); // 点の太さ

        // 点を描画する
        canvas.drawPoint(100.0f, 100.0f, mPaint);

        // 連続で点を描画する
        mPaint.setColor(Color.BLUE);
        float[] points = {
            100.0f, 300.0f, // 1点目：X, Y座標
            160.0f, 120.0f, // 2点目：X, Y座標
            200.0f, 180.0f, // 3点目：X, Y座標
            260.0f, 160.0f // 4点目：X, Y座標
        };
        canvas.drawPoints(points, mPaint);
    }
}