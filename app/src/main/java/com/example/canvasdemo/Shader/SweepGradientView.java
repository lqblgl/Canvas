package com.example.canvasdemo.Shader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

//梯度渲染
public class SweepGradientView extends View {

    private Paint paint;

    public SweepGradientView(Context context) {
        super(context);
        init();
    }

    public SweepGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        SweepGradient sweepGradient = new SweepGradient(500, 500, Color.RED, Color.GREEN);
        paint.setShader(sweepGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(500, 500, 500, paint);
    }
}

