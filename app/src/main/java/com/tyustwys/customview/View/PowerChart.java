package com.tyustwys.customview.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/4/18.
 */
public class PowerChart extends View {

    private float mHeight, mWeight, sidelenth;
    private String[] data = {"NULL"};
    private int[] value = {0};

    public PowerChart(Context context) {
        this(context, null);
    }

    public PowerChart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mHeight = h;
        mWeight = w;
        sidelenth = 4 * Math.min(w, h) / 5;
    }

    public void setData(String[] data, int[] value) {
        this.data = data;
        this.value = value;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        Paint textPaint = new Paint();
        textPaint.setTextSize(24);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.BLACK);
        canvas.translate(mWeight / 2, mHeight / 2);
        for (int i = 1; i <= data.length; i++) {
            Path path = getPath(i, data.length);
            Paint paint = new Paint();
            paint.setColor(Color.parseColor("#33009966"));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, paint);
        }
        for (int i = 1; i <= data.length; i++) {
            float dx = (float) (sidelenth / 2 * Math.sin((i * 360 / data.length + 180) * Math.PI / 180));
            float dy = (float) (sidelenth / 2 * Math.cos((i * 360 / data.length + 180) * Math.PI / 180));
            canvas.drawLine(0, 0, dx, dy, mPaint);
            canvas.drawText(data[i - 1], dx * 9 / 8 - 24, dy * 9 / 8 + 12, textPaint);
        }
        drawDataLine(canvas,value);
    }

    private Path getPath(int s, int p) {
        Path path = new Path();
        float sx = (float) (sidelenth / 2 * Math.sin((0 * 360 / data.length + 180) * Math.PI / 180) * s / p);
        float sy = (float) (sidelenth / 2 * Math.cos((0 * 360 / data.length + 180) * Math.PI / 180) * s / p);
        path.moveTo(sx, sy);
        for (int i = 1; i <= data.length; i++) {
            float dx = (float) (sidelenth / 2 * Math.sin((i * 360 / data.length + 180) * Math.PI / 180) * s / p);
            float dy = (float) (sidelenth / 2 * Math.cos((i * 360 / data.length + 180) * Math.PI / 180) * s / p);
            path.lineTo(dx, dy);
        }
        path.lineTo(sx, sy);
        return path;
    }

    private void drawDataLine(Canvas canvas, int[] value) {
        int sum = 0;
        for (int s : value) {
            sum = sum + s;
        }
        int v = value[0];
        Path path = new Path();
        float sx = (float) (sidelenth / 2 * Math.sin((0 * 360 / data.length + 180) * Math.PI / 180) * v / sum);
        float sy = (float) (sidelenth / 2 * Math.cos((0 * 360 / data.length + 180) * Math.PI / 180) * v / sum);
        path.moveTo(sx, sy);

        for (int i = 1; i < value.length; i++) {
            float dx = (float) (sidelenth / 2 * Math.sin((i * 360 / data.length + 180) * Math.PI / 180) * value[i] / sum);
            float dy = (float) (sidelenth / 2 * Math.cos((i * 360 / data.length + 180) * Math.PI / 180) * value[i] / sum);
            path.lineTo(dx, dy);

        }
        path.lineTo(sx, sy);
        Paint thispaint = new Paint();
        thispaint.setColor(Color.RED);
        thispaint.setStyle(Paint.Style.STROKE);
        thispaint.setStrokeWidth(3);
        canvas.drawPath(path,thispaint);
    }
}
