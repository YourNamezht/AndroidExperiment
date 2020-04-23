package com.akid.androidexperiment.program;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.akid.androidexperiment.MainActivity;
import com.akid.androidexperiment.R;
import com.akid.androidexperiment.program.program5.IntentDemo;
import com.akid.androidexperiment.program.program5.SubActivity1;
import com.akid.androidexperiment.program.program5.SubActivity2;
import com.akid.androidexperiment.program.service.MyBroadcastReceiver;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

public class Program5 extends AppCompatActivity {

    private static final int SUBACTIVITY1 = 1;
    private static final int SUBACTIVITY2 = 2;

    private TextView textView;
    private EditText entryText;

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

        /*
        * IntentResolutionDemo
        * 会根据用户的数据类型打开相应的Activity。比如 tel:13400010001打开拨号程序，
        * http://www.g.cn则会打开浏览器等。
        * 参考链接：https://blog.csdn.net/chenyijun/article/details/39393349
        */
        QMUIRoundButton qmuiRoundButton4 = (QMUIRoundButton)findViewById(R.id.program5_3_btn1);
        qmuiRoundButton4.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
        QMUIRoundButton qmuiRoundButton5 = (QMUIRoundButton)findViewById(R.id.program5_3_btn2);
        qmuiRoundButton5.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:13400010001"));
                startActivity(intent);
            }
        });

        /*
        * 4.BroadcastReceiverDemo
        * 这里我们会向MyBroadcastReceiver.class这里发送消息
        * 并且需要在AndroidManifest.xml声明MyBroadcastReceiver可以接收消息
        * 参考链接：https://blog.csdn.net/DayDayPlayPhone/article/details/52579577
        * */
        entryText = (EditText)findViewById(R.id.program5_4_EditText1);
        QMUIRoundButton qmuiRoundButton6 = (QMUIRoundButton)findViewById(R.id.program5_4_btn1);
        qmuiRoundButton6.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Program5.this, MyBroadcastReceiver.class);
                intent.putExtra("message", entryText.getText().toString());
                sendBroadcast(intent);
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
