package org.payment.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class PaymentPage extends PageBase {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    private final WebElement currencyDropDown = driver.findElement(By.id("currency"));
    private final WebElement scopeDropDown = driver.findElement(By.id("scope"));
    private final WebElement generateTokenButton = driver.findElement(By.cssSelector("button.token_button:nth-child(1)"));
    private final WebElement responseButton = driver.findElement(By.id("Response"));
    private WebElement cardNumberText;
    private WebElement cardExpiryDateText;
    private WebElement cardCVVText;


    public void selectCurrency(String currency) {
        selectByVisibleText(currencyDropDown, currency);
    }

    public void selectScope(String scope) {
        selectByVisibleText(scopeDropDown, scope);
    }

    public void iFrameLoading() {
        switchToIFrame("tap-card-iframe");
        cardNumberText = driver.findElement(By.id("card_input_mini"));
        cardExpiryDateText = driver.findElement(By.id("date_input"));
        cardCVVText = driver.findElement(By.id("cvv_input"));
    }

    public void enterCardNumber(String cardNumber) {
        iFrameLoading();
        setValue(cardNumberText, cardNumber);
    }

    public void enterCardExpiryDate(String cardExpiryDate) {
        setValue(cardExpiryDateText, cardExpiryDate);
    }

    public void enterCardCVV(String cardCVV) {
        setValue(cardCVVText, cardCVV);
    }

    public void clickOnGenerateTokenButton() {
        driver.switchTo().defaultContent();
        clickElement(generateTokenButton);
    }

    public void clickOnSubmitButton() {
        switchToIFrame("tap-card-iframe");
        switchToIFrame("tap-card-iframe-authentication");
        switchToIFrame("challengeFrame");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.id("acssubmit"));
        js.executeScript("arguments[0].click();", element);

    }

    public void clickOnResponseButton() {
        driver.switchTo().defaultContent();
        waitIFrameLoading(20);
        clickElement(responseButton);
    }

    public void printTheResponse() {
        WebElement jsonElement = driver.findElement(By.cssSelector("code.language-json"));
        String jsonText = jsonElement.getText();
        System.out.println("Extracted JSON Text: \n" + jsonText);
    }

}
