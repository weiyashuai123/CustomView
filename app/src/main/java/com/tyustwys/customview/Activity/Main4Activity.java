package com.tyustwys.customview.Activity;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.eftimoff.androipathview.PathView;
import com.tyustwys.customview.R;
import com.tyustwys.customview.View.KeKe;
import com.tyustwys.customview.util.MyPath;

import java.util.ArrayList;
import java.util.List;

public class Main4Activity extends AppCompatActivity {
    private PointF start, end, con1, con2, con3, con4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        KeKe ke = (KeKe) findViewById(R.id.keke);
        PathView pathView = (PathView) findViewById(R.id.pathView);
        MyPath path = new MyPath();
        path.setBaseValue(30);
        path.moveTo(1,1);
        path.lineTo(4,1);
        path.lineTo(7,8);
        path.lineTo(10,1);
        path.lineTo(13,1);
        path.lineTo(13,1.5f);
        path.lineTo(12,1.5f);
        path.lineTo(12,10.5f);
        path.lineTo(13,10.5f);
        path.lineTo(13,11);
        path.lineTo(9,11);
        path.lineTo(9,10.5f);
        path.lineTo(10,10.5f);
        path.lineTo(10,3);
        path.lineTo(7,10.5f);
        path.lineTo(4,3);
        path.lineTo(4,10.5f);
        path.lineTo(5,10.5f);
        path.lineTo(5,11);
        path.lineTo(1,11);
        path.lineTo(1,10.5f);
        path.lineTo(2,10.5f);
        path.lineTo(2,1.5f);
        path.lineTo(1,1.5f);
        path.close();
        pathView.setPath(path);
        pathView.setPathColor(Color.parseColor("#FFCC00"));
        pathView.getPathAnimator()
                .delay(100).
                duration(2500).
                listenerStart(new PathView.AnimatorBuilder.ListenerStart() {
                    @Override
                    public void onAnimationStart() {

                    }
                }).
                listenerEnd(new PathView.AnimatorBuilder.ListenerEnd() {
                    @Override
                    public void onAnimationEnd() {

                    }
                }).
                start();

    }
}
