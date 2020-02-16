package com.example.canvasdemo.PathEffect;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

//PathDashPathEffect和DashPathEffect差不多，不同的是PathDashPathEffect可以通过自定义图形来绘制path
//shape是填充的图形，这个图形可以自己绘制，advance是图形之间的间距，phase是path的偏移量，其中有3种style，TRANSLATE是指图形以平移的方式填充path，ROTATE会根据path的旋转而旋转，MORPH和ROTATE差不多，不过有一点就是MORPH会在转角的连接处以平滑的方式连接
public class PathDashPathEffectView extends View {
    private Paint mPaint;
    private int marging = 82;
    private PathEffect mPathEffect1;
    private PathEffect mPathEffect2;
    private PathEffect mPathEffect3;
    private Path mPath;

    public PathDashPathEffectView(Context context) {
        super(context);
        init();
    }

    public PathDashPathEffectView(Context context, AttributeSet attrs) {
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
        mPathEffect1 = new PathDashPathEffect(p, 128, 0,
                android.graphics.PathDashPathEffect.Style.MORPH);
        mPathEffect2 = new PathDashPathEffect(p, 128, 0,
                android.graphics.PathDashPathEffect.Style.ROTATE);
        mPathEffect3 = new PathDashPathEffect(p, 128, 0,
                android.graphics.PathDashPathEffect.Style.TRANSLATE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        mPaint.setPathEffect(mPathEffect1);
        canvas.drawPath(mPath, mPaint);
        canvas.translate(200, 0);
        mPaint.setPathEffect(mPathEffect2);
        canvas.drawPath(mPath, mPaint);
        canvas.translate(200, 0);
        mPaint.setPathEffect(mPathEffect3);
        canvas.drawPath(mPath, mPaint);
    }
}