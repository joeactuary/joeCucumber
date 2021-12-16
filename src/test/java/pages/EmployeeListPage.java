package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods2;

public class EmployeeListPage extends CommonMethods2 {

    private String pageJoe = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    @FindBy(css = "input#empsearch_employee_name_empName")
    public WebElement employeeNameBox;

    @FindBy (css = "a#menu_pim_viewEmployeeList")
    public WebElement EmployeeListButton;

    @FindBy (css = "input#searchBtn")
    public WebElement searchButton;

    @FindBy (css = "input#ohrmList_chkSelectAll")
    public WebElement selectAllBox;

    @FindBy (css = "input#btnDelete")
    public WebElement deleteButton;

    @FindBy (css = "input#dialogDeleteBtn")
    public WebElement deleteConfirmButton;

    @FindBy(id="empsearch_id")
    public WebElement employeeIdBox;

    @FindBy(xpath = "//table[@id=\'resultTable\']/tbody/tr/td[2]")
    public WebElement row1EmployeeID;

    @FindBy(xpath = "//table[@id=\'resultTable\']/tbody/tr/td[3]")
    public WebElement row1EmployeeFirstAndMiddleName;

    @FindBy(xpath = "//table[@id=\'resultTable\']/tbody/tr/td[4]")
    public WebElement row1EmployeeLastName;

    public EmployeeListPage() {
        PageFactory.initElements(driver, this);

    }
}