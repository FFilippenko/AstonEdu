package lesson_15_junit5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSettings {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    private By closeCookieButton = By.xpath("//*[@id=\"cookie-agree\"]");

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
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeCookieButton));
            closeButton.click();
        } catch (TimeoutException e) {
            System.out.println("Кнопка куки не прогрузилась или не активна");
        }
    }

    @AfterAll
    public static void quit() {
        driver.quit();
    }
}
