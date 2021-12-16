package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods2;
import utils.ConfigReader;

public class LoginPage extends CommonMethods2 {

  //  private final String pageJoe = "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login";

    @FindBy(css = "input#txtUsername")
    public WebElement usernameBox;

    @FindBy(id = "txtPassword")
    public WebElement passwordBox;

    @FindBy(css = "input#btnLogin")
    public WebElement  loginButton;

    @FindBy(id="spanMessage")
    public WebElement errorMessage;


       public LoginPage() {
        PageFactory.initElements(driver, this);
           sendText(usernameBox, ConfigReader.getPropertyValue("username"));
           sendText(passwordBox, ConfigReader.getPropertyValue("password"));
           click(loginButton);

    }

    public LoginPage(String username, String password) {
        PageFactory.initElements(driver, this);
        sendText(usernameBox, username);
        sendText(passwordBox, password);
        click(loginButton);

    }

    public void login(String username, String password){
        PageFactory.initElements(driver, this);
        sendText(usernameBox, username);
        sendText(passwordBox, password);
        click(loginButton);
    }

}