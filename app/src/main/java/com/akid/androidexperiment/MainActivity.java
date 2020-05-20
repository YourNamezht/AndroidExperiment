package com.akid.androidexperiment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akid.androidexperiment.program.Program4;
import com.akid.androidexperiment.program.Program5;
import com.akid.androidexperiment.program.Program6;
import com.akid.androidexperiment.program.Program7;
import com.akid.androidexperiment.program.Program8;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置跳转
        // 实验四
        QMUIRoundButton qmuiRoundButton4 = findViewById(R.id.btn_4);
        qmuiRoundButton4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Program4.class);
                startActivity(i);
            }
        });
        // 实验五
        QMUIRoundButton qmuiRoundButton5 = findViewById(R.id.btn_5);
        qmuiRoundButton5.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Program5.class);
                startActivity(i);
            }
        });
        // 实验六
        QMUIRoundButton qmuiRoundButton6 = findViewById(R.id.btn_6);
        qmuiRoundButton6.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Program6.class);
                startActivity(i);
            }
        });
        // 实验七
        QMUIRoundButton qmuiRoundButton7 = findViewById(R.id.btn_7);
        qmuiRoundButton7.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Program7.class);
                startActivity(i);
            }
        });
        // 实验八
        QMUIRoundButton qmuiRoundButton8 = findViewById(R.id.btn_8);
        qmuiRoundButton8.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Program8.class);
                startActivity(i);
            }
        });

    }
}
