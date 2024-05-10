package Pages;

import Util.CommonMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardPage extends CommonMethods {
    @FindBy(id = "menu_admin_viewAdminModule")
    public WebElement adminButtonLoc;

    @FindBy(id = "menu_admin_Job")
    public WebElement adminJobBtn;

    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement adminJobTitleBtn;

    @FindBy(id = "btnAdd")
    public WebElement addJobBtn;

    @FindBy(id = "jobTitle_jobTitle")
    public WebElement addJobTitleF;

    @FindBy(id = "jobTitle_jobDescription")
    public WebElement addJobDesc;

    @FindBy(id = "jobTitle_note")
    public WebElement addJobNote;

    @FindBy(id = "btnSave")
    public WebElement addJobSvBtn;

    public AdminDashboardPage(){
        PageFactory.initElements(driver,this);
    }

}
