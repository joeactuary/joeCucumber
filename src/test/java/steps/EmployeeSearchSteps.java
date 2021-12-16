package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import pages.EmployeeListPage;
import pages.EmployeePage;
import pages.LoginPage;
import utils.CommonMethods2;

public class EmployeeSearchSteps extends CommonMethods2 {



    @Given("user is navigated to HRMS")
    public void user_is_navigated_to_hrms() {
       openBrowser();
            }

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_unusual_admin_credentials() {
        LoginPage loginPage = new LoginPage();
           }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        EmployeePage employeePage = new EmployeePage();
        click(employeePage.pimButton);
        click(employeePage.EmployeeListButton);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() throws InterruptedException {
        EmployeeListPage employeeListPage = new EmployeeListPage();
      sendText(employeeListPage.employeeIdBox,"20119000");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() throws InterruptedException {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        EmployeePage employeePage = new EmployeePage();
        click(employeePage.pimButton);
        click(employeePage.EmployeeListButton);
       Thread.sleep(1000);
        employeeListPage.employeeNameBox.clear();
        employeeListPage.employeeNameBox.sendKeys("Sohail Sohail", Keys.TAB, Keys.TAB);
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage employeeListPage = new EmployeeListPage();
        employeeListPage.searchButton.click();
    }

        @Then("user sees employee information is displayed")
    public void user_sees_employee_information_is_displayed() {
            EmployeeListPage employeeListPage = new EmployeeListPage();
            System.out.println(employeeListPage.row1EmployeeID.getText() +"    is displayed");
            System.out.println(employeeListPage.row1EmployeeFirstAndMiddleName.getText() +"    is displayed");

                 }

}
