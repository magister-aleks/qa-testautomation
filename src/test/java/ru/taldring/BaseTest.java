package ru.taldring;

import io.restassured.specification.RequestSpecification;
import ru.taldring.rest.Client;

public class BaseTest {

    static RequestSpecification restClient = Client.requestSpec();
}
