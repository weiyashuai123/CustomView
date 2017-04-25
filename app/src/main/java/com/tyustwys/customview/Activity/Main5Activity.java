package com.tyustwys.customview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tyustwys.customview.R;
import com.tyustwys.customview.View.PowerChart;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        PowerChart pc = (PowerChart) findViewById(R.id.pc);
        pc.setData(new String[]{"能力1", "能力2", "能力3", "能力4", "能力5"}, new int[]{10,10,10,10,50});

    }
}
