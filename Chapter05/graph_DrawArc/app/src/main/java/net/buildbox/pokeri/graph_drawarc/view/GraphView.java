package net.buildbox.pokeri.graph_drawarc.view;

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
        mRectF = new RectF(100.0f, 100.0f, 600.0f, 600.0f);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.RED); // 色の設定

        // 弧を描画する
        canvas.drawArc(mRectF, 20.0f, 80.0f, true, mPaint);
    }
}