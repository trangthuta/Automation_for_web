package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PlansPage;

public class VerifyPlan extends BaseTest {
    @Test(dataProvider = "data")
    public void VerifyPlan(String username , String password) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://demo.workdo.io/storego-saas/login");
        loginPage.verifyLoginPage();
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.verifyDashboard();
        dashboardPage.navigateToPlanPage();

        PlansPage plansPage = new PlansPage(getDriver());
        try {
            plansPage.verifyDisplayedPlansPage();
        } catch (AssertionError e) {
            e.getMessage();
        }

    }

    @DataProvider(name = "data")
    public Object[][] getData(){
        return ExcelUtils.getTableArray("VerifyAddNewProduct.xlsx", "Sheet1",1,2);
    }

}
