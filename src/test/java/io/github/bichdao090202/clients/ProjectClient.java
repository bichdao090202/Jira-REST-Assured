package io.github.bichdao090202.clients;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


import io.github.bichdao090202.endpoints.ProjectEndpoints;
import io.github.bichdao090202.payloads.request.CreateProjectRequest;




public class ProjectClient extends BaseClient {


    public Response getProjects(){
        return given()
                .filter(new AllureRestAssured())
                .spec(spec())
                .when()
                .get(ProjectEndpoints.PROJECTS);
    }


    public Response createProject(CreateProjectRequest request){
        return given()
                .filter(new AllureRestAssured())
                .spec(spec())
                .body(request)
                .when()
                .post(ProjectEndpoints.PROJECTS);
    }


}
