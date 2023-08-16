package ru.taldring;

import io.restassured.specification.RequestSpecification;
import ru.taldring.rest.BaseClient;
import ru.taldring.rest.HttpBinClient;

public class BaseTest {

    static RequestSpecification httpbinClient = new HttpBinClient().requestSpec;
}
