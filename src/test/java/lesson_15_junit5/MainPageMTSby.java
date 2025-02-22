package lesson_15_junit5;

import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPageMTSby {
    private WebDriver driver;
    private WebDriverWait wait;

    private By closeCookieButtonLoc = By.xpath("//*[@id=\"cookie-agree\"]");
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
    private By errorMessagesOfPhoneFieldLoc = By.xpath("//*[@id='pay-connection']/div[1]");
    private By errorMessageOfAmountFieldLoc = By.xpath("//*[@id=\"pay-connection\"]/div[2]/p");
    private By errorMessageOfEmailFieldLoc = By.xpath("//*[@id=\"pay-connection\"]/div[3]/p");
    private By iframeLoc = By.xpath("//div[contains(@class, 'app-wrapper__content-container')]");


    public MainPageMTSby(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.mts.by/");

        try {
            WebDriverWait cookieWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement closeButton = cookieWait.until(ExpectedConditions.elementToBeClickable(closeCookieButtonLoc));
            closeButton.click();
        } catch (TimeoutException e) {
            System.out.println("Кнопка куки не прогрузилась или не активна");
        }
    }

    public String getPaymentFormTitleText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFormTitleLoc)).getText().replaceAll("\\s+", " ").trim();
    }

    public List<WebElement> getLogosLoc() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paySystemLogosLoc));
    }

    public WebElement getTermsOfUseLoc() {
        return wait.until(ExpectedConditions.elementToBeClickable(termsOfUseRefLoc));
    }

    public String getTermsOfUseHref() {
        return getTermsOfUseLoc().getAttribute("href");
    }

    public String getValidationMessageOfPhoneField() {
        WebElement paymentAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberFieldLoc));
        return paymentAmount.getAttribute("validationMessage");
    }

    public void fillPhoneField(String number) {
        WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumberFieldLoc));
        phoneNumber.click();
        phoneNumber.sendKeys(number);
    }

    public String getValidationMessageOfAmountField() {
        WebElement paymentAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentAmountFieldLoc));
        return paymentAmount.getAttribute("validationMessage");
    }

    public String getErrorMessageContainerOfPhoneField() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessagesOfPhoneFieldLoc));
        return errorMessage.getText();
    }

    public void fillAmountField(String amount) {
        WebElement paymentAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentAmountFieldLoc));
        paymentAmount.click();
        paymentAmount.sendKeys(amount);
    }

    public String getErrorMessageContainerOfAmountField() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageOfAmountFieldLoc));
        return errorMessage.getText();
    }

    public void fillEmailField(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailFieldLoc));
        emailField.click();
        emailField.sendKeys(email);
    }

    public String getErrorMessageContainerOfEmailField() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageOfEmailFieldLoc));
        return errorMessage.getText();
    }

    public void clickContinueButton() {
        WebElement continueButtonPayment = wait.until(ExpectedConditions.elementToBeClickable(continueButtonPaymentFormLoc));
        continueButtonPayment.click();
    }

    public void fillPaymentForm(String number, String amount, String email) {
        WebElement dropDown = wait.until(ExpectedConditions.elementToBeClickable(dropDownRawLoc));
        dropDown.click();
        WebElement communicationService = wait.until(ExpectedConditions.elementToBeClickable(communicationServiceOptionLoc));
        communicationService.click();
        fillPhoneField(number);
        fillAmountField(amount);
        fillEmailField(email);
    }

    public WebElement switchToPaymentForm() {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentIframeLoc));
        driver.switchTo().frame(iframe);
        WebElement paymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLoc));
        return paymentForm;
    }
}

