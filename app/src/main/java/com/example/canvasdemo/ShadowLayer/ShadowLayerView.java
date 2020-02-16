package com.example.canvasdemo.ShadowLayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.canvasdemo.R;

public class ShadowLayerView extends View {

    private Paint paint;
    private Bitmap bitmap;

    public ShadowLayerView(Context context) {
        super(context);
        init();
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);//对单独的View在运行时阶段禁用硬件加速
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bitmap);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(2);
        paint.setAntiAlias(true);
        paint.setTextSize(100);
        paint.setShadowLayer(10, 20, 40, Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Mian", 100, 100, paint);
        canvas.drawCircle(500, 200, 200, paint);
        canvas.drawBitmap(bitmap, null, new RectF(200, 500, 1000, 1300), paint);
    }
}


