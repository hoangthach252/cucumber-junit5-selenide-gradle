# Automation Framework using Cucumber JVM6 + JUnit5 + Selenide + Gradle + Allure + logback

A sample BDD Automation framework using Cucumber6, JUnit 5, Selenide, Gradle, Allure, logback.

Support running tests in parallel, sharing data among test steps and manage Page Objects using Dependency Injection.

Sample tests against [Unsplash](https://unsplash.com/) web app.

## Libraries Used

* [Junit](https://junit.org/junit5/docs/current/user-guide/) - 5.7.2
* [Gradle](https://gradle.org/guides) - 7.6
* [Cucumber](https://cucumber.io/docs/cucumber/) - 6.11.0
* [Selenide](https://selenide.org/documentation.html) - 5.24.0
* [Selenide wiki](https://github.com/selenide/selenide/wiki)
* [PicoContainer](https://github.com/cucumber/cucumber-jvm/tree/main/picocontainer) - 6.11.0
* [Allure](https://docs.qameta.io/allure/) - 2.14.0
* [Allure-Selenide](https://selenide.org/documentation/reports.html) - 2.14.0
* [Allure-Cucumber](https://docs.qameta.io/allure/#_cucumber_jvm) - 2.14.0
* [Logback](http://logback.qos.ch/manual/index.html) - 1.2.5
* [AssertJ](https://assertj.github.io/doc/) - 3.20.2

Reference Links:
* [cucumber-junit-platform-engine](https://github.com/cucumber/cucumber-jvm/tree/main/cucumber-junit-platform-engine)

## Run/Debug tests

* run all tests in parallel, number of threads can be specified in CukesTestRunner or junit-platform.properties or from command:

    $ gradlew -Dcucumber.execution.parallel.config.fixed.parallelism=3 clean test --info

* run all tests with specific tag.

    $ gradlew -Dcucumber.filter.tags=@id-002 clean test --info

* run all tests in `firefox` browser.

    $ gradlew -Dselenide.browser=firefox clean test --info

* Debug test on IntelliJ IDE.
Trigger Debug using CukesTestRunner.java.


After the tests are ran, you can see:
* logs from file appender under `build/logs/log.log`
* Allure results `build/allure-results`

## ScenarioContext

Represents test context to save/get test data and share it among test steps in one Cucumber scenario.

Example:
<code>
scenarioContext.setContext(DataItem.COLLECTION_NAME, collectionName);
</code>

<code>
String collectionName = (String) scenarioContext.getContext(DataItem.COLLECTION_NAME);
</code>

## DataStorage
Represents a storage to store test data and handle clean up after each Cucumber scenario.

Example:
<code>
dataStorage.setCollectionNames(collectionName);
</code>


## Allure reports
Allure report will contain framework logs, Selenide browser interaction logs, screenshots and page sources for
failing test cases

* [Allure CLI](https://docs.qameta.io/allure/#_commandline) should be installed
* Allure results stored in `build/allure-results`
* To generate allure report, first navigate to unsplash directory then run command:

    $ allure serve



## Logback configuration

You can find logback configuration here `src/test/resources/logback.xml`

Current configuration contains two appenders:
(default log level: INFO)

* ConsoleAppender will output logs to system out stream
* FileAppender will output logs to `build/logs/log.log`