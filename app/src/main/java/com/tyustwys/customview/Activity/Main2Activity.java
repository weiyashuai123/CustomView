package com.tyustwys.customview.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.tyustwys.customview.R;
import com.tyustwys.customview.util.CircularAnim;

public class Main2Activity extends AppCompatActivity {
    private Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ImageView img = (ImageView) findViewById(R.id.img_view2);
        final Button b1 = (Button) findViewById(R.id.btn_1_view2);
        final Button b2 = (Button) findViewById(R.id.btn_2_view2);
        final Button b3 = (Button) findViewById(R.id.btn_3_view2);
        final Button b4 = (Button) findViewById(R.id.btn_4_view2);
        final LinearLayout ll = (LinearLayout) findViewById(R.id.ll_v2);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag) {
                    CircularAnim.hide(ll).triggerView(img).go();
                }else {
                    CircularAnim.show(ll).triggerView(img).go();
                }
                flag = !flag;
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CircularAnim.fullActivity(Main2Activity.this,view).colorOrImageRes(R.color.colorAccent).go(new CircularAnim.OnAnimationEndListener() {
                    @Override
                    public void onAnimationEnd() {
                        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}
