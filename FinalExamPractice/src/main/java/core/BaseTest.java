package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    protected WebDriver driver;
    private List<String[]> testResults = new ArrayList<>();

    @Parameters({"browser", "hubURL"})
    @BeforeMethod
    public void beforeMethod(String browser, @Optional("http://localhost:4444/wd/hub") String hubURL) throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);

        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--headless");
                desiredCapabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless");
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        desiredCapabilities.setBrowserName(browser);

        if (hubURL == null || hubURL.isEmpty()) {
            driver = browser.equals("chrome")
                    ? new ChromeDriver(new ChromeOptions())
                    : new FirefoxDriver(new FirefoxOptions());
        } else {
            driver = new RemoteWebDriver(new URL(hubURL), desiredCapabilities);
        }
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void addTestResult(String id, String result, String note) {
        testResults.add(new String[]{id, result, note});
    }

    public WebDriver getDriver() {
        return driver;
    }


}
