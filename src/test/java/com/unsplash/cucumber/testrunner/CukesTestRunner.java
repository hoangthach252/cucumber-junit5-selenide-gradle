package com.unsplash.cucumber.testrunner;

import io.cucumber.junit.platform.engine.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("features")
@IncludeEngines("cucumber")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "com.unsplash.cucumber.steps")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME, value = "@regression and not @ignore")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm")
public class CukesTestRunner {
    // These configuration parameters also can be set in junit-platform.properties.
    // priority order: ConfigurationParameter > environment variables > junit-platform.properties
}