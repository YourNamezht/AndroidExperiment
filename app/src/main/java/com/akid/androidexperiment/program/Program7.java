package com.akid.androidexperiment.program;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.akid.androidexperiment.R;
import com.akid.androidexperiment.program.program7.Program71;
import com.akid.androidexperiment.program.program7.Program72;
import com.akid.androidexperiment.program.program7.Program73;
import com.akid.androidexperiment.program.program7.Program74;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

public class Program7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program7);
        setTitle(R.string.program7);

        // 设置1. 程序跳转
        QMUIRoundButton qmuiRoundButton1 = findViewById(R.id.program7_1_btn);
        qmuiRoundButton1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Program7.this, Program71.class);
                startActivity(i);
            }
        });

        // 设置2. 程序跳转
        QMUIRoundButton qmuiRoundButton2 = findViewById(R.id.program7_2_btn);
        qmuiRoundButton2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Program7.this, Program72.class);
                startActivity(i);
            }
        });

        // 设置3. 程序跳转
        QMUIRoundButton qmuiRoundButton3 = findViewById(R.id.program7_3_btn);
        qmuiRoundButton3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Program7.this, Program73.class);
                startActivity(i);
            }
        });

        // 设置4. 程序跳转
        QMUIRoundButton qmuiRoundButton4 = findViewById(R.id.program7_4_btn);
        qmuiRoundButton4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Program7.this, Program74.class);
                startActivity(i);
            }
        });
    }
}
