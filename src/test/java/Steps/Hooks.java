package Steps;

import Util.CommonMethods;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks extends CommonMethods {
    @Before
    public void start(){
        openBrowserAndLaunchApplication();
    }

    @After
    //this executes always at the end irrespective of the result
    public void end(Scenario scenario){
        byte[] pic;
        //here we can take the screenshot before closing the browser
        //Scenario class in cucumber which will give me the information of
        //the execution. It holds the complete information of the execution.
        //getName is the method which returns the name of the scenario
        if(scenario.isFailed()) {
            pic = takeScreenshot("failed/"+scenario.getName());
        }else{
            pic = takeScreenshot("passed/"+scenario.getName());
        }

//pic is array of byte
        scenario.attach(pic, "image/png", scenario.getName());

        closeBrowser();
    }
}
