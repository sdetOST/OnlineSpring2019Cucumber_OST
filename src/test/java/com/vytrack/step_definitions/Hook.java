package com.vytrack.step_definitions;
/*
What if we want to run hook only for scenarios with specific tag?

we shouldn't have a default hook.

Otherwise, default hook will always run.

If scenario contains a tag that is matching expected tag from addition hook method, it will run on top of default hook.

@Before("@storemanager") - means that this hook will work for scenarios with annotation @storemanager.

#####

How to change priority?


put order:
@Before(order = 2)

Why do we have default?

Because it's common for all scenarios.
If fore some reason, default hook is no suitable for some scenarios, you should have @tag for that hook.

Default hook is like water. Means everyone likes it.

If, you need to have a special setup, use tags for all hooks.

#### Why 2 hooks can be helpful?

For example we have a web application. Just simple ui + back-end testing. And, you have a feature that involves external application. You need to verify not only DB
of your application, but also, DB of that external application. You don't need connection with that DB for all scenarios. Only for 1-2 features you need a connection with DB of external application. So you can create a hook, that would establish connection with that DB, only for those specific scenarios.

###################################




if we have more than one hook classes under step-_definitions ? are we going to put the exact path to the specific hook class that we want to be considered?

- No, is other hook under same package.

If other hook, located in different package, you have to provide a path to that hook package in the glue.


IN my framework, we had 2 hook classes:
-Only for Before hooks
-Only for After hooks
 */

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hook {
    //default HOOK runs for any scenario
    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println("BEFORE");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().get(ConfigurationReader.getProperty("url" + ConfigurationReader.getProperty("environment")));
    }

    @Before(value="@storemanager", order=1)
    public void setup2(Scenario scenario){
        System.out.println("Before hook for just store manager ");
    }

    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //will attach screenshot into report
            scenario.embed(image, "image/png");
        }
        Driver.closeDriver();
        System.out.println("AFTER");
    }






//    @After(value = "@storemanager", order = 1)
//    public void teardownForStoreManager(){
//        System.out.println("AFTER FOR STORE MANAGER");
//    }
//
//    //this hook will work
//    //only for scenarios with a tag @storemanager
//    //also, it will run before default hook
//    //because of priority
//    @Before(value = "@storemanager", order = 1)
//    public void setupForStoreManager(Scenario scenario){
//        System.out.println("BEFORE FOR STORE MANAGER");
//    }

}
