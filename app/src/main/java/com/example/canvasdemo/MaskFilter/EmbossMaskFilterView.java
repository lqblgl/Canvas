package com.example.canvasdemo.MaskFilter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

//:浮雕遮罩滤镜 类似于灯光照射效果
public class EmbossMaskFilterView extends View {

    private Paint paint;

    public EmbossMaskFilterView(Context context) {
        super(context);
        init();
    }

    public EmbossMaskFilterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);//对单独的View在运行时阶段禁用硬件加速
        paint = new Paint();
        paint.setColor(Color.RED);
        float[] direction = new float[]{1, 1, 1};
        float light = 1f;
        float specular = 1;
        float blur = 5;
        paint.setMaskFilter(new EmbossMaskFilter(direction, light, specular, blur));
        paint.setTextSize(200);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("Test", 50, 200, paint);
    }
}
