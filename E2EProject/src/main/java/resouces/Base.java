package resouces;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

    public static WebDriver driver;
    public Properties prop;

    public WebDriver initilizeDriver() throws IOException {

        prop = new Properties();
        FileInputStream fio = new FileInputStream(
                "C:\\Users\\kiran\\E2EProject\\src\\main\\java\\resouces\\data.properties");
        prop.load(fio);
        String broswerName = prop.getProperty("broswer");
        System.out.println(broswerName);

        if (broswerName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\107.0.5304.62\\chromedriver.exe ");
            driver = new ChromeDriver();

        } else if (broswerName.equals("firefox")) {

            // write firefox
            System.setProperty("webdriver.firefox.driver", " ");
            driver = new FirefoxDriver();
        } else if (broswerName.equals("IE")) {
            // write internet explorer
            System.setProperty("webdriver.internetExplorer.driver", " ");
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
    
    public void getScreenshot(String result) throws IOException {
 File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 FileUtils.copyFile(src, new File("C:\\Screenshots\\"+result+"screenshot.png"));

    }

   
}
