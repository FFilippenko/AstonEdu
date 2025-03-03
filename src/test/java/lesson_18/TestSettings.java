package lesson_18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSettings {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Duration defaultWaitDuration = Duration.ofSeconds(15);

    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void before() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, defaultWaitDuration);
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }
}
