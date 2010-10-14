package com.tomasmalmsten.android.c2dm.registration;

import java.io.IOException;

public class RegistrationException extends Exception {
    private final String usedUrl;
    private final int responseCode;

    public RegistrationException(String message, String usedUrl, int responseCode) {
        super(message);
        this.usedUrl = usedUrl;
        this.responseCode = responseCode;
    }

    public RegistrationException(String message, Throwable cause) {
        super(message, cause);
        usedUrl = "";
        responseCode = 0;
    }

    public RegistrationException(String message, String usedUrl, IOException e) {
        super(message, e);
        this.usedUrl = usedUrl;
        responseCode = 0;
    }

    @Override
    public String getMessage() {
        return String.format("%s; URL: %s; Response code: %d",
                super.getMessage(), usedUrl, responseCode);
    }
}
