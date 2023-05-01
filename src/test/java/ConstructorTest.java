import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObject.MainPage;

public class ConstructorTest extends BaseTest{
    private MainPage mainPage;

    @Before
    public void setUp(){
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Успешный переход к разделу булки")
    @Description("Проверка что работает переход к разделу булки в конструкторе")
    public void successfulTransitionBunSection(){
        mainPage.clickFillingButton();
        mainPage.clickBunButton();
        boolean expected = true;
        boolean actual = mainPage.checkoutSubtitleBunIsDisplayed();
        Assert.assertEquals("Переход к разделу булки не осуществлен", expected, actual);
    }

    @Test
    @DisplayName("Успешный переход к разделу соусы")
    @Description("Проверка что работает переход к разделу соусы в конструкторе")
    public void successfulTransitionSaucesSection(){
        mainPage.clickFillingButton();
        mainPage.clickSaucesButton();
        boolean expected = true;
        boolean actual = mainPage.checkoutSubtitleSaucesIsDisplayed();
        Assert.assertEquals("Переход к разделу соусы не осуществлен", expected, actual);
    }

    @Test
    @DisplayName("Успешный переход к разделу начинки")
    @Description("Проверка что работает переход к разделу начинки в конструкторе")
    public void successfulTransitionFillingSection(){
        mainPage.clickFillingButton();
        boolean expected = true;
        boolean actual = mainPage.checkoutSubtitleFillingIsDisplayed();
        Assert.assertEquals("Переход к разделу соусы не осуществлен", expected, actual);
    }
}
