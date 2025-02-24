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
    private By amountTitleLoc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span[1]");
    private By serviceSummary = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span");
    private By checkoutPaymentLogosLoc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img");
    private By checkoutPaymentRandomLogos = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img");
    private By submitButtonLoc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button");
    private By cardNumberFieldLoc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]");
    private By expirationDateFieldLoc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]");
    private By cvcFieldLoc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]");
    private By cardHolderFieldLoc = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]");

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