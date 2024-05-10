package Pages;

import Util.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends CommonMethods {

    @FindBy(id="txtUsername")
    public static WebElement usernameTextField;

    @FindBy(id="txtPassword")
    public static WebElement passwordTextField;

    @FindBy(id="btnLogin")
    public static WebElement loginBtn;

    public loginPage(){
        //our this code will initialize all the elements of the page
        //because when the object creates, constructor will be called which will
        //initialize all of these elements
        PageFactory.initElements(driver, this);
    }
}
