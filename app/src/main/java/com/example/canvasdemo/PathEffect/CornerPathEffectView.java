package com.example.canvasdemo.PathEffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

//Path的线段之间的夹角变成圆角。构造函数，其中radius为圆角的半径
public class CornerPathEffectView extends View {
    private Paint mPaint;
    private int marging = 82;
    private CornerPathEffect mCornerPathEffect[];
    private Path mPath[];

    public CornerPathEffectView(Context context) {
        super(context);
        init();
    }

    public CornerPathEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        mCornerPathEffect = new CornerPathEffect[8];
        mPath = new Path[8];
        for (int i = 0; i < mPath.length; i++) {
            Path path = new Path();
            path.moveTo(i * marging, marging);
            path.lineTo(300 + i * marging, 180);
            path.lineTo(400 + i * marging, 600);
            path.lineTo(200 + i * marging, 1000);
            path.lineTo(110 + i * marging, 1200);
            mPath[i] = path;
            mCornerPathEffect[i] = new CornerPathEffect(i * 10);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        for (int i = 0; i < mPath.length; i++) {
            mPaint.setPathEffect(mCornerPathEffect[i]);
            canvas.drawPath(mPath[i], mPaint);
        }
    }
}
