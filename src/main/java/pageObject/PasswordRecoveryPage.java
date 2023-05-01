package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage {
    private WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    // заголовок формы "Восстановление пароля"
    private By headingPasswordRecovery = By.xpath(".//*[@id='root']/div/main/div/h2");

    // кнопка "Войти" в разделе "Вспомнили пароль?"
    private By inputButton = By.xpath(".//*[@id='root']/div/main/div/div/p/a");

    // метод для получения текста заголовка "Восстановление пароля"
    public String getTitleTextRegistration(){
        return driver.findElement(headingPasswordRecovery).getText();
    }
    @Step("Клик на кнопку 'Войти' на станице восстановления пароля")
    public void clickInputButton(){
        driver.findElement(inputButton).click();
    }
}
