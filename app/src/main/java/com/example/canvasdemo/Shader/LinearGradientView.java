package com.example.canvasdemo.Shader;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

//线性渲染
public class LinearGradientView extends View {

    private Paint paint;

    public LinearGradientView(Context context) {
        super(context);
        init();
    }

    public LinearGradientView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        LinearGradient linearGradient =
                new LinearGradient(300, 300, 600, 600, Color.RED, Color.GREEN, Shader.TileMode.MIRROR);
        paint.setShader(linearGradient);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(new Rect(0, 0, 1080, 1920), paint);

        // 为了展现上面的100, 100, 500, 500到底在哪个区域
        paint.setStyle(Paint.Style.STROKE);
        paint.setShader(null);
        paint.setStrokeWidth(2);
        canvas.drawRect(new Rect(100, 100, 500, 500), paint);
    }
}

