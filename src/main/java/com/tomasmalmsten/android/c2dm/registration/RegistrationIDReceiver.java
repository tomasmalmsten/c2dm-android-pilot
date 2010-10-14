package com.tomasmalmsten.android.c2dm.registration;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import com.tomasmalmsten.android.c2dm.Constants;

public class RegistrationIDReceiver extends IntentService {
    private final RegistrationIDRegistrar registrar =
            RegistrationIDRegistrar.getInstance();
    private static final String EXTRA_ERROR = "error";
    private static final String EXTRA_REGISTRATION_ID = "registration_id";

    public RegistrationIDReceiver() {
        super(Constants.C2DM_APPLICATION_SERVER_ID);
    }

    @Override
    public final void onHandleIntent(Intent intent) {
        Log.d(Constants.TAG, "Received intent to register");
        final String registrationId = intent.getStringExtra(
                EXTRA_REGISTRATION_ID);
        String error = intent.getStringExtra(EXTRA_ERROR);
        if (error == null) {
            registerDevice(registrationId);
        } else {
            handleRegistrationError(error);
        }
    }

    private void registerDevice(String registrationId) {
        Log.d(Constants.TAG, "Will now register device with ID: " +
                registrationId);
        try {
            registrar.registerIdWithC2DMService(registrationId);
        } catch (RegistrationException e) {
            Log.e(Constants.TAG, e.getMessage(), e);
        }
    }

    private void handleRegistrationError(String error) {
        Log.e(Constants.TAG, "Registration error " + error);
        Log.e(Constants.TAG,
                "Please click the registration button again to register the device.");
    }
}
