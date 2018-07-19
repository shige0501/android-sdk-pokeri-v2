package net.buildbox.pokeri.graph_drawcircle.view;

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

        // 円を描画する
        canvas.drawCircle(100.0f, 100.0f, 50.0f, mPaint);
    }
}