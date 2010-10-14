package com.tomasmalmsten.android.c2dm.registration;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

class RegistrationIDRegistrar {

    private static final String REGISTER_NEW_DEVICE = "register_device";
    private static final String NODE_ID_PARAMETER = "nodeid";
    private static final String REGISTRATION_IS_PARAMETER = "registrationid";
    private final String url;
    static final String MASHMOBILE_C2DM_SERVER_URL = "http://10.0.1.3:8888";


    private RegistrationIDRegistrar(String url) {
        this.url = url;
    }

    void registerIdWithC2DMService(final String registrationId) throws RegistrationException {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        String nodeId = "realNodeId";
        final String requestUrl = createRegistrationUrl(registrationId, nodeId);
        HttpGet request = new HttpGet(requestUrl);
        try {
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                throw new RegistrationException(String.format(
                        "Could not register %s with the server.", registrationId),
                        requestUrl, statusCode);
            }
        } catch (IOException e) {
            throw new RegistrationException(String.format(
                    "Registration of %s failed.", registrationId), requestUrl, e);
        }
    }

    /**
     * @param registrationId
     * @param nodeId
     * @return Returns a String built of this.url + / + REGISTER_NEW_DEVICE +
     *  ? + NODE_ID_PARAMETER + = + nodeId + & + REGISTRATION_ID_PARAMETER + = +
     *  registrationId
     */
    private String createRegistrationUrl(String registrationId, String nodeId) {
        return String.format("%s/%s?%s=%s&%s=%s",
                url, REGISTER_NEW_DEVICE, NODE_ID_PARAMETER, nodeId,
                REGISTRATION_IS_PARAMETER, registrationId);
    }

    static RegistrationIDRegistrar getInstance() {
        return new RegistrationIDRegistrar(MASHMOBILE_C2DM_SERVER_URL);
    }
}
