package net.buildbox.pokeri.graph_drawoval.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class GraphView extends View {
    private Paint mPaint;
    private RectF mRectF;

    public GraphView(Context context) {
        super(context);
        mPaint = new Paint();
        mRectF = new RectF(300.0f, 300.0f, 600.0f, 800.0f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.RED); // 色の設定

        // 楕円を描画する
        canvas.drawOval(mRectF, mPaint);
    }
}