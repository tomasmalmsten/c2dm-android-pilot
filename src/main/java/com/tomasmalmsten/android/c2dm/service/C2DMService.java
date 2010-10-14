package com.tomasmalmsten.android.c2dm.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.tomasmalmsten.android.c2dm.Constants;

public class C2DMService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(Constants.TAG, "I was awakend by C2DM!");
        return new Binder();
    }
}
