# selenium-java-testng-reports
This project demonstrates how to use TestNG Listeners, Extent Report and take screenshots on test failure in Selenium tests.

Requirements:
Java 8 or later
Selenium WebDriver
TestNG
Extent Reports library
Getting Started
Clone the repository
Clone this repository to your local machine using the following command:

bash
Copy code
git clone https://github.com/[YOUR-USERNAME]/selenium-java-testng-listeners-extent-report-screenshot.git

Build and Run the tests:
Navigate to the root directory of the project.

Use the following command to build the project:
Copy code
mvn clean install
Run the tests using the following command:
bash
Copy code
mvn test

TestNG Listeners:
A TestNG listener is an interface that you can use to extend the functionality of TestNG. You can use a listener to run custom code before or after a test method is executed, or when a test suite starts or ends.

In this project, we have created UI scripts for handling multiple windows using windowHandles with a custom listener class TestListener that extends the TestListenerAdapter class provided by TestNG. This listener class implements the following methods:

Understanding Window Handles:
In Selenium WebDriver, each window or tab in a browser is represented by a unique window handle. You can use the getWindowHandles method of the WebDriver interface to get a set of all window handles for the current browser instance. You can then use the switchTo method of the WebDriver interface to switch to a specific window handle.

onTestFailure: This method is called when a test fails. In this method, we take a screenshot of the browser window and save it to the file system.
Extent Reports
Extent Reports is a popular reporting library for automated tests. It provides an easy-to-use interface for creating HTML reports that display test results, including information about test status, test steps, and any exceptions that were thrown during the test.

In this project, we have integrated Extent Reports with TestNG by using the TestListener class. In the onTestStart method of the listener class, we create an instance of the Extent Reports class and set the report file name and location. In the onTestSuccess and onTestFailure methods, we add information about the test to the report, including the status, test name, and any exceptions that were thrown.

Screenshot on Failure:
In the event of a test failure, it can be helpful to take a screenshot of the browser window to help diagnose the problem. In this project, we have implemented this functionality in the onTestFailure method of the TestListener class. When a test fails, this method takes a screenshot of the browser window and saves it to the file system. The file name of the screenshot is the name of the test method that failed, with a timestamp appended to it.

Conclusion
By using TestNG Listeners, Extent Reports and taking screenshots on test failure, you can greatly enhance the reliability and usefulness of your Selenium tests. With the example code provided for Window Handles in this project, you should be able to easily integrate these tools into your own Selenium projects.
