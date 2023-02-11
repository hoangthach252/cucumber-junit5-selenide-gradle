package com.unsplash.cucumber.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.unsplash.utils.PropertyUtils;

import io.qameta.allure.selenide.AllureSelenide;

import static com.codeborne.selenide.Browsers.*;

public class WebDriverFactory {

    public static void getWebDriverInstance(){
        createWebDriver();
    }

    public static void closeWebDriverInstance(){
        shutdownWebDriver();
    }

    private static void createWebDriver(){
        String  browser =               PropertyUtils.getPropString(    "selenide.browser",             "selenide.properties");
        Boolean headless =              PropertyUtils.getPropBoolean(   "selenide.headless",            "selenide.properties");
        String  pageLoadStrategy =      PropertyUtils.getPropString(    "selenide.pageloading.strategy","selenide.properties");
        Integer timeout =               PropertyUtils.getPropInteger(   "selenide.timeout",             "selenide.properties");
        Boolean remoteExecution =       PropertyUtils.getPropBoolean(   "selenide.remote.execution",    "selenide.properties");
        String  remoteHost =            PropertyUtils.getPropString(    "selenide.remote.host",         "selenide.properties");

        if(remoteExecution){
            Configuration.remote = remoteHost;
        }

        switch (browser) {
            case IE:
                Configuration.fastSetValue = true;
                break;
            case CHROME:
                Configuration.headless = headless;
                break;
            case FIREFOX:
            case EDGE:
                break;
            default:
                System.out.println("No previously known web browser is specified," +
                        " please check properties file for any missmatch. Specified browser is: " + browser);
                break;
        }
        Configuration.browser = browser;
        Configuration.timeout = timeout;
        Configuration.startMaximized = true;
        Configuration.pageLoadStrategy = pageLoadStrategy;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    private static void shutdownWebDriver(){
        WebDriverRunner.closeWebDriver();
    }

}
