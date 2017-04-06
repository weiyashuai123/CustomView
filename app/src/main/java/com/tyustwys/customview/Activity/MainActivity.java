package com.tyustwys.customview.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tyustwys.customview.R;
import com.tyustwys.customview.View.MyView1;
import com.tyustwys.customview.enity.ViewData1;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private MyView1 view1;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view1 = (MyView1) findViewById(R.id.myView1);
        Button btn_rand = (Button) findViewById(R.id.btn_view1);
        Button btn_next = (Button) findViewById(R.id.btn_next_v1);
        img = (ImageView) findViewById(R.id.img_view1);
        ArrayList<ViewData1> datas = new ArrayList<>();
        for (int i = 0 ; i<8 ; i++){
            ViewData1 data1 = new ViewData1("王乐傻逼"+i,12.5f);
            datas.add(data1);
        }
        view1.setData(datas);
        view1.setStartAngle(270);
        btn_rand.setText("转转转");
        btn_rand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                img.animate().rotationBy(new Random().nextInt(360)+720);
//                ArrayList<ViewData1> datas = new ArrayList<>();
//                int x = 100;
//                int y = 1;
//                Random rand = new Random();
//                while ( x > 0) {
//                    int percent = rand.nextInt(x)+1;
//                    x = x - percent;
//                    ViewData1 data = new ViewData1("s"+y,percent);
//                    datas.add(data);
//                    y++;
//                }
//                view1.setData(datas);
//                view1.setStartAngle(270);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
