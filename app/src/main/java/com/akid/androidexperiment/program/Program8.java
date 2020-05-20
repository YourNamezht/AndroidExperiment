package com.akid.androidexperiment.program;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akid.androidexperiment.R;
import com.akid.androidexperiment.program.program8.Program81;
import com.akid.androidexperiment.program.program8.Program82;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

public class Program8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program8);

        // 设置1. 程序跳转
        QMUIRoundButton qmuiRoundButton1 = findViewById(R.id.program8_1_btn);
        qmuiRoundButton1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Program8.this, Program81.class);
                startActivity(i);
            }
        });

        // 设置2. 程序跳转
        QMUIRoundButton qmuiRoundButton2 = findViewById(R.id.program8_2_btn);
        qmuiRoundButton2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Program8.this, Program82.class);
                startActivity(i);
            }
        });
    }
}
