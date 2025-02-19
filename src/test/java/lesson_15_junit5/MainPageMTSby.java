package lesson_15_junit5;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPageMTSby {
    private static WebDriver driver;
    private static WebDriverWait wait;


    private By paymentFormTitleLoc = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private By paySystemLogosLoc = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li/img");
    private By termsOfUseRefLoc = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");
    private By dropDownRawLoc = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private By communicationServiceOptionLoc = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p");
    private By phoneNumberFieldLoc = By.xpath("//*[@id=\"connection-phone\"]");
    private By paymentAmountFieldLoc = By.xpath("//*[@id=\"connection-sum\"]");
    private By emailFieldLoc = By.xpath("//*[@id=\"connection-email\"]");
    private By continueButtonPaymentFormLoc = By.xpath("//*[@id=\"pay-connection\"]/button");
    private By paymentIframeLoc = By.xpath("//iframe[contains(@src, 'checkout.bepaid.by')]");

    public MainPageMTSby(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getPaymentFormTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFormTitleLoc)).getText().replaceAll("\\s+", " ").trim();
    }

    public List<WebElement> getLogosLoc() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paySystemLogosLoc));
    }

    public String getTermsOfUseHref(){
        WebElement ref = wait.until(ExpectedConditions.elementToBeClickable(termsOfUseRefLoc));
        return ref.getAttribute("href");
    }

    public void fillPaymentForm(String number, String amount, String email){
        WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(dropDownRawLoc));
        dropDown.click();
        WebElement communicationService = wait.until(ExpectedConditions.elementToBeClickable(communicationServiceOptionLoc));
        communicationService.click();
        WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberFieldLoc));
        phoneNumber.click();
        phoneNumber.sendKeys(number);
        WebElement paymentAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentAmountFieldLoc));
        paymentAmount.click();
        paymentAmount.sendKeys(amount);
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLoc));
        emailField.click();
        emailField.sendKeys(email);
        WebElement continueButtonPayment = wait.until(ExpectedConditions.elementToBeClickable(continueButtonPaymentFormLoc));
        continueButtonPayment.click();
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIframeLoc));
        driver.switchTo().frame(iframe);
    }
}

