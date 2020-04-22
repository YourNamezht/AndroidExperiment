package com.akid.androidexperiment.program;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.akid.androidexperiment.R;
import com.akid.androidexperiment.program.program4.MyContextMenu;
import com.akid.androidexperiment.program.program4.TabDemo;
import com.qmuiteam.qmui.alpha.QMUIAlphaImageButton;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

public class Program4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program4);
        setTitle(R.string.program4);

        // 设置1.ButtonDemo 程序事件
        QMUIRoundButton qmuiRoundButton = findViewById(R.id.buttonDefault1);
        QMUIAlphaImageButton qmuiAlphaImageButton = findViewById(R.id.buttonImage1);
        qmuiRoundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Program4.this, "Button按钮", Toast.LENGTH_SHORT).show();
            }
        });
        qmuiAlphaImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Program4.this, "ImageButton按钮", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置2.Checkbox 程序事件
        final TextView textView = (TextView)findViewById(R.id.program4_text2);
        //(1)CheckBox
        final CheckBox checkBox1= (CheckBox)findViewById(R.id.CheckBox01);
        final CheckBox checkBox2= (CheckBox)findViewById(R.id.CheckBox02);
        CheckBox.OnClickListener checkboxListener = new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
            switch(v.getId()){
                case R.id.CheckBox01:
                    textView.setText("CheckBox01, isChecked:"+String.valueOf(checkBox1.isChecked()));
                    Toast.makeText(Program4.this, "CheckBox01, isChecked:"+String.valueOf(checkBox1.isChecked()), Toast.LENGTH_SHORT).show();
                    return;
                case R.id.CheckBox02:
                    textView.setText("CheckBox02, isChecked:"+String.valueOf(checkBox2.isChecked()));
                    Toast.makeText(Program4.this, "CheckBox01, isChecked:"+String.valueOf(checkBox1.isChecked()), Toast.LENGTH_SHORT).show();
                    return;
            }
        }};
        checkBox1.setOnClickListener(checkboxListener);
        checkBox2.setOnClickListener(checkboxListener);
        //(2)RadioButton
        final RadioButton radioButton1 = (RadioButton)findViewById(R.id.RadioButton01);
        final RadioButton radioButton2 = (RadioButton)findViewById(R.id.RadioButton02);
        RadioButton.OnClickListener radioButtonListener = new RadioButton.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.RadioButton01:
                        textView.setText("RadioButton1 is selected");
                        Toast.makeText(Program4.this, "RadioButton1 is selected", Toast.LENGTH_SHORT).show();
                        return;
                    case R.id.RadioButton02:
                        textView.setText("RadioButton2 is selected");
                        Toast.makeText(Program4.this, "RadioButton2 is selected", Toast.LENGTH_SHORT).show();
                        return;
                }
            }
        };
        radioButton1.setOnClickListener(radioButtonListener);
        radioButton2.setOnClickListener(radioButtonListener);

        // 设置3.“TabDemo”程序跳转
        QMUIRoundButton qmuiRoundButton3 = findViewById(R.id.program4_3_btn);
        qmuiRoundButton3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Program4.this, TabDemo.class);
                startActivity(i);
            }
        });

        // 设置4.“MyContextMenu”程序跳转
        QMUIRoundButton qmuiRoundButton4 = findViewById(R.id.program4_4_btn);
        qmuiRoundButton4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Program4.this, MyContextMenu.class);
                startActivity(i);
            }
        });
    }
}
