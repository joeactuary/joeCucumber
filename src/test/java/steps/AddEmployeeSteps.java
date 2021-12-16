package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.EmployeePage;
import utils.CommonMethods2;
import utils.Constants;
import utils.ExcelReading;

import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods2 {

    public static String fullName;

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        EmployeePage employeePage = new EmployeePage();
        click(employeePage.pimButton);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashboardPage dashboardPage = new DashboardPage();
        click(dashboardPage.addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        String firstName = "Stephen";
        String middleName = "A.";
        String lastName = "Slotzky";
        fullName = firstName + " " + middleName + " " + lastName;
        sendText(addEmployeePage.firstNameBox, firstName);
        sendText(addEmployeePage.middleNameBox, middleName);
        sendText(addEmployeePage.lastNameBox, lastName);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.saveButton);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        EmployeePage employeePage = new EmployeePage();

        Assert.assertEquals(employeePage.employeeName.getText(), fullName);
        System.out.println(fullName + "  added successfully");
    }

    @Then("employee is deleted")
    public void employeeIsDeleted() throws InterruptedException {
        EmployeePage employeePage = new EmployeePage();
        EmployeeListPage employeeListPage = new EmployeeListPage();

        click(employeePage.pimButton);
        click(employeePage.EmployeeListButton);
        Thread.sleep(1000);

        employeeListPage.employeeNameBox.clear();
        employeeListPage.employeeNameBox.sendKeys(fullName, Keys.TAB, Keys.TAB);

        employeeListPage.searchButton.click();
        Thread.sleep(1000);
        String firstAndMiddleName = employeeListPage.row1EmployeeFirstAndMiddleName.getText();
        String lastName = employeeListPage.row1EmployeeLastName.getText();
        String id = employeeListPage.row1EmployeeID.getText();
        System.out.println(id + " " + firstAndMiddleName + " " + lastName + "  is displayed");

        click(employeeListPage.selectAllBox);
        click(employeeListPage.deleteButton);
        click(employeeListPage.deleteConfirmButton);
        System.out.println(id + " " + firstAndMiddleName + " " + lastName + "  is deleted");
    }

    @And("user deletes employee id")
    public void userDeletesEmployeeId() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.employeeId.clear();
    }

    @When("user supplies picture")
    public void user_supplies_picture() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.photograph, "C:\\Users\\goldm\\Documents\\Garbage\\416FgAN2SBL._AC_.jpg");
    }


    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.createLoginDetailsButton);
    }

    @And("user enters username password and confirmpassword")
    public void userEntersUsernamePasswordAndConfirmpassword() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.userNameBox, "Slotzky");
        sendText(addEmployeePage.passwordBox, "Hum@nhrm123");
        sendText(addEmployeePage.confirmPasswordBox, "Hum@nhrm123");
    }

    @And("user enters {string} {string} and {string}")
    public void userEntersAnd(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        fullName = firstName + " " + middleName + " " + lastName;
        sendText(addEmployeePage.firstNameBox, firstName);
        sendText(addEmployeePage.middleNameBox, middleName);
        sendText(addEmployeePage.lastNameBox, lastName);
    }

    @When("user adds multiple employees and verifies added successfully")
    public void user_adds_multiple_employees_and_verifies_added_successfully(DataTable employees) throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        EmployeePage employeePage = new EmployeePage();
        EmployeeListPage employeeListPage = new EmployeeListPage();

       // List<Map<String, String>> newEmployeesList = employees.asMaps();
        List<Map<String, String>> newEmployeesList = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, "EmployeeData");

        for (Map<String, String> newEmployee : newEmployeesList) {
            click(employeePage.pimButton);
            click(dashboardPage.addEmployeeButton);

            String firstName = newEmployee.get("FirstName");
            String middleName = newEmployee.get("MiddleName");
            String lastName = newEmployee.get("LastName");
            fullName = firstName + " " + middleName + " " + lastName;
            String password = newEmployee.get("Password");

            sendText(addEmployeePage.firstNameBox, firstName);
            sendText(addEmployeePage.lastNameBox, lastName);
            String employeeIdValue = addEmployeePage.employeeId.getAttribute("value");
            sendText(addEmployeePage.middleNameBox, middleName);

            user_supplies_picture();
            // sendText(addEmployeePage.photograph, newEmployee.get("Photograph"));

            //click(addEmployeePage.createLoginDetailsButton);
            //sendText(addEmployeePage.userNameBox, newEmployee.get("Username"));
            // sendText(addEmployeePage.passwordBox, password);
            // sendText(addEmployeePage.confirmPasswordBox,password);

            click(addEmployeePage.saveButton);
            System.out.println(lastName + "    saved!!!");


            Assert.assertEquals(employeePage.employeeName.getText(), fullName);


            CommonMethods2.takeScreenshot("HRMS/" + lastName + "_added");

            //*******  Delete the Employee  ********//
            employeeIsDeleted();

        }
    }


    @When("user adds employees from {string} excelsheet")
    public void user_adds_employees_from_excelsheet(String sheetName) throws InterruptedException {
        DashboardPage dashboardPage = new DashboardPage();
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        EmployeePage employeePage = new EmployeePage();
        EmployeeListPage employeeListPage = new EmployeeListPage();

        List<Map<String, String>> newEmployeesList = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);

        for (Map<String, String> newEmployee : newEmployeesList) {
            click(employeePage.pimButton);
            click(dashboardPage.addEmployeeButton);

            String firstName = newEmployee.get("FirstName");
            String middleName = newEmployee.get("MiddleName");
            String lastName = newEmployee.get("LastName");
            fullName = firstName + " " + middleName + " " + lastName;
            String password = newEmployee.get("Password");

            sendText(addEmployeePage.firstNameBox, firstName);
            sendText(addEmployeePage.lastNameBox, lastName);
            String employeeIdValue = addEmployeePage.employeeId.getAttribute("value");
            sendText(addEmployeePage.middleNameBox, middleName);

            user_supplies_picture();
             sendText(addEmployeePage.photograph, newEmployee.get("Photograph"));

           click(addEmployeePage.createLoginDetailsButton);
           sendText(addEmployeePage.userNameBox, newEmployee.get("Username"));
            sendText(addEmployeePage.passwordBox, password);
             sendText(addEmployeePage.confirmPasswordBox,password);

            click(addEmployeePage.saveButton);
            System.out.println(lastName + "    saved!!!");


            Assert.assertEquals(employeePage.employeeName.getText(), fullName);


            CommonMethods2.takeScreenshot("HRMS/" + lastName + "_added");

          //  byte[] pic;

            //    pic =  CommonMethods2.takeScreenshot("HRMS/" + lastName + "_added");

            //            scenario.attach(pic, "image/png", "HRMS/" + lastName + "_added");



            //*******  Delete the Employee  ********//
            employeeIsDeleted();

        }
    }
    }


