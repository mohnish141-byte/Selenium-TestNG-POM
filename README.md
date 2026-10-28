# Selenium TestNG POM
**Java UI automation practice project for MyCarHelpline.**

A QA automation portfolio project covering browser interactions, assertions, page objects, waits, and test reporting.

## Technology
| Area | Tools |
| --- | --- |
| Language | Java |
| Browser automation | Selenium WebDriver, Chrome |
| Test runner | TestNG |
| Dependencies | Maven |
| Reporting | ExtentReports |
| Driver management | WebDriverManager / Selenium Manager |

## Project structure
| Path | Purpose |
| --- | --- |
| `src/test/java/base/` | Shared browser lifecycle |
| `src/test/java/pages/` | Page objects and page interactions |
| `src/test/java/testcases/` | Test classes and Selenium exercises |
| `src/test/java/utilities/` | Extent report manager and TestNG listener |
| `testng.xml` | Suite selection and listener configuration |

The suite includes homepage checks, car search, fuel calculator, comparison, used-car valuation, XPath, and wait examples. Some classes are standalone practice tests; page objects are not used by every test. The current `LoginTest` checks the homepage title rather than a complete authentication flow.

## Getting started
Install a compatible JDK, Maven, and Google Chrome. Ensure `java -version` and `mvn -version` work.

```bash
git clone https://github.com/mohnish141-byte/Selenium-TestNG-POM.git
cd Selenium-TestNG-POM
mvn test -Dsurefire.suiteXmlFiles=testng.xml
```

Alternatively, import the project as an existing Maven project in Eclipse or IntelliJ and run `testng.xml` as a TestNG suite. Maven compiler settings may need to be aligned with the installed JDK; the current POM does not pin a Java release.

## Reports
When the configured TestNG listener runs, ExtentReports writes `test-output/ExtentReport.html`. Maven also writes execution results under `target/surefire-reports/`.

## Execution notes
Tests depend on a third-party website and can be affected by page changes, connectivity, popups, or timing. Existing committed reports are historical artifacts, not evidence of the latest run. Run the suite locally to assess current results.

## Author
[Mohnish Saxena](https://github.com/mohnish141-byte) · QA Automation
