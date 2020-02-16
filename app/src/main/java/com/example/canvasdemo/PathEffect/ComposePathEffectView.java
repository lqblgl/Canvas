package com.example.canvasdemo.PathEffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

public class ComposePathEffectView extends View {
    private Paint mPaint;
    private int marging = 82;
    private PathEffect mEffects[];
    private Path mPath;

    public ComposePathEffectView(Context context) {
        super(context);
        init();
    }

    public ComposePathEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        mPaint.setColor(Color.RED);
        mPath = new Path();
        mPath.moveTo(0, marging);
        mPath.lineTo(300, 180);
        mPath.lineTo(400, 600);
        mPath.lineTo(200, 1000);
        mPath.lineTo(800, 1200);
        Path p = new Path();
        p.addRect(0, 0, 64, 12, Path.Direction.CCW);
        mEffects = new PathEffect[3];
        mEffects[0] = new CornerPathEffect(80);
        mEffects[1] = new DashPathEffect(new float[] { 20, 10, 5, 10 }, 0);
        mEffects[2] = new ComposePathEffect(mEffects[1], mEffects[0]);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i = 0; i < mEffects.length; i++) {
            mPaint.setPathEffect(mEffects[i]);
            canvas.drawPath(mPath, mPaint);
            canvas.translate(200, 0);
        }
    }
}
