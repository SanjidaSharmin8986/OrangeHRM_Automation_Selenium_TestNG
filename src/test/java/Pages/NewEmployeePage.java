package Pages;

import Config.Scrolling;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NewEmployeePage {
    public NewEmployeePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "oxd-main-menu-item")
    List <WebElement> leftMenu;
    @FindBy(className = "oxd-radio-input")
    List <WebElement> GenderOption;
    @FindBy(className = "oxd-select-text-input")
    List <WebElement> bloodDropdown;
    @FindBy(className = "oxd-button")
    List <WebElement> btnSave;
    public void clickMyinfo() throws InterruptedException {leftMenu.get(2).click();Thread.sleep(3000);}

    public void changeGender(){
        GenderOption.get(1).click();
    }
    public void changeBloodType(){
        bloodDropdown.get(2).click();
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ENTER);
    }
    public void save() throws InterruptedException {
        btnSave.get(1).click();
        Thread.sleep(3000);
    }
    public void upDateBloodGroup(){
        bloodDropdown.get(2).click();
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ARROW_DOWN);
        bloodDropdown.get(2).sendKeys(Keys.ENTER);
    }

}
