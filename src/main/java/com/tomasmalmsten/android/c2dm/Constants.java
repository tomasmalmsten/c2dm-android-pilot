package com.tomasmalmsten.android.c2dm;

public class Constants {
    public static final String TAG = "c2dm";

    public static final String REGISTRATION_INTENT = "com.tomasmalmsten.android.c2dm.intent.REGISTER";
    public static final String SEND_REGISTRATION_TO_GOOGLE = "com.google.android.c2dm.intent.REGISTER";
    public static final String RECEIVED_REGISTRATION_ID_FROM_GOOGLE = "com.google.android.c2dm.intent.REGISTRATION";
    public static final String RECEIVED_C2DM_MESSAGE_FROM_GOOGLE = "com.google.android.c2dm.intent.RECEIVE";
    public static final String START_C2DM_SERVICE = "com.tomasmalmsten.android.c2dm.intent.START_SERVICE";
    /**
     * The C2DM Application server ID needs to be a valid GMail account that
     * also has been accepted to partake in C2DM. For more info see the official
     * website at: http://code.google.com/intl/sv-SE/android/c2dm/index.html
     */
    public static final String C2DM_APPLICATION_SERVER_ID = "c2dmvalidaccount@gmail.com";

    private Constants() {
    }
}
