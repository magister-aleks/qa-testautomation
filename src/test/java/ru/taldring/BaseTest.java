package ru.taldring;

import io.restassured.specification.RequestSpecification;
import ru.taldring.rest.BaseClient;

public class BaseTest {

    static RequestSpecification restClient = BaseClient.requestSpec();
}
