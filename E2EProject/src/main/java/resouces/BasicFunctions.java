package resouces;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasicFunctions extends Base{

    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void WaitForElementToBeVisibile(WebElement Element) {
        
        wait.until(ExpectedConditions.visibilityOf(Element));
    }

    public void WaitForElementToBeClickable(WebElement Element) {
        wait.until(ExpectedConditions.elementToBeClickable(Element));
    }

    public void WaitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void WaitForListOfWebElementsToBeVisible(List<WebElement> Elements) {
        wait.until(ExpectedConditions.visibilityOfAllElements(Elements));
    }

    public void Click(WebElement Element) {
        WaitForElementToBeVisibile(Element);
        ElementIsDisplayed(Element);
        WaitForElementToBeClickable(Element);
        Element.click();
    }

    public void SendKeys(WebElement Element, String Value) {
        WaitForElementToBeVisibile(Element);
        ElementIsDisplayed(Element);
        Element.sendKeys(Value);
    }

    public void ClearKeysAndSendKeys(WebElement Element, String Value) throws InterruptedException {
        WaitForElementToBeVisibile(Element);
        ElementIsDisplayed(Element);
        Element.clear();
        Thread.sleep(700);
        Element.sendKeys(Value);
    }

    public void GetText(WebElement Element) {
        WaitForElementToBeVisibile(Element);
        ElementIsDisplayed(Element);
        Element.getText();
    }

    public boolean GetAttributeValueAndContentEquals(WebElement Element, String Value) {
        WaitForElementToBeVisibile(Element);
        ElementIsDisplayed(Element);
        return Element.getAttribute("value").contentEquals(Value);
    }

    public void ElementIsDisplayed(WebElement Element) {
        Assert.assertTrue(Element.isDisplayed());
    }

    public int ElementsSize(List<WebElement> Elements) {
        int SizeOfElements = Elements.size();
        return SizeOfElements;
    }

    public void AssertTrueWithContains(WebElement Element, String Value) {
        WaitForElementToBeVisibile(Element);
        ElementIsDisplayed(Element);
        Assert.assertTrue(Element.getText().contains(Value));
    }

    public void AssertEqualsWithEquals(WebElement Element, String Value) {
        WaitForElementToBeVisibile(Element);
        ElementIsDisplayed(Element);
        Assert.assertEquals(Element.getText(), Value);
    }

  public void CreateWebElements_HandleDropdownUsingStreams(List<WebElement> Elements, String Value, String FilterCondition) throws InterruptedException {
        List<WebElement> DropdownElements = Elements;
        Thread.sleep(1000);
        if (FilterCondition == "ContentEquals") {
            DropdownElements.stream().filter(s -> s.getText().contentEquals(Value)).findAny().get().click();
        }
        if (FilterCondition == "EqualsIgnoreCase") {
            DropdownElements.stream().filter(s -> s.getText().equalsIgnoreCase(Value)).findAny().get().click();
        }
    }

    public void HandleAlerts(WebElement AlertLocator, WebElement TextLocator, String Value, WebElement ActionLocator) {
        WaitForElementToBeVisibile(AlertLocator);
        AssertEqualsWithEquals(TextLocator, Value);
        Click(ActionLocator);

    }

    public void ScrollUsingJSE(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement scroll = Element;
        js.executeScript("arguments[0].scrollIntoView();", scroll);
    }



      
    }


