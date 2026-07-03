package io.github.bichdao090202.tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;


public abstract class BaseTest {
    @BeforeClass
    public void setup(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
