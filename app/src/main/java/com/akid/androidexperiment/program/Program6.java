package com.akid.androidexperiment.program;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.akid.androidexperiment.R;
import com.akid.androidexperiment.program.service.IMathService;
import com.akid.androidexperiment.program.service.MathService;
import com.akid.androidexperiment.program.service.MathService2;
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

    // 6.3 变量 函数
    private MathService mathService;
    private boolean isBound = false;
    private static TextView labelView3 = null;

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mathService = ((MathService.LocalBinder)service).getService();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mathService = null;
        }
    };

    // 6.4 变量 函数
    private static TextView labelView4;
    private boolean isBound4 = false;
    private IMathService iMathService ;
    //  创建ServiceConnection对象
    private ServiceConnection serviceConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            // 获得AIDL服务对象
            iMathService = IMathService.Stub.asInterface(service);

        }
        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            iMathService = null;
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

        // 6.3
        labelView3 = (TextView)findViewById(R.id.program6_3_text);
        Button bindButton = (Button)findViewById(R.id.program6_3_bind);
        Button unbindButton = (Button)findViewById(R.id.program6_3_unbind);
        Button computButton = (Button)findViewById(R.id.program6_3_compute);

        bindButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            if(!isBound){
                final Intent serviceIntent = new Intent(Program6.this,MathService.class);
                bindService(serviceIntent,mConnection, Context.BIND_AUTO_CREATE);
                isBound = true;
            }
            }
        });

        unbindButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            if(isBound){
                isBound = false;
                unbindService(mConnection);
                mathService = null;
            }
            }
        });
        computButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mathService == null){
                    labelView3.setText("未绑定服务");
                    return;
                }
                long a = Math.round(Math.random()*100);
                long b = Math.round(Math.random()*100);
                long result = mathService.Add(a, b);
                String msg = String.valueOf(a)+" + "+String.valueOf(b)+
                        " = "+String.valueOf(result);
                labelView3.setText(msg);
            }
        });


        // 6.4
        labelView4 = (TextView)findViewById(R.id.program6_4_text);
        Button bindButton4 = (Button)findViewById(R.id.program6_4_bind);
        Button unbindButton4 = (Button)findViewById(R.id.program6_4_unbind);
        Button computButton4 = (Button)findViewById(R.id.program6_4_compute);

        bindButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!isBound4){
                    final Intent serviceIntent = new Intent(Program6.this,MathService2.class);
                    bindService(serviceIntent,serviceConnection, Context.BIND_AUTO_CREATE);
                    isBound4 = true;
                }
            }
        });
        unbindButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(isBound4){
                    isBound4 = false;
                    unbindService(serviceConnection);
                    iMathService = null;
                }
            }
        });
        computButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (iMathService == null){
                    labelView4.setText("未绑定服务");
                    return;
                }
                long a = Math.round(Math.random()*100);
                long b = Math.round(Math.random()*100);
                long result = 0;
                try{
                    result = iMathService.Add(a, b);
                }
                catch (Exception ex){
                    Log.e("ahahhah","错误");
                }
                String msg = String.valueOf(a)+" + "+String.valueOf(b)+
                        " = "+String.valueOf(result);
                labelView4.setText(msg);
            }
        });

    }




}
