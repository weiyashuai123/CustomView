package com.tyustwys.customview.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/4/5.
 */
public class heart extends View {
    private PointF start,end,con1,con2,con3,con4;

    public heart(Context context) {
        this(context,null);
    }

    public heart(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }
}
