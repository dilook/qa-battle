## E2E test framework for qa-battle application

### Technologies
Java 8, Gradle, JUnit, Selenide, Cucumber, Allure

### Prerequisites
1. Install Java 8, Gradle 5, IDE, Google Chrome
2. Add Lombok, Cucumber For Java and Gherkin plugins to IDE.

### Structure
<pre>
├─ main
│  ├─ core                      - common elements (application/UI constants).
│  ├─ pages                     - Page Objects.
|  |  ├─ BasePage.class         - base page with common methods. It's base class for every page
│  ├─ utils                     - utility classes.
|  |  ├─ ConfigReader.class     - read application config properties from resources\config.properties file.
|  │  ├─ FileUtils.class        - helper class for working with files
|  |  ├─ StringUtils.class      - helper class for working with strings
├─ test
│  ├─ features                  - cucumber feature files
│  ├─ runners                   - runners for feature files
|  |  ├─ common
|  |  |  ├─ BaseRunner.class    - common logic for WebDriver setup/teardown. It's base class for every runner
│  ├─ steps                     - cucumber steps definitions and hooks
</pre>

### Config properties
Location: {PROJECT_DIR}\src\main\resources
<pre>
webdriver.base.url - application URL (default - http://localhost:8080)
webdriver.driver - browser (default - chrome)
webdriver.timeout - WebDriver timeout (default - 10000 ms)
download.path - path to browser download folder
</pre>

### Run tests
Framework supports parallel test execution. By default, 3 features can be run simultaneously (maxParallelForks = 3).
* run tests with gradle:
```
> gradle clean test
```
* To run specific tests from IDE, right click on the runners class (like LoginFeatureRunner) and press Run

### Generate test report
Allure framework is used for reporting. For failed test screenshot is attached to report.
* generate report with gradle:
```
> gradle allureReport
```
By default, report can be found in {PROJECT_DIR}\build\reports\allure-report directory

### Code style check
Added possibility to check code base with checkstyle plugin in accordance with Google coding conventions for Google Java Style (only for main package, test package is excluded)
* generate checkstyle report
```
> gradle checkstyleMain
```

