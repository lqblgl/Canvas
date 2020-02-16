package com.example.canvasdemo.MaskFilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.canvasdemo.R;

//模糊遮罩滤镜 改变图像的透明度值来实现的
public class BlurMaskFilterView extends View {

    private Paint paint;

    public BlurMaskFilterView(Context context) {
        super(context);
        init();
    }

    public BlurMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);//对单独的View在运行时阶段禁用硬件加速
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(100, 000, 800, 000, paint);

        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));
        canvas.drawLine(100, 200, 800, 200, paint);

        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER));
        canvas.drawLine(100, 400, 800, 400, paint);

        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        canvas.drawLine(100, 600, 800, 600, paint);

        paint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));
        canvas.drawLine(100, 800, 800, 800, paint);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bitmap);
        canvas.drawBitmap(bitmap, null, new RectF(100, 1000, 500, 1400), paint);
        paint.setMaskFilter(new BlurMaskFilter(250, BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(bitmap, null, new RectF(600, 1000, 1000, 1400), paint);
    }
}



