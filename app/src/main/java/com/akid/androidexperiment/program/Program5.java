package com.akid.androidexperiment.program;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akid.androidexperiment.MainActivity;
import com.akid.androidexperiment.R;
import com.akid.androidexperiment.program.program5.IntentDemo;
import com.akid.androidexperiment.program.program5.SubActivity1;
import com.akid.androidexperiment.program.program5.SubActivity2;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

public class Program5 extends AppCompatActivity {

    private static final int SUBACTIVITY1 = 1;
    private static final int SUBACTIVITY2 = 2;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program5);
        setTitle(R.string.program5);

        // IntentDemo
        // 通过Id获取按钮 为按钮添加点击事件
        QMUIRoundButton qmuiRoundButton1 = (QMUIRoundButton)findViewById(R.id.program5_1_btn);
        qmuiRoundButton1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Program5.this, IntentDemo.class);
                startActivity(i);
            }
        });

        // ActivityCommunication
        textView = (TextView)findViewById(R.id.program5_2_textview);
        QMUIRoundButton qmuiRoundButton2 = (QMUIRoundButton)findViewById(R.id.program5_2_btn1);
        QMUIRoundButton qmuiRoundButton3= (QMUIRoundButton)findViewById(R.id.program5_2_btn2);

        qmuiRoundButton2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Program5.this, SubActivity1.class);
                startActivityForResult(intent, SUBACTIVITY1);
            }
        });
        qmuiRoundButton3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Program5.this, SubActivity2.class);
                startActivityForResult(intent, SUBACTIVITY2);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("Result:",String.valueOf(resultCode));

        switch(requestCode){
            case SUBACTIVITY1:
                Log.e("Result:","这里执行了");
                if (resultCode == RESULT_OK){
                    Uri uriData = data.getData();
                    textView.setText(uriData.toString());
                }
                break;
            case SUBACTIVITY2:
                break;
        }
    }

}
