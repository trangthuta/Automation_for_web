package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class PlansPage extends BasePage {
    public PlansPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[contains(text() , 'Free Plan')]")
    private WebElement freePlan;

    @FindBy(xpath = "//span[contains(text() , 'Platinum')]")
    private WebElement platinum;

    @FindBy(xpath = "//span[contains(text() , 'Gold')]")
    private WebElement gold;

    @FindBy(xpath = "//span[contains(text() , 'Silver')]")
    private WebElement silver;

    @FindBy(xpath = "//table[@class = 'table mb-0 dataTable dataTable-table']/tbody/tr")
    private List<WebElement> tableOrders;

    public void verifyDisplayedPlansPage(){
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(tableOrders));
        Assert.assertTrue(freePlan.isDisplayed() , "Không hiển thị Free Plan");
        Assert.assertTrue(platinum.isDisplayed() , "Không hiển thị Platinum");
        Assert.assertTrue(gold.isDisplayed() , "Không hiển thị Gold");
        Assert.assertTrue(silver.isDisplayed() , "Không hiển thị Silver");
        Assert.assertTrue(tableOrders.size() == 16 , "Hiển thị "+ tableOrders.size() +"/16 items trong The Order");
    }


}
