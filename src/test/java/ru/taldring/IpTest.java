package ru.taldring;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.taldring.model.Origin;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class IpTest extends BaseTest {

    private Origin myOrigin;

    @BeforeEach
    public void init() {
        // given
        myOrigin = new Origin();
        myOrigin.setOrigin("172.17.0.1");
    }

    @Test
    public void userAgentTest() {
        httpbinClient
                .get("/user-agent")
                .then()
                    .statusCode(anyOf(is(SC_OK), is(SC_CREATED)))
                    .body("size()", is(1));
    }

    @Test
    @DisplayName("GET /ip test")
    public void ipTest() {

        //when GET /ip
        Origin ua = httpbinClient
                .when()
                    .get("/ip")
                .then()
                    .extract()
                    .body()
                    .as(Origin.class);

        // then object is the same
        Assertions.assertEquals(ua, myOrigin);
    }

    @Test
    @DisplayName("Origin model serialization test")
    public void ipSerializationTest() {

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
