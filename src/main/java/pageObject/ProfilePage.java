package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // кнопка "Профиль"
    private By profileButton = By.xpath(".//*[@id='root']/div/main/div/nav/ul/li[1]/a");

    // кнопка "Выход"
    private By exitButton = By.xpath(".//*[@id='root']/div/main/div/nav/ul/li[3]/button");
    @Step("Проверка наличия кнопки 'Профиль'")
    public boolean checkProfileButton(){
        return driver.findElement(profileButton).isDisplayed();
    }
    @Step("Клик на кнопку 'Выход'")
    public void clickExitButton(){
        driver.findElement(exitButton).click();
    }

}
