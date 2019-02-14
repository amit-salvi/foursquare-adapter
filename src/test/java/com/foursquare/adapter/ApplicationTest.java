package com.foursquare.adapter;

import com.foursquare.adapter.config.JasyptEncryptionConfig;
import com.foursquare.adapter.constants.FoursquareAdapterConstants;
import com.foursquare.adapter.service.PropertyService;
import com.jayway.restassured.RestAssured;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JasyptEncryptionConfig.class)
@TestPropertySource("classpath:./test.properties")
@ActiveProfiles(FoursquareAdapterConstants.TEST_PROFILE)
public class ApplicationTest {

    @Autowired
    @Qualifier("PropertyService")
    PropertyService service;

    @Test
    public void testMethod() {
        Assertions.assertTrue(true);
    }

    @Test
    public void testFourSquareRest_WithoutAuthDetails() {
        int statusCode = RestAssured.get("https://api.foursquare.com/v2/venues/explore").statusCode();
        Assertions.assertEquals(statusCode, 400);
    }

    @Test
    public void testFourSquareRest_WithTestAuthDetails() {
        Assertions.assertNotNull(service);

        String clientId = service.getClientId();
        String clientSecret = service.getClientSecret();
        Assertions.assertNotNull(clientId);
        Assertions.assertNotNull(clientSecret);
        String URL = "https://api.foursquare.com/v2/venues/explore?near=NYC&client_id="
                + clientId
                + "&client_secret="
                + clientSecret
                + "&v=20190219";
        int statusCode =
                RestAssured.get(URL).statusCode();
        Assertions.assertEquals(statusCode, 400);
    }
}