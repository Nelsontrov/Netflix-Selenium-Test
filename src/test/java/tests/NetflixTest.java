package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NetflixMainPage;
import pages.NetflixMyAccountPage;
import pages.NetflixSignInPage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.io.IOException;
import java.time.Duration;

public class NetflixTest extends TestBase {

    @Test
    public void netflixSignIn() throws InterruptedException, IOException {
        System.out.println(driver);
        System.out.println(ConfigReader.getProperty("NetflixURL"));
        driver.get(ConfigReader.getProperty("NetflixURL"));
        NetflixMainPage netflixMainPage = new NetflixMainPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(netflixMainPage.signInLink)).click();
        NetflixSignInPage netflixSignInPage=new NetflixSignInPage(driver );
        netflixSignInPage.emailInput.sendKeys(ConfigReader.getProperty("NetUserName"));
        netflixSignInPage.passwordInput.sendKeys(ConfigReader.getProperty("NetPassword"));
        netflixSignInPage.signInButton.click();
        Thread.sleep(5000);
        NetflixMyAccountPage netflixMyAccountPage=new NetflixMyAccountPage(driver);
        Assert.assertTrue(netflixMyAccountPage.homePage.isDisplayed());
        System.out.println("✅ Assertion passed: Home tab is visible");

    }


}
