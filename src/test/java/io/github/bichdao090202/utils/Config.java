package io.github.bichdao090202.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {


    private static final Dotenv dotenv = Dotenv.load();


    public static String username() {
        return dotenv.get("JIRA_USERNAME");
    }


    public static String password() {
        return dotenv.get("JIRA_PASSWORD");
    }


    public static String baseUrl() {
        return ConfigReader.getProperty("base.url");
    }


    public static String userid() {
        return ConfigReader.getProperty("user.id");
    }
}
