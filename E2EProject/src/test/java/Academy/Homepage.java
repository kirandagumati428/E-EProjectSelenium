package Academy;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resouces.Base;
import resouces.BasicFunctions;

public class Homepage extends Base {

    @BeforeTest
    public void intizliseBroswer() throws IOException {
        driver = initilizeDriver();
        
    }

    @Test(dataProvider = "getdata")
    public void basePageNavigation(String username, String password, String text)
            throws IOException, InterruptedException {

        // one is interitance
        // creating objects to that class and invoking methods on it
        driver.get(prop.getProperty("url"));
        LandingPage l = new LandingPage(driver);
        
        try {
            l.getPopup().click();
        } catch (Exception e) {
            System.out.println("No PopUp Button To Click");
        }
            
   
        try {
            l.getLogin().click();
        } catch (Exception e) {
            System.out.println("No SignIN Button To Click");
        }
BasicFunctions fun=new BasicFunctions();
        LoginPage lp = new LoginPage(driver);
        fun.SendKeys(lp.getEmail(), username);
       // lp.getEmail().sendKeys(username);
        fun.SendKeys(lp.getPassword(), password);
       // lp.getPassword().sendKeys(password);
        Thread.sleep(2000);
        System.out.println(text);
        fun.Click(lp.getSignin());
        lp.getSignin().click();

    }

    @AfterTest
    public void getclose() {
        driver.close();
        driver=null;
    }

    @DataProvider
    public Object[][] getdata() {
        // Row stands for howw many different data types test should run
        // column stands for how many values for each test
        // Array row size 1
        // 0
        // Array column size 2
        // 0,1
        Object[][] data = new Object[2][3];

        // 0th row
        data[0][0] = "nonresticteduser@qa.com";
        data[0][1] = "123464";
        data[0][2] = "Resticted user";

        // 1st row
        data[1][0] = "resticteduser@qa.com";
        data[1][1] = "4676862";
        data[1][2] = "non Resticted user";
        return data;
    }
}
