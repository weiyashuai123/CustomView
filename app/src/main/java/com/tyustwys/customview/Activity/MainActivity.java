package com.tyustwys.customview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tyustwys.customview.R;
import com.tyustwys.customview.View.MyView1;
import com.tyustwys.customview.enity.ViewData1;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MyView1 view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 = (MyView1) findViewById(R.id.myView1);
        Button btn_rand = (Button) findViewById(R.id.btn_view1);
        ArrayList<ViewData1> datas = new ArrayList<>();
        ViewData1 data1 = new ViewData1("s",25);
        ViewData1 data2 = new ViewData1("s",25);
        ViewData1 data3 = new ViewData1("s",25);
        ViewData1 data4 = new ViewData1("s",25);
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);
        view1.setData(datas);
        view1.setStartAngle(270);
        btn_rand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<ViewData1> datas = new ArrayList<>();
                int x = 100;
                Random rand = new Random();
                while ( x > 0) {
                    int percent = rand.nextInt(x)+1;
                    x = x - percent;
                    ViewData1 data = new ViewData1("s",percent);
                    datas.add(data);
                }
                view1.setData(datas);
                view1.setStartAngle(270);
            }
        });
    }
}
