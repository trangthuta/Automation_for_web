package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private WebDriver driver ;
    private WebDriverWait wait ;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait( driver , Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)) ;
        PageFactory.initElements(driver,this);
    }
    public WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getWebDriverWait() {
        return wait;
    }
    @FindBy(id = "loading")
    public WebElement loadingItem ;

    public void waitLoadingPage(){
        getWebDriverWait().until(ExpectedConditions.invisibilityOf(loadingItem)) ;
    }

    public void scrollTo(WebElement e){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", e);
    }
}
