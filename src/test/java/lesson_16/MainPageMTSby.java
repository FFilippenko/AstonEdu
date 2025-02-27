package lesson_16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageMTSby {
    final public static String communicationService = "Услуги связи";
    final public static String internetOption = "Домашний интернет";
    final public static String installmentOption = "Рассрочка";
    final public static String arrearsOption = "Задолженность";

    private WebDriver driver;
    private WebDriverWait wait;

    private By closeCookieButtonLoc = By.xpath("//*[@id=\"cookie-agree\"]");
    private By dropDownRawLoc = By.xpath("//button[@class='select__header']");
    private By communicationServiceOptionLoc = By.xpath("//*[@id=\"pay-section\"]/descendant::p[contains(text(),'Услуги связи')]");
    private By internetOptionLoc = By.xpath("//*[@id=\"pay-section\"]/descendant::p[contains(text(),'Домашний интернет')]");
    private By installmentOptionLoc = By.xpath("//*[@id=\"pay-section\"]/descendant::p[contains(text(),'Рассрочка')]");
    private By arrearsOptionLoc = By.xpath("//*[@id=\"pay-section\"]/descendant::p[contains(text(),'Задолженность')]");
    private By fieldCommunicationServicePhoneNumberLoc = By.xpath("//*[@id=\"connection-phone\"]");
    private By fieldCommunicationServiceAmountLoc = By.xpath("//*[@id=\"connection-sum\"]");
    private By fieldCommunicationServiceEmailLoc = By.xpath("//*[@id=\"connection-email\"]");
    private By fieldInternetNumberLoc = By.xpath("//*[@id=\"internet-phone\"]");
    private By fieldInternetAmountLoc = By.xpath("//*[@id=\"internet-sum\"]");
    private By fieldInternetEmailLoc = By.xpath("//*[@id=\"internet-email\"]");
    private By fieldInstallmentAccountNumberLoc = By.xpath("//*[@id=\"score-instalment\"]");
    private By fieldInstallmentAmountLoc = By.xpath("//*[@id=\"instalment-sum\"]");
    private By fieldInstallmentEmailLoc = By.xpath("//*[@id=\"instalment-email\"]");
    private By fieldArrearsAccountNumberLoc = By.xpath("//*[@id=\"score-arrears\"]");
    private By fieldArrearsAmountLoc = By.xpath("//*[@id=\"arrears-sum\"]");
    private By fieldArrearsEmailLoc = By.xpath("//*[@id=\"arrears-email\"]");
    private By continueButtonPaymentFormLoc = By.xpath("//*[@id=\"pay-connection\"]/button");

    public MainPageMTSby(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.mts.by/");

        try {
            WebElement closeButton = driver.findElement(closeCookieButtonLoc);
            closeButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка куки не прогрузилась или не активна");
        }
    }

    public void fillPhoneField(String number) {
        WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldCommunicationServicePhoneNumberLoc));
        phoneNumber.click();
        phoneNumber.sendKeys(number);
    }

    public void fillAmountField(String amount) {
        WebElement paymentAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldCommunicationServiceAmountLoc));
        paymentAmount.click();
        paymentAmount.sendKeys(amount);
    }

    public void fillEmailField(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldCommunicationServiceEmailLoc));
        emailField.click();
        emailField.sendKeys(email);
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

    public void selectService(String serviceOption) {
        WebElement dropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(dropDownRawLoc));
        dropDown.click();

        By serviceOptionLoc;
        switch (serviceOption) {
            case (communicationService):
                serviceOptionLoc = communicationServiceOptionLoc;
                break;
            case (internetOption):
                serviceOptionLoc = internetOptionLoc;
                break;
            case (installmentOption):
                serviceOptionLoc = installmentOptionLoc;
                break;
            case (arrearsOption):
                serviceOptionLoc = arrearsOptionLoc;
                break;
            default:
                throw new IllegalArgumentException("Неподдерживаемый тип услуги");
        }

        WebElement service = wait.until(ExpectedConditions.elementToBeClickable(serviceOptionLoc));
        service.click();
    }

    public String getAttributePlaceHolder(By fieldLoc) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(fieldLoc));
        return field.getAttribute("placeholder");
    }

    public String getCommunicationServicePhoneNumberPlaceHolder() {
        return getAttributePlaceHolder(fieldCommunicationServicePhoneNumberLoc);
    }

    public String getCommunicationServiceAmountPlaceHolder() {
        return getAttributePlaceHolder(fieldCommunicationServiceAmountLoc);
    }

    public String getCommunicationServiceEmailPlaceHolder() {
        return getAttributePlaceHolder(fieldCommunicationServiceEmailLoc);
    }

    public String getInternetNumberPlaceHolder() {
        return getAttributePlaceHolder(fieldInternetNumberLoc);
    }

    public String getInternetAmountPlaceHolder() {
        return getAttributePlaceHolder(fieldInternetAmountLoc);
    }

    public String getInternetEmailPlaceHolder() {
        return getAttributePlaceHolder(fieldInternetEmailLoc);
    }

    public String getInstallmentAccountNumberPlaceHolder() {
        return getAttributePlaceHolder(fieldInstallmentAccountNumberLoc);
    }

    public String getInstallmentAmountPlaceHolder() {
        return getAttributePlaceHolder(fieldInstallmentAmountLoc);
    }

    public String getInstallmentEmailPlaceHolder() {
        return getAttributePlaceHolder(fieldInstallmentEmailLoc);
    }

    public String getArrearsAccountNumberPlaceHolder() {
        return getAttributePlaceHolder(fieldArrearsAccountNumberLoc);
    }

    public String getArrearsAmountPlaceHolder() {
        return getAttributePlaceHolder(fieldArrearsAmountLoc);
    }

    public String getArrearsEmailPlaceHolder() {
        return getAttributePlaceHolder(fieldArrearsEmailLoc);
    }
}