package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods2;

public class EmployeePage extends CommonMethods2 {

    private String pageJoe = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    @FindBy(xpath = "//div[@id ='profile-pic']/h1")
    public WebElement employeeName;

    @FindBy (css = "a#menu_pim_viewEmployeeList")
    public WebElement EmployeeListButton;

    @FindBy(css = "a#menu_pim_viewPimModule")
    public WebElement pimButton;

    public EmployeePage() {
        PageFactory.initElements(driver, this);

    }
}