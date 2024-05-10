package Pages;

import Util.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id="firstName")
    public WebElement firstNameLoc;

    @FindBy(id="middleName")
    public WebElement middleNameLoc;

    @FindBy(id="lastName")
    public WebElement lastNameLoc;

    @FindBy(id="chkLogin")
    public WebElement checkBox;

    @FindBy(id="user_name")
    public WebElement usernameEmp;

    @FindBy(id="user_password")
    public WebElement passwordEmp;

    @FindBy(id="re_password")
    public WebElement confirmPassword;

    @FindBy(id="employeeId")
    public WebElement employeeIdLocator;

    @FindBy(id="btnSave")
    public WebElement saveBtn;

    public WebElement photograph;


    public AddEmployeePage(){
        PageFactory.initElements(driver, this);
    }
}
