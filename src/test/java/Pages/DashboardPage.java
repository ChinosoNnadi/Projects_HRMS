package Pages;

import Util.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends CommonMethods {
    @FindBy(id="menu_pim_viewPimModule")
    public static WebElement pimButton;

    @FindBy(id="menu_pim_viewEmployeeList")
    public static WebElement empListButton;

    @FindBy(id="menu_pim_addEmployee")
    public static WebElement addEmployeeButton;

    @FindBy(id="welcome")
    public static WebElement welcomeAdminLocator;

    public DashboardPage(){
        PageFactory.initElements(driver,this);
    }

}
