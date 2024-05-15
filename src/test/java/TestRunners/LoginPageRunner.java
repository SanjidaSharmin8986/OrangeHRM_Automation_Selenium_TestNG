package TestRunners;

import Config.Setup;
import Pages.LoginPage;
import Pages.PIMPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageRunner extends Setup {
    @Test (priority = 1, description = "Admin can't login with wrong password")
    public void LoginwithWrongPass() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("admin", "admin123456");
        Assert.assertEquals((driver.findElement(By.className("oxd-alert-content-text")).getText()),"Invalid credentials");
    }
    @Test (priority = 2, description = "Admin can't login using wrong username")
    public void LoginwithWrongUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("AAADDDMMIINNN", "admin123");
        Assert.assertEquals((driver.findElement(By.className("oxd-alert-content-text")).getText()),"Invalid credentials");
    }

    @Test(priority = 3, description = "Admin can't login with empty password field or empty username field")
    public void LoginwithEmptyPassandEmptyUsername() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("", "");
        Assert.assertTrue((driver.findElements(By.className("oxd-input-field-error-message")).get(0).getText()).contains("Required"));
        Assert.assertTrue((driver.findElements(By.className("oxd-input-field-error-message")).get(1).getText()).contains("Required"));

    }
    @Test (priority = 4, groups = "smoke", description = "Admin can login successfully using valid username and right password")
    public void LoginwithValidCred() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin","admin123");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
        String Actualheader = driver.findElement(By.tagName("h6")).getText();
        Assert.assertEquals(Actualheader,"Dashboard");
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());
    }

}
