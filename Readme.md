
In the provided framework, I added a method that runs before all tests, which removes 
the items from the cart before each test. I also added a method that ensures a logout 
is performed after each test, so that no test leaves the user logged in.  

------------------------------------------------------------------------------------

In the login tests, I added a parameterized test that iterates through all the 
enums (users) from the enum/TestData.


------------------------------------------------------------------------------------










  

## Description

This project structure represents a Test Automation Framework. The main components are organized as follows:

### Core Package
- `BaseApiService.java`: Contains base methods for API service
- `BaseApiTest.java`: Includes common setup and teardown methods for API tests.
- `BaseWebPage.java`: Contains base methods for web page interactions.
- `BaseWebTest.java`: Includes common setup and teardown methods for web tests.

### Enums Package
- `BrowserMode.java`: Enum for different browser modes (e.g., headless, normal).
- `BrowserType.java`: Enum for supported browser types.
- `FrameworkSettings.java`: Enum for framework configuration settings.
- `Driver.java`: Class for managing the WebDriver instance.
- `DriverManager.java`: Manages WebDriver creation and lifecycle.
- `PropertiesManager.java`: Manages framework properties and configurations.

### Resources
The `resources` folder configuration files, test data, or other non-Java resources.

### Test
The `test` folder is where test classes would be placed, following a similar package structure as the `main` folder.

## Usage

This framework supports both API and Web testing, with a focus on providing base classes and utilities for test creation and execution. Developers can extend the base classes and utilize the provided enums and managers to create robust and maintainable automated tests.