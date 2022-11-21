package Academy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import resouces.Base;

public class ValidateNavigationBar extends Base {
    @BeforeTest
    public void intizliseBroswer() throws IOException {
        driver = initilizeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void basePageNavigation() throws IOException {
        
        // one is interitance
        // creating objects to that class and invoking methods on it

        LandingPage l = new LandingPage(driver);
        Assert.assertTrue(l.getNavigateBar().isDisplayed());

    }

    @AfterTest
    public void getClose() {
        driver.close();
        driver=null;
    }
}
