package com.example.canvasdemo.PathEffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

//切断线段，segmentLength是指定切断的长度，deviation为切断之后线段的偏移量，随机的，小于等于deviation。
public class DiscretePathEffectView extends View {
    private Paint mPaint;
    private int marging = 82;
    private DiscretePathEffect mPathEffect[];
    private Path mPath[];

    public DiscretePathEffectView(Context context) {
        super(context);
        init();
    }

    public DiscretePathEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(6);
        mPathEffect = new DiscretePathEffect[8];
        mPath = new Path[8];
        for (int i = 0; i < mPath.length; i++) {
            Path path = new Path();
            path.moveTo(i * marging, marging);
            path.lineTo(300 + i * marging, 180);
            path.lineTo(400 + i * marging, 600);
            path.lineTo(200 + i * marging, 1000);
            path.lineTo(110 + i * marging, 1200);
            mPath[i] = path;
            mPathEffect[i] = new DiscretePathEffect(1, 3 * i);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        for (int i = 0; i < mPath.length; i++) {
            mPaint.setPathEffect(mPathEffect[i]);
            canvas.drawPath(mPath[i], mPaint);
        }
    }
}
