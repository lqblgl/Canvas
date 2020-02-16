package com.example.canvasdemo.Shader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.canvasdemo.R;

//位图渲染
public class BitmapShaderView extends View {

    private Paint paint;
    private Path path;

    public BitmapShaderView(Context context) {
        super(context);
        init();
    }

    public BitmapShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * Shader.TileMode 一共有 CLAMP(图片对应轴上的最后一个颜色对其复制), REPEAT(镜面对称), MIRROR(无限重复)三种显示模式.
     * 方法中的第一个Shader.TileMode是X轴的显示模式，第二个是Y轴上的显示模式。
     */
    private void init() {
        paint = new Paint();
        paint.setTextSize(500);
        paint.setStrokeWidth(80);
        paint.setStyle(Paint.Style.FILL);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bitmap);
        BitmapShader shader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(shader);

        path = new Path();
        path.moveTo(100, 900);
        path.lineTo(100, 1200);
        path.lineTo(400, 1200);
        path.lineTo(400, 900);
        path.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200, 200, 200, paint);
        canvas.drawRect(500, 0, 900, 400, paint);
        canvas.drawText("测试", 0, 800, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
    }
}
