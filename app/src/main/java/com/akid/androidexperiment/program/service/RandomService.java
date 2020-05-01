package com.akid.androidexperiment.program.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class RandomService extends Service {

        @Override
        public void onCreate() {
            super.onCreate();
            Toast.makeText(this, "(1) 调用onCreate()",
                    Toast.LENGTH_LONG).show();
        }

        // 这里原来的onstart已经过时了
        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            int flag = super.onStartCommand(intent,flags,startId);
            Toast.makeText(this, "(2) 调用onStart()",
                    Toast.LENGTH_SHORT).show();

            double randomDouble = Math.random();
            String msg = "随机数："+ String.valueOf(randomDouble);
            Toast.makeText(this,msg, Toast.LENGTH_SHORT).show();
            return flag;
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Toast.makeText(this, "(3) 调用onDestroy()",
                    Toast.LENGTH_SHORT).show();
        }


        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

    }
