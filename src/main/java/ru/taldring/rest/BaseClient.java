package ru.taldring.rest;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseClient {

    public static RequestSpecification requestSpec() {
        RequestSpecification req =
        RestAssured
                .given()
                .filter(new RequestLoggingFilter())
                .filter(new ResponseLoggingFilter());
        log.info("Init restAssured client");
        return req;
    }
}
