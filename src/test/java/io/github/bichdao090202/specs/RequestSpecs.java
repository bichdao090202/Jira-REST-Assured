package io.github.bichdao090202.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.github.bichdao090202.utils.Config;


public class RequestSpecs {


    private static RequestSpecification commonSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(Config.baseUrl())
                .setAuth(
                        RestAssured
                                .preemptive()
                                .basic(
                                        Config.username(),
                                        Config.password()
                                )
                )
                .setContentType("application/json")
                .build();
    }


    public static RequestSpecification defaultSpec() {
        return commonSpec();
    }
}

