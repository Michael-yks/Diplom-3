package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    // заголовок формы "Регистрация"
    private By headingRegistration = By.xpath(".//*[@id='root']/div/main/div/h2");

    // поле для ввода "Имя"
    private By inputFieldName = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[1]/div/div/input");

    // поле для ввода "Email"
    private By inputFieldEmail = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[2]/div/div/input");

    // поле для ввода "Пароль"
    private By inputFieldPassword = By.xpath(".//*[@id='root']/div/main/div/form/fieldset[3]/div/div/input");

    // кнопка "Зарегистрироваться"
    private By registrationButton = By.xpath(".//*[@id='root']/div/main/div/form/button");

    // кнопка "Войти" (в разделе "Уже зарегистрированы?")
    private By inputButton = By.xpath(".//*[@id='root']/div/main/div/div/p/a");

    // ошибка "Некорректный пароль" (при вводе менее 6 симовлов)
    private By errorIncorrectPassword = By.xpath("//*[@id='root']/div/main/div/form/fieldset[3]/div/p");

    @Step("Получить текст заголовка 'Регистрация'")
    public String getTitleTextRegistration(){
        return driver.findElement(headingRegistration).getText();
    }
    @Step("Клик и ввод значения в поле 'name'")
    public void inputName(String name){
        driver.findElement(inputFieldName).click();
        driver.findElement(inputFieldName).sendKeys(name);
    }
    @Step("Клик и ввод значения в поле 'email'")
    public void inputEmail(String email){
        driver.findElement(inputFieldEmail).click();
        driver.findElement(inputFieldEmail).sendKeys(email);
    }
    @Step("Клик и ввод значения в поле 'пароль'")
    public void inputPassword(String password){
        driver.findElement(inputFieldPassword).click();
        driver.findElement(inputFieldPassword).sendKeys(password);
    }
    @Step("Клик на кнопку 'Зарегистрироваться'")
    public void clickRegistrationButton(){
        driver.findElement(registrationButton).click();
    }
    @Step("Клик на кнопку 'Войти'")
    public void clickInputButton(){
        driver.findElement(inputButton).click();
    }
    @Step("Получить текст ошибки некорректного пароля")
    public String getErrorPasswordText(){
        return driver.findElement(errorIncorrectPassword).getText();
    }
    @Step("Ввод значений в поля для регистрации и клик на кнопку 'Зарегистрироваться'")
    // метод для заполнения полей и регистрации
    public void enterRegistrationDetails(String name, String email, String password){
        inputName(name);
        inputEmail(email);
        inputPassword(password);
        clickRegistrationButton();
    }
}
