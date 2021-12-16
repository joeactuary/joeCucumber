package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods2;

import java.util.List;

public class DashboardPage extends CommonMethods2 {

    private String pageJoe = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/dashboard";

   @FindBy(id = "welcome")
   public WebElement welcomeMessage;

   @FindBy(xpath = "//div[@class='menu']/ul/li")
   public List<WebElement> topMenu;

    @FindBy(css = "a#menu_pim_viewPimModule")
    public WebElement pimButton;

    @FindBy(css = "a#menu_admin_viewAdminModule")
    public WebElement adminButton;

    @FindBy(css = "a#menu_pim_addEmployee")
    public WebElement addEmployeeButton;

      public DashboardPage() {
        PageFactory.initElements(driver, this);

    }
}