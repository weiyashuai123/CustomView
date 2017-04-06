package com.tyustwys.customview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.tyustwys.customview.R;

/**
 * Created by Administrator on 2017/3/24.
 */
public class People extends View {

    private int width;
    private int height;

    private String name = "魏亚帅";
    private int imageId = R.mipmap.ic_launcher;

    private Paint mPaint = new Paint();
    private Paint textPaint = new Paint();
    private Context context;

    public People(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setColor(Color.parseColor("#262626"));
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(10f);
        mPaint.setAntiAlias(true);
        textPaint.setColor(Color.parseColor("#FFC000"));
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setAntiAlias(true);

        this.context = context;
    }

    public People(Context context) {
        this(context, null);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.height = h;
        this.width = w;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float basicLength = Math.min(width / 2, height / 5) / 4;
        textPaint.setTextSize(basicLength);
        Path path = new Path();
        path.addCircle(width / 2, (height / 2) - (4 * basicLength), 2 * basicLength, Path.Direction.CW);
        path.moveTo(width / 2, height / 2);
        path.lineTo(width / 2, (height / 2) - (2 * basicLength));
        path.moveTo(width / 2, height / 2);
        path.lineTo(width / 2, (height / 2) + (2 * basicLength));
        path.moveTo(width / 2, (height / 2) + (2 * basicLength));
        path.lineTo((width / 2) + (2 * basicLength), (height / 2) + (5 * basicLength));
        path.moveTo(width / 2, (height / 2) + (2 * basicLength));
        path.lineTo((width / 2) - (2 * basicLength), (height / 2) + (5 * basicLength));
        path.moveTo(width / 2, height / 2);
        path.lineTo((width / 2) + (3 * basicLength), (height / 2));
        path.moveTo((width / 2) + (5 * basicLength / 2), (height / 2) + basicLength);
        path.lineTo((width / 2) + (5 * basicLength / 2), (height / 2) - (5 * basicLength));
        path.moveTo(width / 2, height / 2);
        path.lineTo((width / 2) - basicLength, (height / 2) + basicLength);
        path.lineTo((width / 2) - (2 * basicLength), (height / 2) + (4 * basicLength));
        path.lineTo((width / 2) - (3 * basicLength), (height / 2) + basicLength);
        path.lineTo((width / 2) - basicLength, (height / 2) + basicLength);
        canvas.drawPath(path, mPaint);
        canvas.drawText(name,0,1,(width / 2) - (3 * basicLength), (height / 2) + (2 * basicLength),textPaint);
        canvas.translate(width / 2, (height / 2) - (4 * basicLength));
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
        Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        int val = (int) (Math.sqrt(2) * basicLength);
        Rect dst = new Rect( -val, -val, val, val);
        canvas.drawBitmap(bitmap, src, dst, null);


    }
}
