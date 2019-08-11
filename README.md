
# java-web-automation  
  
## Pre-requisites  
  
**Maven:** 3.6.1  
**Java:**  1.8.0_20  
**Default Chrome:** ChromeDriver 76.0.3809.68  
**IDE:** IntelliJ IDEA  
  
  
## Project Structure  
This projects is a example of how to use Java, Selenium, TestNG and Maven

|   Tools             |Reason                          |
|----------------|-------------------------------
|Selenium        |Used to interact with the browser  
|Maven			 | Used as dependency manager and will help to execute the tests and CI/CD
|TestNG			 | Testing Framework


### Structure
|   Path             | Item                          |
|----------------|-------------------------------
|testng.xml        |Handle TestNG configuration. It has the set of test to be executed and its parementers
|pom.xml        |Handle Maven configuration. It has the set of libraries used in the project and It has the plugins needed to execute the tests correctly in a CI/CD env.
|src/test/java/interactions        | This package handles all the browsers interactions using the Selenium methods
|src/test/java/pages        | This package have the POM classes used by the tests
|src/test/java/seleniumTests        |Contains the tests to be executed
|src/test/java/seleniumTests/utilities        |Handles the logic to select the right ChormeDriver depending on the OS where the tests are executed
|resources        |Contains the ChromeDriver executable files

#### Configurations

 - TestNG parameters: Each test in the testng.xml file has it own parameter allowing expand the functionality of searching keyworkd just adding different values or adding a DataProvider.
 - Surface Maven Plugin: At the POM file there is the surface pluging that allow us to executure TestNG using Maven, super usefull when It is integrated at a CI/CD pipeline
 - Driver Class: Driver class at `src/test/java/seleniumTests/utilities` allow the tests to be executed at any OS without having to change the code. It autodetects the OS and depending on that returns an instance of the right ChromeDriver
 - `FindAll` method at GoogleResultsPage `line: 28`: It is an advance option provider by PageFactroy API that allow us to group a set of element into the same list so all those can handle as a single list.
 - `Selectors section`: Each POM class has a selector section, the main reason for that is that all the class can use them to locate those especific elements without duplicate code.