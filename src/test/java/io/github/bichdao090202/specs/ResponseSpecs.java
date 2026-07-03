package io.github.bichdao090202.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;


public class ResponseSpecs {


    public static ResponseSpecification status200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }


    public static ResponseSpecification status201() {
        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }


}
