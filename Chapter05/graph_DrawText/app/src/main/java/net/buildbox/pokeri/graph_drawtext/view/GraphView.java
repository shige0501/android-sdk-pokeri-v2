package net.buildbox.pokeri.graph_drawtext.view;

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

        mPaint.setColor(Color.RED); // 色の指定
        mPaint.setTextSize(64.0f); // テキストサイズの指定

        // テキストを描画する
        canvas.drawText("テキストの描画", 100.0f, 100.0f, mPaint);
    }
}