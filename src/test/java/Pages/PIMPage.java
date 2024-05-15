package Pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PIMPage {
    public PIMPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "oxd-main-menu-item--name")
    List <WebElement> leftSideMenu;
    @FindBy(className = "bi-plus")
    WebElement btnAddEmployee;
    @FindBy(name="firstName")
    WebElement txtFirstname;
    @FindBy(name="lastName")
    WebElement txtLastname;
    @FindBy(className = "oxd-switch-input")
    WebElement btnLoginActive;
    @FindBy(className = "oxd-input")
    List <WebElement> txtloginCred;
    @FindBy(className = "oxd-button")
    List <WebElement> btnSave;
    @FindBy(xpath = "//input[contains(@placeholder,'Type for hints...')]")
    WebElement txtEmpName;
    public void clickPIMmenu() throws InterruptedException {
        leftSideMenu.get(1).click();
        Thread.sleep(2000);
    }
    public void createEmployee(String firstname, String lastname,String employeeid,String username, String password) throws InterruptedException {
        btnAddEmployee.click();
        Thread.sleep(3000);
        txtFirstname.sendKeys(firstname);
        txtLastname.sendKeys(lastname);
        txtloginCred.get(4).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        Thread.sleep(2000);
        txtloginCred.get(4).sendKeys(employeeid);
        btnLoginActive.click();
        txtloginCred.get(5).sendKeys(username);
        txtloginCred.get(6).sendKeys(password);
        txtloginCred.get(7).sendKeys(password);
        btnSave.get(1).click();
        Thread.sleep(3000);
    }
    public void createEmployeewithMismatchedPassword(String firstname, String lastname,String employeeid,String username, String password, String confirmPass) throws InterruptedException {
        btnAddEmployee.click();
        Thread.sleep(3000);
        txtFirstname.sendKeys(firstname);
        txtLastname.sendKeys(lastname);
        txtloginCred.get(4).sendKeys(Keys.CONTROL + "a", Keys.BACK_SPACE);
        Thread.sleep(2000);
        txtloginCred.get(4).sendKeys(employeeid);
        btnLoginActive.click();
        txtloginCred.get(5).sendKeys(username);
        txtloginCred.get(6).sendKeys(password);
        txtloginCred.get(7).sendKeys(confirmPass);
        btnSave.get(1).click();
        Thread.sleep(3000);
    }
    public void SearchByid(String employeeId) throws InterruptedException {
        clickPIMmenu();
        txtloginCred.get(1).sendKeys(employeeId);
        btnSave.get(1).click();
    }
    public void SearchByName(String firstname) throws InterruptedException {
        leftSideMenu.get(8).click();
        Thread.sleep(2000);
        txtEmpName.click();
        txtEmpName.sendKeys(firstname);
        Thread.sleep(2000);
        txtEmpName.sendKeys(Keys.ARROW_DOWN);
        txtEmpName.sendKeys(Keys.ENTER);
        btnSave.get(1).click();
        Thread.sleep(3000);
    }
}
