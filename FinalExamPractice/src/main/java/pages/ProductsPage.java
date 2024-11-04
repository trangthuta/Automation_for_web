package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage {
    public ProductsPage(WebDriver d) {
        super(d);
    }


    @FindBy(xpath = "//table[@id='pc-dt-satetime-sorting']/tbody/tr")
    private List<WebElement> tableProducts;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/div/div[2]/div[2]/div/a[3]")
    private WebElement createButton;


    public void verifyNumberOfProductInFirstPage() {
        getWebDriverWait().until(ExpectedConditions.visibilityOfAllElements(tableProducts));
        Assert.assertTrue(tableProducts.size() == 10);
    }

    public void navigateToAddNewProductPage() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(createButton));
        createButton.click();

    }
}
