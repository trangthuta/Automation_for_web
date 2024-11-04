package test;

import core.BaseTest;
import core.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddNewProductPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.ProductsPage;

public class VerifyAddNewProduct extends BaseTest {

    @Test(dataProvider = "data")
    public void test(String username , String password) {

        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLogin("https://demo.workdo.io/storego-saas/login");
        loginPage.verifyLoginPage();
        loginPage.login(username, password);


        DashboardPage dashboardPage = new DashboardPage(getDriver());
        dashboardPage.verifyDashboard();
        dashboardPage.navigateToProductsPage();

        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.verifyNumberOfProductInFirstPage();
        productsPage.navigateToAddNewProductPage();

        AddNewProductPage addNewProductPage = new AddNewProductPage(getDriver());
        addNewProductPage.addNewCustomer();

    }

    @DataProvider(name = "data")
    public Object[][] getData(){
        return ExcelUtils.getTableArray("VerifyAddNewProduct.xlsx", "Sheet1",1,2);
    }
}
