package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // заголовок на форме "Вход"
    private By headingInput = By.xpath(".//*[@id='root']//h2[.='Вход']");

    // поле для ввода email
    private By emailInputField = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");

    // поле для ввода "пароль"
    private By passwordEntryField = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");

    // кнопка "Войти"
    private By loginButton = By.xpath(".//*[@id='root']/div/main/div/form/button");

    // кнопка "Зарегистрироваться"
    private By registerButton = By.xpath(".//*[@id='root']/div/main/div/div/p[1]/a");

    // кнопка "Восстаносить пароль"
    private By resetPasswordButton = By.xpath(".//*[@id='root']/div/main/div/div/p[2]/a");

    @Step("Получить текст заголовка 'Вход'")
    public String getTitleTextInput(){
        return driver.findElement(headingInput).getText();
    }
    @Step("Клик и ввод значения в поле 'email'")
    public void inputEmail(String email){
        driver.findElement(emailInputField).click();
        driver.findElement(emailInputField).sendKeys(email);
    }
    @Step("Клик и ввод значения в поле 'пароль'")
    public void inputPassword(String password){
        driver.findElement(passwordEntryField).click();
        driver.findElement(passwordEntryField).sendKeys(password);
    }
    @Step("Клик на кнопку 'Войти'")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    @Step("Клик на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton(){
        driver.findElement(registerButton).click();
    }
    @Step("Клик на кнопку 'Восстановить пароль'")
    public void clickResetPasswordButton(){
        driver.findElement(resetPasswordButton).click();
    }
    @Step("Ввод значений в поля для авторизации и клик на кнопку вход")
    public void enterLoginDetails(String email, String password){
        inputEmail(email);
        inputPassword(password);
        clickLoginButton();
    }
}
