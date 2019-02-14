package com.foursquare.adapter.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static com.foursquare.adapter.constants.FoursquareAdapterConstants.DEV_PROFILE;
import static com.foursquare.adapter.constants.FoursquareAdapterConstants.PROD_PROFILE;

@Service("PropertyService")
@Profile({DEV_PROFILE, PROD_PROFILE})
public class PropertyServiceForJasyptSimple implements PropertyService {

    @Value("${clientid.property}")
    private String clientId;

    @Value("${client.secret.property}")
    private String clientSecret;

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
