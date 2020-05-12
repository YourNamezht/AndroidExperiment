package com.akid.androidexperiment.program.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class MathService2 extends Service {

    private final IMathService.Stub mBinder = new IMathService.Stub() {
        public long Add(long a, long b) {
            return a + b;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "远程绑定：MathService",
                Toast.LENGTH_SHORT).show();
        return mBinder;
    }

    @Override
    public boolean onUnbind (Intent intent){
        Toast.makeText(this, "取消远程绑定：MathService",
                Toast.LENGTH_SHORT).show();
        return false;
    }

}
