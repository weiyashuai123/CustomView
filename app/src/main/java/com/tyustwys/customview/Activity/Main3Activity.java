package com.tyustwys.customview.Activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tyustwys.customview.R;

public class Main3Activity extends AppCompatActivity {
    private Button btn_do,btn_next;
    private TextView txt_context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn_do = (Button) findViewById(R.id.btn_3);
        btn_next = (Button) findViewById(R.id.btn_3_next);
        txt_context = (TextView) findViewById(R.id.txt_3);
        btn_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObjectAnimator down = ObjectAnimator.ofFloat(txt_context, "translationY", -100, 0);
                down.setDuration(2000);
                down.start();
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });

    }
}
