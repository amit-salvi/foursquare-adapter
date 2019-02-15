package com.foursquare.adapter.rest;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecommendedPlacesControllerTest {

    @MockBean
    RecommendedPlacesController controller;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        // given
        BDDMockito.given(controller.getRecommendedPlaces("LON"))
                .willReturn(null);

        // when
        ResponseEntity responseEntity = restTemplate.getForEntity("/places/LON", String.class);
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(responseEntity.getStatusCode().getReasonPhrase(), "OK");
    }

}