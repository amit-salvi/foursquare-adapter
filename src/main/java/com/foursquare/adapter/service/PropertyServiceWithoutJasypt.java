package com.foursquare.adapter.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import static com.foursquare.adapter.constants.FoursquareAdapterConstants.TEST_PROFILE;

@Service("PropertyService")
@Profile({TEST_PROFILE})
public class PropertyServiceWithoutJasypt implements PropertyService {

    private final String clientId = "clientId";

    private final String clientSecret = "clientSecret";

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
