package io.github.bichdao090202.utils;

import io.restassured.response.Response;


import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class SchemaValidator {


    public static void validate(Response response, String schema) {
        response.then().body(matchesJsonSchemaInClasspath(schema));
    }
}

