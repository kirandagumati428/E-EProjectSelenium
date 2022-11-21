package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        // PageFactory.initElements(driver, this);
    }

    By signin = By.cssSelector("a[href*='sign_in']");
    By popup = By.xpath("(//div[@class='sumome-react-wysiwyg-move-handle'])[7]");

    By tittle = By.xpath("//h2[text()='Featured Courses']");
    By navbar = By.xpath("//a[text()='Contact']");
    // or @FindBy(xpath="//a[text()='Contact']")
    // WebElement navbar

    public WebElement getLogin() {
        return driver.findElement(signin);
    }

    public WebElement getPopup() {
        return driver.findElement(popup);
    }

    public WebElement getTittle() {
        return driver.findElement(tittle);
    }

    public WebElement getNavigateBar() {
        return driver.findElement(navbar);
        // return navbar;
    }
}
