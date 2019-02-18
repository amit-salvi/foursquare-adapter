package com.foursquare.adapter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import static com.foursquare.adapter.constants.FoursquareAdapterConstants.DEV_PROFILE;
import static com.foursquare.adapter.constants.FoursquareAdapterConstants.PROD_PROFILE;
import static com.foursquare.adapter.constants.FoursquareAdapterConstants.TEST_PROFILE;

@Configuration
@PropertySource("encryption.properties")
@Profile({DEV_PROFILE, PROD_PROFILE, TEST_PROFILE})
@ComponentScan(value = "com.foursquare.adapter")
public class JasyptEncryptionConfig {
}
