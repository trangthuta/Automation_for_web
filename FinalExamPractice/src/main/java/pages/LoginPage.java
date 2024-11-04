package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver d){
        super(d);
    }

    @FindBy(id = "email")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(tagName = "h2")
    private WebElement title;

    @FindBy(xpath = "//a[contains(text() , 'Forgot Your Password?')]")
    private WebElement forgotPassword;

    @FindBy(xpath = "//button[contains(text() , 'Super Admin')]")
    private WebElement supperAdminButton;

    @FindBy(xpath = "//button[contains(text() , 'Shop Owner')]")
    private WebElement shopOwnerButton;

    @FindBy(xpath = "//button[contains(text() , 'Manager')]")
    private WebElement managerButton;

    @FindBy(xpath = "//button[contains(text() , 'Accountant')]")
    private WebElement accountantButton;

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getTitle() {
        return title;
    }

    public WebElement getForgotPassword() {
        return forgotPassword;
    }

    public WebElement getSupperAdminButton() {
        return supperAdminButton;
    }

    public WebElement getShopOwnerButton() {
        return shopOwnerButton;
    }

    public WebElement getManagerButton() {
        return managerButton;
    }

    public WebElement getAccountantButton() {
        return accountantButton;
    }

    public void login(String u, String p){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(username));
        System.out.println( u + p);
//        username.clear();
//        username.sendKeys(u);
//        password.clear();
//        password.sendKeys(p);
        loginButton.click();

    }

    public void navigateToLogin(String url){
        getDriver().get(url);
        getDriver().manage().window().maximize();
    }

    public void verifyLoginPage() {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(accountantButton));
        Assert.assertTrue(getTitle().isDisplayed() ,"Không hiển thị Title :Login");
        Assert.assertTrue(getUsername().isDisplayed() ,"Không hiển thị Email textbox");
        Assert.assertTrue(getPassword().isDisplayed() ,"Không hiển thị Password textbox");
        Assert.assertTrue(getForgotPassword().isDisplayed(),"Không hiển thị Forgot your password");
        Assert.assertTrue(getLoginButton().isDisplayed() ,"Không hiển thị Login button");
        Assert.assertTrue(getSupperAdminButton().isDisplayed() ,"Không hiển thị Supper Admin button");
        Assert.assertTrue(getShopOwnerButton().isDisplayed() ,"Không hiển thị Supper Owner button");
        Assert.assertTrue(getManagerButton().isDisplayed() ,"Không hiển thị Manager button");
        Assert.assertTrue(getAccountantButton().isDisplayed() ,"Không hiển thị Accountant button");
    }


}
