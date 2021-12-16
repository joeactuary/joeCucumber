package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods2;

import java.util.List;

public class AdminPage extends CommonMethods2 {



    @FindBy(css = "a#menu_admin_Job")
    public WebElement jobButton;

    @FindBy(css = "a#menu_admin_viewJobTitleList")
    public WebElement jobTitlesButton;

    @FindBy(xpath = "//table[@id='resultTable']/tbody/tr/td/a")
    public List<WebElement> jobTitleList;


    public AdminPage() {
        PageFactory.initElements(driver, this);
    }
}