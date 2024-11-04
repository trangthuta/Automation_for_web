package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver d){
        super(d);
    }

    @FindBy(xpath = "//h6[contains(text() , 'The Treasure')]")
    private WebElement theTreasure;

    @FindBy(xpath = "//h6[contains(text() , 'Total Products')]")
    private WebElement totalProduct;

    @FindBy(xpath = "//h6[contains(text() , 'Total Sales')]")
    private WebElement totalSales;

    @FindBy(xpath = "//h6[contains(text() , 'Total Orders')]")
    private WebElement totalOrders;

    @FindBy(xpath = "//h4[contains(text() , 'Top Products')]")
    private WebElement topProducts;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[1]/div[4]/div/div/div/table/tbody/tr")
    private List<WebElement> listTopProducts;

    @FindBy(xpath = "//h4[contains(text() , 'Orders')]")
    private WebElement orders;

    @FindBy(xpath = "//h2[contains(text() , 'Recent Orders')]")
    private WebElement recentOrders;

    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div/div[2]/div[2]/div/div/div/table/tbody/tr")
    private List<WebElement> listrecentOrders;

    public WebElement getTheTreasure() {
        return theTreasure;
    }

    public WebElement getTotalProduct() {
        return totalProduct;
    }

    public WebElement getTotalSales() {
        return totalSales;
    }

    public WebElement getTotalOrders() {
        return totalOrders;
    }

    public WebElement getTopProducts() {
        return topProducts;
    }

    public List<WebElement> getListTopProducts() {
        return listTopProducts;
    }

    public WebElement getOrders() {
        return orders;
    }

    public WebElement getRecentOrders() {
        return recentOrders;
    }

    public List<WebElement> getListrecentOrders() {
        return listrecentOrders;
    }

    @FindBy(xpath = "(//span[text()='Shop'])[1]/..")
    private WebElement shopMenuItem;

    @FindBy(xpath = "(//span[text()='Plans'])[1]/..")
    private WebElement plansMenuItem;

    @FindBy(xpath = "//li[a[text()='Products']]")
    private WebElement productsMenuItem;



    public void navigateToProductsPage(){
        getDriver().navigate().refresh();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(shopMenuItem));
        shopMenuItem.click();
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(productsMenuItem));
        productsMenuItem.click();
    }

    public void navigateToPlanPage(){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(plansMenuItem));
        scrollTo(plansMenuItem);
        plansMenuItem.click();
    }

    public  void verifyDashboard(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(recentOrders)) ;
        Assert.assertTrue(getTheTreasure().isDisplayed() , "Không hiển thị The Treasure");
        Assert.assertTrue(getTotalProduct().isDisplayed() , "Không hiển thị Total Products");
        Assert.assertTrue(getTotalSales().isDisplayed() , "Không hiển thị Total Sales");
        Assert.assertTrue(getTotalOrders().isDisplayed() , "Không hiển thị Total Orders");
        Assert.assertTrue(getTopProducts().isDisplayed() , "Không hiển thị Top Products");
        Assert.assertTrue(getListTopProducts().size() == 4, "Không hiển thị đúng 4 sản phầm trong Top Products");
        Assert.assertTrue(getOrders().isDisplayed() , "Không hiển thị Orders");
        Assert.assertTrue(getRecentOrders().isDisplayed() , "Không hiển thị Recent Orders");
        Assert.assertTrue(getListrecentOrders().size() == 8, "Không hiển thị đúng 8 sản phầm trong Recent Orders");
    }
}
