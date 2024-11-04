package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class AddNewProductPage extends BasePage {
    public AddNewProductPage(WebDriver d) {
        super(d);
    }


    @FindBy(id ="name")
    private WebElement name;

    @FindBy(xpath ="//*[@id=\"frmTarget\"]/div/div/div[1]/div/div[1]/div/div/div[2]/div/div[1]/input")
    private WebElement productCategories;

    @FindBy(id ="SKU")
    private WebElement sku;

    @FindBy(id ="price")
    private WebElement price;

    @FindBy(id = "last_price")
    private WebElement lastPrice;

    @FindBy(id = "quantity")
    private WebElement quantity;

    @FindBy(xpath = "//*[@id=\"submit-all\"]")
    private WebElement submit;

    @FindBy(xpath = "/html/body/div[16]/div/div")
    private WebElement message;

    public void addNewCustomer(){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(name));
        name.sendKeys(generateRandomString("abcdefghijklmnopqrstuvwxyz", 4));
        productCategories.sendKeys("Electronics");
        sku.sendKeys(generateRandomString("abcdefghijklmnopqrstuvwxyz", 4));
        price.sendKeys("100");
        lastPrice.sendKeys("90");
        quantity.sendKeys("100");
        scrollTo(submit);
        submit.click();
    }

//    public boolean verifyMessage(String expectedMessage){
//        getWebDriverWait().until(ExpectedConditions.visibilityOf(message));
//        String actualMessage = message.getText();
//        return actualMessage.equals(expectedMessage);
//    }


    public static String generateRandomString(String alphabet, int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            sb.append(alphabet.charAt(index));
        }

        return sb.toString();
    }
}
