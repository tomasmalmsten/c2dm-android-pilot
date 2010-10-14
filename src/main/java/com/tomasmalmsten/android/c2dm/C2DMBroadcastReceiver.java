package com.tomasmalmsten.android.c2dm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tomasmalmsten.android.c2dm.service.C2DMService;
import com.tomasmalmsten.android.c2dm.registration.RegistrationIDReceiver;

/**
 * Receives messages sent from the C2DM service and passes them to an Android
 * service that can then deal with then as needed.
 */
public class C2DMBroadcastReceiver extends BroadcastReceiver {
    
    @Override
    public final void onReceive(Context context, Intent intent) {
        if (Constants.RECEIVED_REGISTRATION_ID_FROM_GOOGLE.equals(intent.getAction())) {
            Log.d(Constants.TAG, "Received a registration ID from Google.");
            intent.setAction(Constants.REGISTRATION_INTENT);
            intent.setClassName(context, RegistrationIDReceiver.class.getName());
        } else if (Constants.RECEIVED_C2DM_MESSAGE_FROM_GOOGLE.equals(intent.getAction())) {
            Log.d(Constants.TAG, "Received a C2DM message from Google.");
            intent.setAction(Constants.START_C2DM_SERVICE);
            intent.setClass(context, C2DMService.class);
        }
        context.startService(intent);
    }
}
