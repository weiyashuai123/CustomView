package com.tyustwys.customview.util;

import android.graphics.Path;

/**
 * Created by Administrator on 2017/4/5.
 */
public class MyPath extends Path {
    private float baseValue;

    public void setBaseValue(float baseValue) {
        this.baseValue = baseValue;
    }

    @Override
    public void moveTo(float x, float y) {
        super.moveTo(baseValue*x, baseValue*y);
    }

    @Override
    public void lineTo(float x, float y) {
        super.lineTo(baseValue*x, baseValue*y);
    }

    @Override
    public void rLineTo(float dx, float dy) {
        super.rLineTo(baseValue*dx, baseValue*dy);
    }

    @Override
    public void rMoveTo(float dx, float dy) {
        super.rMoveTo(baseValue*dx, baseValue*dy);
    }
}