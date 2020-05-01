package com.akid.androidexperiment.program;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akid.androidexperiment.R;
import com.akid.androidexperiment.program.service.RandomService;
import com.akid.androidexperiment.program.service.RandomService2;
import com.qmuiteam.qmui.widget.roundwidget.QMUIRoundButton;

public class Program6 extends AppCompatActivity {

    // 6.2的变量
    private static Handler handler = new Handler();
    private static TextView labelView = null;
    private static double randomDouble ;

    public static void UpdateGUI(double refreshDouble){
        randomDouble = refreshDouble;
        handler.post(RefreshLable);
    }

    private static Runnable RefreshLable = new Runnable(){
        @Override
        public void run() {
            labelView.setText(String.valueOf(randomDouble));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program6);
        setTitle(R.string.program6);

        // 6.1
        QMUIRoundButton startButton = (QMUIRoundButton)findViewById(R.id.program6_1_start);
        QMUIRoundButton stopButton = (QMUIRoundButton)findViewById(R.id.program6_1_stop);

        final Intent serviceIntent = new Intent(this, RandomService.class);

        startButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                startService(serviceIntent);
            }
        });

        stopButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                stopService(serviceIntent);
            }
        });
        // 6.2
        labelView = (TextView)findViewById(R.id.program6_2_text);
        QMUIRoundButton startButton2 = (QMUIRoundButton)findViewById(R.id.program6_2_start);
        QMUIRoundButton stopButton2 = (QMUIRoundButton)findViewById(R.id.program6_2_stop);

        final Intent serviceIntent2 = new Intent(this, RandomService2.class);

        startButton2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                startService(serviceIntent2);
            }
        });

        stopButton2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                stopService(serviceIntent2);
            }
        });

    }
}
