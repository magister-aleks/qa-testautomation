package ru.taldring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.taldring.model.Origin;

public class HttpBinTest extends BaseTest {

    @Test
    public void userAgentTest() {
        restClient
                .contentType(ContentType.JSON)
                .get("http://localhost:80/user-agent")
                .then().statusCode(200);
    }

    @Test
    public void ipSerializationTest() {
        // given
        Origin myOrigin = new Origin();
        myOrigin.setOrigin("172.17.0.1");

        //when GET /ip
        Origin ua = restClient
                .contentType(ContentType.JSON)
                .get("http://localhost:80/ip")
                .as(Origin.class);

        // then object is the same
        Assertions.assertEquals(ua, myOrigin);

        // when serialize an deserialize object
        ObjectMapper om = new ObjectMapper();
        String strIp = null;
        try {
            strIp = om.writeValueAsString(myOrigin);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Origin originAfter;
        try {
            originAfter = om.readValue(strIp, Origin.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        // then object is the same
        Assertions.assertEquals(originAfter, myOrigin);
    }
}
