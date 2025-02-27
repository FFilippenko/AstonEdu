package lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IframeCheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By checkoutIframeLoc = By.xpath("//iframe[contains(@src, 'checkout.bepaid.by')]");
    private By amountTitleLoc = By.xpath("//div[@class='pay-description__cost']/child::span[contains(text(),'BYN')]");
    private By serviceSummary = By.xpath("//div[@class='pay-description__text']/child::span[contains(text(),'Оплата') and contains(text(),'Номер')]");
    private By checkoutPaymentLogosLoc = By.xpath("//div[contains(@class, 'cards-brands__container')]/child::img");
    private By checkoutPaymentRandomLogos = By.xpath("//div[contains(@class, 'cards-brands_random')]/child::img");
    private By submitButtonLoc = By.xpath("//descendant::button[@type='submit' and contains(text(),'Оплатить')]");
    private By cardNumberFieldLoc = By.xpath("//*[@id='cc-number']/following-sibling::label");
    private By expirationDateFieldLoc = By.xpath("//*[@formcontrolname='expirationDate']/following-sibling::label");
    private By cvcFieldLoc = By.xpath("//*[@formcontrolname='cvc']/following-sibling::label");
    private By cardHolderFieldLoc = By.xpath("//*[@formcontrolname='holder']/following-sibling::label");

    public IframeCheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void switchToIframe() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutIframeLoc));
        driver.switchTo().frame(iframe);
    }

    public String getCardNumberFieldLabel() {
        return getElementText(cardNumberFieldLoc);
    }

    public String getExpirationDateFieldLabel() {
        return getElementText(expirationDateFieldLoc);
    }

    public String getCvcFieldLabel() {
        return getElementText(cvcFieldLoc);
    }

    public String getCardHolderFieldLabel() {
        return getElementText(cardHolderFieldLoc);
    }

    private String getElementText(By fieldLabelLoc) {
        WebElement fieldDiv = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldLabelLoc));
        return fieldDiv.findElement(fieldLabelLoc).getText();
    }

    public String getAmountTitle() {
        return getElementText(amountTitleLoc);
    }

    public String getServiceSummary() {
        return getElementText(serviceSummary);
    }

    public List<WebElement> getCheckoutStaticPaymentLogos() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkoutPaymentLogosLoc));
    }

    public List<WebElement> getCheckoutPaymentRandomLogos() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkoutPaymentRandomLogos));
    }

    public String getSubmitButtonText() {
        return getElementText(submitButtonLoc);
    }
}