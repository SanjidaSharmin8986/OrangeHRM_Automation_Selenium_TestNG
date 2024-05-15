package TestRunners;

import Config.RandomPassword;
import Config.Setup;
import Pages.LoginPage;
import Pages.LogoutPAge;
import Pages.PIMPage;
import Utils.SaveUsers;
import com.github.javafaker.Faker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class PIMPageRunner extends Setup {
    @BeforeTest (groups = "smoke", description = "Admin can login successfully using valid username and right password")
    public void LoginwithValidCred() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin","admin123");
        assertTrue(driver.getCurrentUrl().contains("dashboard"));
        String Actualheader = driver.findElement(By.tagName("h6")).getText();
        Assert.assertEquals(Actualheader,"Dashboard");
        assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());
    }
    @Test(priority = 1, description = "Employee can not be created withput employee's firstname & lastname")
    public void createNewEmployeewithoutEmployeeName() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickPIMmenu();
        assertTrue((driver.getCurrentUrl()).contains("pim"));
        assertTrue((driver.findElement(By.className("oxd-topbar-header-breadcrumb-module")).getText()).contains("PIM"));
        pimPage.createEmployee("","","7777","Testusername","123456");
        Assert.assertTrue((driver.findElements(By.className("oxd-input-field-error-message")).get(0).getText()).contains("Required"));
        Assert.assertTrue((driver.findElements(By.className("oxd-input-field-error-message")).get(1).getText()).contains("Required"));
    }
   @Test(priority = 2, description = "Admin try to create employee with the invalid username format")
    public void createEmployeewithInvalidUsername() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickPIMmenu();
        assertTrue((driver.getCurrentUrl()).contains("pim"));
        assertTrue((driver.findElement(By.className("oxd-topbar-header-breadcrumb-module")).getText()).contains("PIM"));
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String empId= (faker.random().nextInt(1000,2000)).toString();
        RandomPassword randomPassword = new RandomPassword();
        String password = randomPassword.password();
        pimPage.createEmployee(firstname,lastname,empId,"user",password);
        Assert.assertTrue((driver.findElement(By.className("oxd-input-field-error-message")).getText()).contains("Should be at least 5 characters"));
    }
    @Test(priority = 3, description = "Admin try to create employee with invalid password format")
    public void createEmployeewithInvalidPassword() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickPIMmenu();
        assertTrue((driver.getCurrentUrl()).contains("pim"));
        assertTrue((driver.findElement(By.className("oxd-topbar-header-breadcrumb-module")).getText()).contains("PIM"));
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String username = firstname + " "+lastname;
        String empId= (faker.random().nextInt(1000,2000)).toString();
        pimPage.createEmployee(firstname,lastname,empId,username,"111111");
        Assert.assertTrue((driver.findElement(By.className("oxd-input-field-error-message")).getText()).contains("Should have at least 7 characters"));
    }
    @Test(priority = 4, description = "Admin try to create employee with a password that mismatched with confirm password")
    public void createEmployeewithMismatchedPassword() throws InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickPIMmenu();
        assertTrue((driver.getCurrentUrl()).contains("pim"));
        assertTrue((driver.findElement(By.className("oxd-topbar-header-breadcrumb-module")).getText()).contains("PIM"));
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String username = firstname + " "+lastname;
        String empId= (faker.random().nextInt(1000,2000)).toString();RandomPassword randomPassword = new RandomPassword();
        String password = randomPassword.password();
        pimPage.createEmployeewithMismatchedPassword(firstname,lastname,empId,username,password,"111111");
        Assert.assertTrue((driver.findElement(By.className("oxd-input-field-error-message")).getText()).contains("Passwords do not match"));

    }
    @Test(priority = 5, description = "Admin create an employee with all valid and required info")
    public void createNewEmployee() throws InterruptedException, IOException, ParseException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.clickPIMmenu();
        assertTrue((driver.getCurrentUrl()).contains("pim"));
        assertTrue((driver.findElement(By.className("oxd-topbar-header-breadcrumb-module")).getText()).contains("PIM"));
        Faker faker = new Faker();
        String firstname = faker.name().firstName();
        String lastname = faker.name().lastName();
        String username = firstname + " "+lastname;
        String empId= (faker.random().nextInt(1000,2000)).toString();
        RandomPassword randomPassword = new RandomPassword();
        String password = randomPassword.password();
        pimPage.createEmployee(firstname,lastname,empId,username,password);
        SaveUsers saveUsers = new SaveUsers();
        saveUsers.userSave(firstname,lastname,empId,username,password);
        Thread.sleep(4000);
        assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"));
        assertTrue(driver.findElements(By.className("orangehrm-main-title")).get(0).getText().contains("Personal Details"));
    }

    @Test(priority =6, groups = "smoke", description = "Admin search for an employee using valid employeeid")
    public void SearchByValidid() throws IOException, ParseException, InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        SaveUsers saveUsers = new SaveUsers();
        JSONArray empArr=  saveUsers.getUser();
        JSONObject empobj= (JSONObject) empArr.get(empArr.size()-1);
        String employeeId = empobj.get("employeeid").toString();
        pimPage.SearchByid(employeeId);
        Thread.sleep(3000);
        Assert.assertTrue((driver.findElements(By.className("oxd-text")).get(14).getText()).contains("(1) Record Found"));
        Assert.assertTrue((driver.findElements(By.className("oxd-table-cell")).get(1).getText()).contains(employeeId));
    }
    @Test(priority = 7, description = "Admin try to search for an employee using invalid employee name")
    public void SearchByInvalidName() throws IOException, ParseException, InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        pimPage.SearchByName("1ffSDdfdsfg");
        Assert.assertTrue((driver.findElement(By.className("oxd-input-field-error-message")).getText()).contains("Invalid"));
    }

    @Test(priority = 8, description = "Admin try to search for an employee using valid employee name")
    public void SearchByValidName() throws IOException, ParseException, InterruptedException {
        PIMPage pimPage = new PIMPage(driver);
        SaveUsers saveUsers = new SaveUsers();
        JSONArray empArr=  saveUsers.getUser();
        JSONObject empobj= (JSONObject) empArr.get(empArr.size()-1);
        String empname =empobj.get("firstname").toString();
        pimPage.SearchByName(empname);
        Assert.assertTrue((driver.findElements(By.className("oxd-text")).get(14).getText()).contains("(1) Record Found"));
    }
   @Test(priority = 9, groups = "smoke", description = "Logout Successfully from Admin Account")
    public void doLogout() throws InterruptedException {
        LogoutPAge logoutPAge = new LogoutPAge(driver);
        logoutPAge.doLogout();
        assertTrue(driver.getCurrentUrl().contains("login"));
        assertTrue((driver.findElement(By.className("orangehrm-login-title")).getText()).contains("Login"));
    }
}
