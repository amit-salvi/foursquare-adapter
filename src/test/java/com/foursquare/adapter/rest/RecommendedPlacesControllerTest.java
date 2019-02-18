package com.foursquare.adapter.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foursquare.adapter.model.Response;
import com.foursquare.adapter.service.PropertyService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("TEST")
public class RecommendedPlacesControllerTest {

    @MockBean
    RecommendedPlacesController controller;

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    @Qualifier("PropertyService")
    PropertyService propertyService;

    @Test
    public void testRestResponseWhenSuccess() throws Exception {
        // given
        ResponseEntity responseEntity = new ResponseEntity<>(jsonResponse(), HttpStatus.OK);
        given(controller.getRecommendedPlaces("london", "food"))
                .willReturn(responseEntity);

        // when
        ResponseEntity response = restTemplate.getForEntity("/places/london?category=food", Response.class);

        // then
        assertNotNull(response);
        assertEquals(response.getStatusCode().getReasonPhrase(), "OK");
        verify(controller, times(1)).getRecommendedPlaces("london", "food");
    }

    @Test
    public void testRestResonseWhenFailure() throws Exception {
        // given
        ResponseEntity mockedResponse = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        given(controller.getRecommendedPlaces("123", "123"))
                .willReturn(mockedResponse);

        // when
        ResponseEntity responseEntity = restTemplate.getForEntity("/places/123?category=123", Response.class);

        // then
        assertNotNull(responseEntity);
        assertEquals("Bad Request", responseEntity.getStatusCode().getReasonPhrase());
        verify(controller, times(1)).getRecommendedPlaces("123", "123");;
    }

    @Test
    public void testServiceCircuitBreaker() {
        // given
        given(controller.getRecommendedPlaces("london", "food"))
                .willAnswer(invocationOnMock -> {
                    ResponseEntity responseEntity = new ResponseEntity<>(jsonResponse(), HttpStatus.BAD_GATEWAY);
                    try{
                        Thread.sleep(11000);
                    } catch (Exception e) {}
                    return responseEntity;
                });

        // when
        ResponseEntity response = restTemplate.getForEntity("/places/london?category=food", Response.class);

        // then
        assertNotNull(response);
        assertEquals(response.getStatusCode().getReasonPhrase(), "Bad Gateway");
        verify(controller, times(1)).getRecommendedPlaces("london", "food");
    }

    @Test
    public void testMockedPropertyService() {
        Assertions.assertNotNull(propertyService);
        Assertions.assertEquals("clientId", propertyService.getClientId());
        Assertions.assertEquals("clientSecret", propertyService.getClientSecret());
    }

    private Response jsonResponse() {
        Response recommendedPlace = null;
        try (Stream<String> lines = Files.lines(Paths.get("src/test/resources/sample.json"))) {
            String data = lines.collect(Collectors.joining("\n"));
            assertNotNull(data);
            lines.close();
            ObjectMapper mapper = new ObjectMapper();
            recommendedPlace = mapper.readValue(data, Response.class);
        } catch (Exception e) {
        }
        return recommendedPlace;
    }
}