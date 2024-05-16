
# OrangeHRM_Automation_Selenium_TestNG

## About this project:
 [OrangeHRM](https://opensource-demo.orangehrmlive.com/) is a Human Resources Management Software. In this project, I have automated some key features of this site using Selenium TestNG. I have automated positive and negative test cases for this automation process.

### Work Scenarios:
 - Admin will log in to [OrangeHRM](https://opensource-demo.orangehrmlive.com/) and assert that the login is successful.
 - Then the admin will create a new employee with a randomly generated 8-digit password, which is a combination of lower-case, and upper-case letters, digits, and special characters. The new employee's information will be saved in a JSON file, asserting that the employee has been created successfully.
 - After that, the admin will search for the employee using his employee ID and the employee's name and assert that the employee is successfully found.
 - Then the admin will log out and the newly created employee will log in, along with the assertion that the employee login is successful.
 - Employee will change his gender and set his blood group to O+.
 - Lastly, the employee will update his blood group to AB- and log out from the site.

#### Test case file
 https://docs.google.com/spreadsheets/d/1QKn0RaPXtsCTrvvkBCncEsVzEDstaoAwC6uall1-XFA/edit?usp=sharing

## Prerequisite
- JDK
- Gradle

## Tools and Technology used:
- Intellij IDEA
- Selenium Webdriver
- TestNG framework
- Allure

## How to run this project:
- Clone this project using this [link](https://github.com/SanjidaSharmin8986/OrangeHRM_Automation_Selenium_TestNG)
- Give the following command in the terminal to run the Regression Test Suite ( All positive and negative test cases)
   - ``` gradle clean test -Psuitename="RegressionMaster.xml"```
- Give the following command in the terminal to run the Smoke Test Suite (Only positive test cases)
   - ``` gradle clean test -Psuitename="SmokeMaster.xml"```
- To generate an Allure Report use the following commands -
   - ```allure serve allure-results```
   - ```allure generate allure-results --clean -output```

## Allure Report

 ### Regression Test:
  
   ![RegressionOverview](https://github.com/SanjidaSharmin8986/OrangeHRM_Automation_Selenium_TestNG/assets/156296801/198da1e5-43fe-494f-95e1-f381f1313c21)


  ![RegressionBehaviour](https://github.com/SanjidaSharmin8986/OrangeHRM_Automation_Selenium_TestNG/assets/156296801/1100d9d4-7da3-48f5-ba47-9f5d9899275f)

 ### Smoke Test:

  ![SmokeOverview](https://github.com/SanjidaSharmin8986/OrangeHRM_Automation_Selenium_TestNG/assets/156296801/99c3f029-0594-4e8d-8843-c71e9d594cc5)

  ![SmokeBehaviour](https://github.com/SanjidaSharmin8986/OrangeHRM_Automation_Selenium_TestNG/assets/156296801/61607dd1-17c4-4f95-ae8c-8fdb2a61e163)

## Visual Representation of this project:

 ### Regression Test:

 https://github.com/SanjidaSharmin8986/Automated_WebformSubmit_JUnit/assets/156296801/6c42dae1-07fe-433d-a2f5-60289c587e0e

 ### Smoke Test:

 https://github.com/SanjidaSharmin8986/Automated_WebformSubmit_JUnit/assets/156296801/33c463c7-3fb5-40be-a983-5b522b9cbf00






  


