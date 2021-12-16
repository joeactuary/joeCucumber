package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.DashboardPage;
import pages.LoginPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LoginSteps {

    static Boolean messageDisplayed = false;

    @Then("admin user is successfully logged in")
    public void admin_user_is_successfully_logged_in() {
        DashboardPage dashboardpage = new DashboardPage();
        Assert.assertTrue(dashboardpage.welcomeMessage.isDisplayed());
    }

    @Then("ess user is successfully logged in")
    public void ess_user_is_successfully_logged_in() {
        admin_user_is_successfully_logged_in();
    }

    @Given("user is logged in with valid ess credentials")
    public void user_is_logged_in_with_valid_ess_credentials() {
        LoginPage loginpage = new LoginPage("johnny1234560000", "Syntax1253!!!!");
    }

    @Given("user is logged in with valid login but invalid password")
    public void user_is_logged_in_with_valid_login_but_invalid_password() {
        LoginPage loginPage = new LoginPage("Admin", "Syhkuhkjntax1253!!!!");
        messageDisplayed = loginPage.errorMessage.isDisplayed();
    }

    @When("user is logged in with valid login but invalid password2")
    public void user_is_logged_in_with_valid_login_but_invalid_password2(DataTable dataTable) {
        List<Map<String, String>> errorMap = dataTable.asMaps();
        for (Map<String, String> loginTest : errorMap) {
            String userName = loginTest.get("userName");
            String password = loginTest.get("password");
            String errorMessageExpected = loginTest.get("errorMessage");
            LoginPage loginPage = new LoginPage(userName, password);
            String errorMessageActual = loginPage.errorMessage.getText();
            Assert.assertEquals("uh oh error message does not match", errorMessageActual, errorMessageExpected);
        }
    }


    @Then("user sees invalid credentials page on login page")
    public void user_sees_invalid_credentials_page_on_login_page() {
        DashboardPage dashboardpage = new DashboardPage();
        Assert.assertTrue(messageDisplayed);
    }


    @When("user is logged in with valid login {string} but invalid {string} passwordgfh {string}")
    public void userIsLoggedInWithValidLoginButInvalidPasswordgfh(String userName, String password, String errorMessageExpected) {
        LoginPage loginPage = new LoginPage(userName, password);
        String errorMessageActual = loginPage.errorMessage.getText();
        Assert.assertEquals("uh oh error message does not match", errorMessageActual, errorMessageExpected);
    }


    @Then("user verifies the dashboard options available on the page")
    public void user_verifies_the_dashboard_options_available_on_the_page(DataTable dataTable) {
        List<String> expectedTabs = dataTable.asList();

        DashboardPage dashboardPage = new DashboardPage();
        List<String> actualTabs = new ArrayList<>();

        for (WebElement webElement : dashboardPage.topMenu) {
            actualTabs.add(webElement.getText());
        }
        System.out.println(expectedTabs);
        System.out.println("Here Yankees Rule");
        System.out.println(actualTabs);
        Assert.assertEquals("Nope, tabs do not match", actualTabs, expectedTabs);

    }


}
