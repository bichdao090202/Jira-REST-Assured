package io.github.bichdao090202.builders;

import io.github.bichdao090202.payloads.request.CreateProjectRequest;
import io.github.bichdao090202.utils.Config;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;


public class ProjectDataBuilder {


    private static final Faker faker = new Faker();


    public static CreateProjectRequest.CreateProjectRequestBuilder validProject() {
        return CreateProjectRequest.builder()
                .key(randomProjectKey())
                .name(faker.company().industry() + " Project")
                .projectTypeKey(randomProjectType())
                .leadAccountId(Config.userid());
    }


    private static String randomProjectKey() {
        return RandomStringUtils.randomAlphabetic(3).toUpperCase();
    }


    private static String randomProjectType() {
        return faker.bool().bool() ? "software" : "business";
    }
}

