package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods2;

public class AddEmployeePage extends CommonMethods2 {

    private final String pageJoe = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    @FindBy(css = "input#firstName")
    public WebElement firstNameBox;

    @FindBy(css = "input#lastName")
    public WebElement lastNameBox;

    @FindBy(css = "input#middleName")
    public WebElement middleNameBox;

    @FindBy(id="photofile")
    public WebElement photograph;

    @FindBy(css = "input#chkLogin")
    public WebElement createLoginDetailsButton;

    @FindBy(css = "input#user_name")
    public WebElement userNameBox;

    @FindBy(css = "input#user_password")
    public WebElement passwordBox;

    @FindBy(css = "input#re_password")
    public WebElement confirmPasswordBox;

    @FindBy(css = "input#btnSave")
    public WebElement saveButton;

    @FindBy(css = "a#menu_pim_viewPimModule")
    public WebElement pimButton;

    @FindBy(id="employeeId")
    public WebElement employeeId;


    public AddEmployeePage() {
        PageFactory.initElements(driver, this);

    }
}