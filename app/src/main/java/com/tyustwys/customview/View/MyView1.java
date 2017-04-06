package com.tyustwys.customview.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.tyustwys.customview.enity.ViewData1;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/3/23.
 */
public class MyView1 extends View {

    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    private ArrayList<ViewData1> mData;
    private int mWidth, mHeght;
    Path path ;
    private Paint mPaint = new Paint();
    private Paint textPaint = new Paint();
    private int startAngle = 0;

    public MyView1(Context context) {
        this(context, null);
    }

    public MyView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        textPaint.setStyle(Paint.Style.FILL);
        textPaint.setColor(Color.BLACK);
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(20);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeght = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mData == null) return;
        float startAngle = this.startAngle;
        float sa = startAngle + 90;
        canvas.translate(mWidth / 2, mHeght / 2);// 将画布坐标原点移动到中心位置
        float r = (float) (Math.min(mWidth / 2, mHeght / 2));//确定半径
        RectF rect = new RectF(-r, -r, r, r);//绘制区域
        for (int i = 0; i < mData.size(); i++) {
            path = new Path();
            path.moveTo(0, 0);
            ViewData1 data1 = mData.get(i);
            mPaint.setColor(data1.getColor());
            float ang = data1.getAngle()/2 + sa;
            sa = sa + data1.getAngle();
            float cW = (float) (r * Math.sin(ang * Math.PI/180));
            float cH = (float) -(r * Math.cos(ang * Math.PI/180));
            path.lineTo(cW,cH);

            canvas.drawArc(rect, startAngle, data1.getAngle(), true, mPaint);
            startAngle = startAngle + data1.getAngle();
            canvas.drawTextOnPath(data1.getName()+" \t "+data1.getPercentage()+"%",path,150,0,textPaint);
        }
    }
    public void setStartAngle(int startAngle) {
        this.startAngle = startAngle;
        invalidate();   // 刷新
    }
    public void setData(ArrayList<ViewData1> mData) {
        this.mData = mData;
        initData(mData);
        invalidate();   // 刷新
    }
    private void initData(ArrayList<ViewData1> mData) {
        if (null == mData || mData.size() == 0)   // 数据有问题 直接返回
            return;

        for (int i = 0; i < mData.size(); i++) {
            ViewData1 pie = mData.get(i);
            int j = i % mColors.length;       //设置颜色
            pie.setColor(mColors[j]);
        }
    }
}
