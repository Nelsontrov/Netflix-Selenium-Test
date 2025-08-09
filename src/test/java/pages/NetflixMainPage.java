package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NetflixMainPage {
    WebDriver driver;
    public NetflixMainPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[contains(@class, 'default-ltr-cache-rv48g6')]/a")
    public WebElement signInLink;
}
