package com.example.canvasdemo.PathEffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

//画虚线。构造函数，看注释，intervals必须大于大于2，phase是偏移量
public class DashPathEffectView extends View {
    private Paint mPaint;
    private int marging = 82;
    private DashPathEffect mCornerPathEffect[];
    private Path mPath[];

    public DashPathEffectView(Context context) {
        super(context);
        init();
    }

    public DashPathEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        mCornerPathEffect = new DashPathEffect[8];
        mPath = new Path[8];
        for (int i = 0; i < mPath.length; i++) {
            Path path = new Path();
            path.moveTo(i * marging, marging);
            path.lineTo(300 + i * marging, 180);
            path.lineTo(400 + i * marging, 600);
            path.lineTo(200 + i * marging, 1000);
            path.lineTo(110 + i * marging, 1200);
            mPath[i] = path;
            mCornerPathEffect[i] = new DashPathEffect(
                    new float[] { 1, 2, 4, 8 }, 1);
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
