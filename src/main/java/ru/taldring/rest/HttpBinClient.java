package ru.taldring.rest;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class HttpBinClient extends BaseClient {

    public static final String BASE_URL = "http://localhost:80";
    public RequestSpecification requestSpec =
            requestSpec()
                    .baseUri(BASE_URL)
                    .contentType(ContentType.JSON)
                    .accept(ContentType.JSON);
}
