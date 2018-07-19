package net.buildbox.pokeri.graph_drawrect.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class GraphView extends View {
    Rect mRect;
    private Paint mPaint;

    public GraphView(Context context) {
        super(context);
        mPaint = new Paint();
        mRect = new Rect(100, 100, 230, 180);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(Color.RED); // 色の設定

        // 四角形を描画する
        canvas.drawRect(mRect, mPaint);
    }
}