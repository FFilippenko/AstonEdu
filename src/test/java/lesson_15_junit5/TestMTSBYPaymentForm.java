package lesson_15_junit5;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class TestMTSBYPaymentForm extends TestSettings {

    @Test
    public void testTitle() {
        MainPageMTSby page = new MainPageMTSby(driver);
        assertEquals("Онлайн пополнение без комиссии", page.getPaymentFormTitleText(), "Текст не соответствует <Онлайн пополнение без комиссии>");
    }

    @Test
    public void testLogos() {
        MainPageMTSby page = new MainPageMTSby(driver);
        for (WebElement element : page.getLogosLoc()) {
            assertTrue(element.isDisplayed(), element + " не отображается!");
            String src = element.getAttribute("src");
            assertNotNull(src, "Логотип не имеет src");
            assertFalse(src.isEmpty(), "У логотипа пустой src");
        }
        assertEquals(5, page.getLogosLoc().size(), "Количество элементов не равно 5!");
    }

    @Test
    public void testTermsOfUseRef() {
        MainPageMTSby page = new MainPageMTSby(driver);
        String termsOfUseUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(termsOfUseUrl, page.getTermsOfUseHref(), "Ссылка ведет на другой сайт");
        page.getTermsOfUseLoc().click();
        wait.until(ExpectedConditions.urlToBe(termsOfUseUrl));
    }

    @Test
    public void testAllFieldsFilledCorrectly() {
        MainPageMTSby page = new MainPageMTSby(driver);
        page.fillPaymentForm("297777777", "100", "fifil@yandex.ru");
        page.clickContinueButton();
        assertTrue(page.switchToPaymentForm().isDisplayed(), "Форма оплаты не появилась!");
    }

    @Test
    public void testEmptyForm() {
        MainPageMTSby page = new MainPageMTSby(driver);
        page.clickContinueButton();
        String validationMessage = page.getValidationMessageOfPhoneField();
        assertEquals("Заполните это поле.", validationMessage,
                "Браузер не показал  сообщение <Заполните это поле.>!");
    }

    @Test
    public void testFieldPhoneNumberStartsNotOn29AndNotFull() {
        MainPageMTSby page = new MainPageMTSby(driver);
        page.fillPaymentForm("3015", "100", "fifil@yandex.ru");
        page.clickContinueButton();
        String errorMessage = page.getErrorMessageContainerOfPhoneField();
        assertTrue(errorMessage.contains("Номер телефона указан неверно"));
        assertTrue(errorMessage.contains("Введите номер телефона"));
    }

    @Test
    public void testFieldPhoneNumberStartsOn29AndNotFull() {
        MainPageMTSby page = new MainPageMTSby(driver);
        page.fillPaymentForm("2915", "100", "fifil@yandex.ru");
        page.clickContinueButton();
        String errorMessage = page.getErrorMessageContainerOfPhoneField();
        assertTrue(errorMessage.contains("Введите номер телефона"),
                "Сообщение <Введите номер телефона> не появилось");
    }

    @Test
    public void testFieldPhoneNumberStartsNotOn29AndFull() {
        MainPageMTSby page = new MainPageMTSby(driver);
        page.fillPaymentForm("287777777", "100", "fifil@yandex.ru");
        page.clickContinueButton();
        String errorMessage = page.getErrorMessageContainerOfPhoneField();
        assertTrue(errorMessage.contains("Номер телефона указан неверно"),
                "Сообщение <Номер телефона указан неверно> не появилось");
    }

    @Test
    public void testEmptyFieldAmount() {
        MainPageMTSby page = new MainPageMTSby(driver);
        page.fillPaymentForm("297777777", "", "fifil@yandex.ru");
        page.clickContinueButton();
        String validationMessage = page.getValidationMessageOfAmountField();
        assertEquals("Заполните это поле.", validationMessage,
                "Браузер не показал  сообщение <Заполните это поле.>!");
    }

    @Test
    public void testFieldAmountWithZeroValue() {
        MainPageMTSby page = new MainPageMTSby(driver);
        page.fillPaymentForm("297777777", "0", "fifil@yandex.ru");
        page.clickContinueButton();
        String errorMessage = page.getErrorMessageContainerOfAmountField();
        assertTrue(errorMessage.equals("Введите сумму платежа"),
                "Сообщение <Введите сумму платежа> не появилось");
    }

    @Test
    public void testFieldEmailWithIncorrectFormat() {
        MainPageMTSby page = new MainPageMTSby(driver);
        page.fillPaymentForm("297777777", "100", "fifil");
        page.clickContinueButton();
        String errorMessage = page.getErrorMessageContainerOfEmailField();
        assertTrue(errorMessage.equals("Введите корректный адрес электронной почты."),
                "Сообщение <Введите корректный адрес электронной почты.> не появилось");
    }
}