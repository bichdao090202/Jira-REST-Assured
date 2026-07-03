package io.github.bichdao090202.tests;

import io.github.bichdao090202.clients.ProjectClient;
import io.restassured.response.Response;
import io.github.bichdao090202.builders.ProjectDataBuilder;
import io.github.bichdao090202.payloads.request.CreateProjectRequest;
import io.github.bichdao090202.payloads.response.CreateProjectResponse;
import io.github.bichdao090202.specs.ResponseSpecs;
import io.github.bichdao090202.utils.Log;
import io.github.bichdao090202.utils.SchemaValidator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProjectAPITest extends BaseTest {
    ProjectClient projectClient = new ProjectClient();
    protected static final Log logger = new Log(ProjectAPITest.class);


    @Test
    public void getListProject() {
        logger.info("===== Test: Get list project =====");


        logger.info("Step 1: Send GET /project");
        Response response = projectClient.getProjects();


        logger.info("Step 2: Verify status code = 201");
        response.then().spec(ResponseSpecs.status200());
    }


    @Test
    public void Project_1_POST_POS() {
        logger.info("===== Test: Create project successfully =====");


        logger.info("Step 1: Build create project request");
        CreateProjectRequest request = ProjectDataBuilder
                .validProject().build();


        logger.info("Step 2: Send POST /project");
        Response response = projectClient.createProject(request);


        logger.info("Step 3: Verify status code = 201");
        response.then().spec(ResponseSpecs.status201());


        logger.info("Step 4: Verify response project key");
        CreateProjectResponse res = response.as(CreateProjectResponse.class);
        Assert.assertEquals(request.getKey(), res.getKey());


        logger.info("Step 5: Verify response schema");
        SchemaValidator.validate(response, "schema/create-project-response.json");
    }
}
