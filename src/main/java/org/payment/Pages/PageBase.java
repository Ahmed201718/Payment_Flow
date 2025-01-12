package org.payment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {

    WebDriver driver;
    private WebElement iFrame;

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    public void setValue(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void selectByVisibleText(WebElement dropdownElement, String visibleText) {
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    public void waitIFrameLoading(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void switchToIFrame(String iFrameId) {
        waitIFrameLoading(20);
        iFrame = driver.findElement(By.id(iFrameId));
        driver.switchTo().frame(iFrame);
    }

}
