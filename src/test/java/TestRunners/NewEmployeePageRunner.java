package TestRunners;

import Config.Scrolling;
import Config.Setup;
import Pages.LoginPage;
import Pages.LogoutPAge;
import Pages.NewEmployeePage;
import Utils.SaveUsers;
import org.checkerframework.checker.units.qual.N;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class NewEmployeePageRunner extends Setup {
@Test(priority = 1, description = "Employee try to login with invalid or wrong credentials")
public void userLoginwithInvalidCred() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.doLogin("Employee", "admin1234");
    Assert.assertEquals((driver.findElement(By.className("oxd-alert-content-text")).getText()),"Invalid credentials");
}
@Test(priority = 2, groups = "smoke", description = "Employee login with valid credentials")
public void LoginwithValidCred() throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        SaveUsers users = new SaveUsers();
        JSONArray userArr = users.getUser();
        JSONObject userObj = (JSONObject) userArr.get(userArr.size()-1) ;
        String username = userObj.get("username").toString();
        String password = userObj.get("password").toString();
        loginPage.doLogin(username,password);
        Assert.assertTrue((driver.findElement(By.className("oxd-userdropdown-name")).getText()).contains(username));
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        String Actualheader = driver.findElement(By.tagName("h6")).getText();
        Assert.assertEquals(Actualheader,"Dashboard");
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());
    }
    @Test(priority = 3, description = "Employee edit his Gender")
    public void changeGender() throws InterruptedException {
        NewEmployeePage newEmployeePage = new NewEmployeePage(driver);
        newEmployeePage.clickMyinfo();
        Scrolling scrolling = new Scrolling();
        scrolling.scroll(driver,0,250);
        newEmployeePage.changeGender();
        scrolling.scroll(driver,0,500);
    }
    @Test(priority = 4, description = "Employee edit his blood group")
    public void changeBloodType() throws InterruptedException {
        NewEmployeePage newEmployeePage = new NewEmployeePage(driver);
        newEmployeePage.changeBloodType();
        newEmployeePage.save();
    }
    @Test(priority = 5, groups = "smoke", description = "Employee update his blood group")
    public void upDateBloodGroup() throws InterruptedException {
        NewEmployeePage newEmployeePage = new NewEmployeePage(driver);
        newEmployeePage.clickMyinfo();
        Scrolling scrolling = new Scrolling();
        scrolling.scroll(driver,0,500);
        newEmployeePage.upDateBloodGroup();
        newEmployeePage.save();
    }
    @Test(priority = 6, groups = "smoke", description ="Employee logout successfully")
    public void doLogout() throws InterruptedException {
        LogoutPAge logoutPAge = new LogoutPAge(driver);
        logoutPAge.doLogout();
        assertTrue(driver.getCurrentUrl().contains("login"));
        assertTrue((driver.findElement(By.className("orangehrm-login-title")).getText()).contains("Login"));
    }
}
