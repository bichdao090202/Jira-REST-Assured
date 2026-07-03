package io.github.bichdao090202.clients;

import io.restassured.specification.RequestSpecification;
import io.github.bichdao090202.specs.RequestSpecs;


public abstract class BaseClient {


    protected RequestSpecification spec(){
        return RequestSpecs.defaultSpec();
    }


}
