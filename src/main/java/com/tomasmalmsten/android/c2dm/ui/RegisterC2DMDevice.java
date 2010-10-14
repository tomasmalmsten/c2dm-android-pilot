package com.tomasmalmsten.android.c2dm.ui;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tomasmalmsten.android.c2dm.Constants;
import com.tomasmalmsten.android.c2dm.R;

/**
 * This class is the entry point to the pilot. It allows the user to trigger the
 * C2DM registration process by clicking a button.
 */
public class RegisterC2DMDevice extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void sendRequest(View ignored) {
        Intent registrationIntent = new Intent(Constants.SEND_REGISTRATION_TO_GOOGLE);
        iHaveNoClueWhatThisSettingDoesButItIsRequiredForTheIntentToWorkSoIBetterSetIt(registrationIntent);
        registrationIntent.putExtra("sender", Constants.C2DM_APPLICATION_SERVER_ID);
        startService(registrationIntent);
    }

    private void iHaveNoClueWhatThisSettingDoesButItIsRequiredForTheIntentToWorkSoIBetterSetIt(Intent registrationIntent) {
        registrationIntent.putExtra("app", PendingIntent.getBroadcast(this, 0, new Intent(), 0));
    }
}
