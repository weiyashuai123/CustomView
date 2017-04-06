package com.tyustwys.customview.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

import com.tyustwys.customview.R;
import com.tyustwys.customview.util.MyPath;

/**
 * Created by Administrator on 2017/4/5.
 */
public class KeKe extends View{
    private float currentValue = 0;     // 用于纪录当前的位置,取值范围[0,1]映射Path的整个长度

    private float[] pos;                // 当前点的实际位置
    private float[] tan;                // 当前点的tangent值,用于计算图片所需旋转的角度
    private Bitmap mBitmap;             // 箭头图片
    private Matrix mMatrix;             // 矩阵,用于对图片进行一些操作

    private PointF start,end,con1,con2,con3,con4;

    private float mWidth;
    private float mHeight;

    public KeKe(Context context) {

        this(context,null);
    }

    public KeKe(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }
    private void init(Context context) {
        start = new PointF(0,0);
        end = new PointF(0,0);
        con1 = new PointF(0,0);
        con2 = new PointF(0,0);
        con3 = new PointF(0,0);
        con4 = new PointF(0,0);
        invalidate();
        pos = new float[2];
        tan = new float[2];
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 15;       // 缩放图片
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.point, options);
        mMatrix = new Matrix();

    }
    public void setPoint(PointF start,PointF end,PointF con1,PointF con2,PointF con3,PointF con4){
        this.con4=con4;
        this.con3=con3;
        this.con2=con2;
        this.con1=con1;
        this.start=start;
        this.end = end;
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float baseValue = Math.min(mWidth,mHeight);
        float b = baseValue/15;

        Path path = new Path();
        path.moveTo(2*b,0);
        path.lineTo(4*b,0);
        path.lineTo(4*b,2*b);
        path.lineTo(2*b,2*b);
        path.lineTo(2*b,4*b);
        path.lineTo(4*b,4*b);
        path.lineTo(4*b,6*b);
        path.lineTo(2*b,5*b);
        Path path1 = new Path();
        path1.moveTo(5*b,0);
        path1.lineTo(5*b,6*b);
        path1.lineTo(6*b,5*b);
        path1.moveTo(4*b,3*b);
        path1.lineTo(7*b,3*b);
        path1.moveTo(7*b,0);
        path1.lineTo(5*b,3*b);
        path1.quadTo(6*b,5*b,7*b,6*b);
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(b/5);
        paint.setStyle(Paint.Style.STROKE);

        MyPath myPath = new MyPath();
        myPath.setBaseValue(b);
        myPath.moveTo(8,7);
        myPath.lineTo(13,7);
        myPath.moveTo(12,7);
        myPath.lineTo(12,13);
        myPath.lineTo(11,12);
        myPath.moveTo(9,9);
        myPath.lineTo(9,11);
        myPath.lineTo(11,11);
        myPath.lineTo(11,9);
        myPath.lineTo(9,9);
        Paint paint1 = new Paint();
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setColor(Color.YELLOW);
        paint1.setStrokeWidth(5);
        canvas.drawPath(path, paint);
        canvas.drawPath(path1,paint);
        canvas.drawPath(myPath,paint1);

        start = new PointF(4*b,10*b);
        end = new PointF(4*b,13*b);
        con1 = new PointF(2*b,7*b);
        con2 = new PointF(0,10*b);
        con3 = new PointF(6*b,7*b);
        con4 = new PointF(8*b,10*b);

        Path myPath2 = new Path();
        myPath2.moveTo(start.x,start.y);
        myPath2.cubicTo(con1.x,con1.y,con2.x,con2.y,end.x,end.y);

        myPath2.moveTo(start.x,start.y);
        myPath2.cubicTo(con3.x,con3.y,con4.x,con4.y,end.x,end.y);
        canvas.drawPath(myPath2,paint);

    }



}
