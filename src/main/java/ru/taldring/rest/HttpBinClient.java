package ru.taldring.rest;

import io.restassured.specification.RequestSpecification;

public class HttpBinClient extends BaseClient {
    public RequestSpecification requestSpec =
            requestSpec()
                    .baseUri("http://localhost:80");
}
