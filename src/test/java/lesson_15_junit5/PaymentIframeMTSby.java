package lesson_15_junit5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentIframeMTSby {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private By paymentFormLoc = By.xpath("//div[contains(@class, 'app-wrapper__content-container')]");

    public PaymentIframeMTSby(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    public boolean isPaymentFormDisplayed(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(paymentFormLoc)).isDisplayed();
    }
}
