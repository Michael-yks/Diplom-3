package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    public MainPage(WebDriver driver){
        this.driver = driver;
    }

    // Логотип "Stellar Burgers"
    private By logoStellarBurgers = By.xpath(".//*[@id='root']/div/header/nav/div/a");

    // кнопка "Конструктор"
    private By buttonConstructor = By.xpath(".//*[@id='root']/div/header/nav/ul/li[1]/a");

    // кнопка "Личный кабинет"
    private By buttonPersonalAccount = By.xpath(".//*[@id='root']/div/header/nav/a/p");

    // кнопка "Войти в аккаунт"
    private By loginButton = By.xpath(".//*[@id='root']/div/main/section[2]/div/button");

    // кнопка "Оформить заказ"
    private By checkoutButton = By.xpath(".//*[@id='root']/div/main/section[2]/div/button");

    // Заголовок "Соберите бургер"
    private By headerAssembleBurger = By.xpath(".//*[@id='root']/div/main/section[1]/h1");

    // кнопка "Булки"
    private By bunButton = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[1]/span");

    // подзаголовок "Булки"
    private By subtitleBun = By.xpath(".//*[@id='root']//h2[.='Булки']");

    // кнопка "Соусы"
    private By saucesButton = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[2]/span");

    // подзаголовок "Соусы"
    private By subtitleSauces = By.xpath(".//*[@id='root']//h2[.='Соусы']");

    // кнопка "Начинки"
    private By fillingButton = By.xpath(".//*[@id='root']/div/main/section[1]/div[1]/div[3]/span");

    // подзаголовок "Начинки"
    private By subtitleFilling = By.xpath(".//*[@id='root']//h2[.='Начинки']");

    @Step("Клик на кнопку 'Конструктор'")
    public void clickConstructorButton(){
        driver.findElement(buttonConstructor).click();
    }
    @Step("Клик на логотип 'Stellar Burgers'")
    public void clickLogoStellarBurgers(){
        driver.findElement(logoStellarBurgers).click();
    }
    @Step("Клик на кнопку 'Личный кабинет'")
    public void clickPersonalAccountButton(){
        driver.findElement(buttonPersonalAccount).click();
    }
    @Step("Клик на кнопку 'Войти в аккаунт'")
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    @Step("Клик на кнопку раздела 'Булки'")
    public void clickBunButton(){
        driver.findElement(bunButton).click();
    }
    @Step("Клик на кнопку раздела 'Соусы'")
    public void clickSaucesButton(){
        driver.findElement(saucesButton).click();
    }
    @Step("Клик на кнопку раздела 'Начинки'")
    public void clickFillingButton(){
        driver.findElement(fillingButton).click();
    }
    @Step("Получение текста заголовка 'Соберите бургер'")
    public String getTitleTextAssembleBurger(){
        return driver.findElement(headerAssembleBurger).getText();
    }
    @Step("Проверка наличия подзаголовка 'Булки'")
    public boolean checkoutSubtitleBunIsDisplayed(){
        return driver.findElement(subtitleBun).isDisplayed();
    }
    @Step("Проверка наличия подзаголовка 'Соусы'")
    public boolean checkoutSubtitleSaucesIsDisplayed(){
        return driver.findElement(subtitleSauces).isDisplayed();
    }
    @Step("Проверка наличия подзаголовка 'Начинки'")
    public boolean checkoutSubtitleFillingIsDisplayed(){
        return driver.findElement(subtitleFilling).isDisplayed();
    }
    @Step("Проверка наличия кнопки 'Оформить заказ'")
    public boolean checkoutButtonIsDisplayed(){
        return driver.findElement(checkoutButton).isDisplayed();
    }
}
