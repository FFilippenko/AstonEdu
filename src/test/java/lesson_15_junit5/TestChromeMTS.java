package lesson_15_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestChromeMTS {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void before() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cookie-agree\"]")));
            closeButton.click();
        } catch (TimeoutException e) {
            System.out.println("Кнопка куки не прогрузилась или не активна");
        }
    }

    @Test
    public void testTitle() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")));
        assertEquals("Онлайн пополнение без комиссии", element.getText().replaceAll("\\s+", " ").trim(), "Текст не соответствует <Онлайн пополнение без комиссии>");
    }

    @Test
    public void testLogos() {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li/img")));

        for (WebElement element : elements) {
            assertTrue(element.isDisplayed(), element + " не отображается!");
            String src = element.getAttribute("src");
            assertNotNull(src, "Логотип не имеет src");
            assertFalse(src.isEmpty(), "У логотипа пустой src");
        }
        assertEquals(5, elements.size(), "Количество элементов не равно 5!");
    }

    @Test
    public void testRef() {
        WebElement ref = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a")));
        String refStr = ref.getAttribute("href");
        assertNotNull(refStr, "Ссылка не имеет href");
        assertFalse(refStr.isEmpty(), "У ссылки пустой href");
        assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", refStr, "Ссылка ведет на другой сайт");
        ref.click();
        wait.until(ExpectedConditions.urlToBe("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertEquals(driver.getCurrentUrl(), "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", "Ссылка ведет не на тот сайт");
    }

    @Test
    public void testPaymentForm() {
        WebElement dropDownRaw = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        dropDownRaw.click();
        WebElement communicationService = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")));
        communicationService.click();
        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumberField.click();
        phoneNumberField.sendKeys("297777777");
        WebElement paymentAmountField = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        paymentAmountField.click();
        paymentAmountField.sendKeys("100");
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"connection-email\"]"));
        emailField.click();
        emailField.sendKeys("fifil@yandex.ru");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        WebElement paymentIframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[contains(@src, 'checkout.bepaid.by')]")));
        driver.switchTo().frame(paymentIframe);
        WebElement paymentForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'app-wrapper__content-container')]")));
        assertTrue(paymentForm.isDisplayed(), "Форма оплаты не появилась!");
        driver.switchTo().defaultContent();
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}