package com.akid.androidexperiment.program.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MathService extends Service {

    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        // 这里需要声明为public
        public MathService getService() {
            return MathService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "本地绑定：MathService",
                Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent){
        Toast.makeText(this, "取消本地绑定：MathService",
                Toast.LENGTH_SHORT).show();
        return false;
    }


    public long Add(long a, long b){
        return a+b;
    }

}
