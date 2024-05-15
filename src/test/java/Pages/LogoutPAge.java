package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LogoutPAge {
    public LogoutPAge(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(className = "oxd-userdropdown-icon")
    WebElement userdropdown;
    @FindBy(className = "oxd-userdropdown-link")
    List <WebElement> dropDownOptions;

    public void doLogout() throws InterruptedException {
        userdropdown.click();
        dropDownOptions.get(3).click();
        Thread.sleep(3000);
    }

}
