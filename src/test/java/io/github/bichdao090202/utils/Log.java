package io.github.bichdao090202.utils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import io.qameta.allure.Allure;


public class Log {
    private final Logger log;
    private final String className;


    public Log(Class<?> clazz) {
        this.log = LoggerFactory.getLogger(clazz);
        this.className = clazz.getName();
    }


    private String now() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }


    private String format(String type, String message) {
        return "[" + now() + "] " + type + "  " + className + " - " + message;
    }


    private String style(String type, String formattedText) {
        switch (type) {
            case "INFO":
                return "<b>" + formattedText + "</b>";


            case "VERIFY":
                return "<b><i>" + formattedText + "</i></b>";


            case "STEP":
            default:
                return formattedText;
        }
    }


    private void writeToAll(String type, String message) {
        // log4j
        switch (type) {
            case "STEP":
            case "INFO":
            case "VERIFY":
                log.info(message);
                break;
            case "WARN":
                log.warn(message);
                break;
            case "ERROR":
                log.error(message);
                break;
            default:
                log.info(message);
        }


        //testNG report
        String formatted = format(type, message);
        Reporter.log(style(type, formatted) + "<br>");


        //allure report
        Allure.step(message);
    }


    public void step(String message) {
        writeToAll("STEP", message);
    }


    public void info(String message) {
        writeToAll("INFO", message);
    }


    public void verify(String message) {
        writeToAll("VERIFY", message);
    }


    public void warn(String message) {
        writeToAll("WARN", message);
    }


    public void fail(String message) {
        writeToAll("ERROR", message);
    }
}
