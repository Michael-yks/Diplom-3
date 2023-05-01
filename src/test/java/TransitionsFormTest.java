import api.user.Credentials;
import api.user.User;
import api.user.UserClient;
import api.user.UserGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProfilePage;

public class TransitionsFormTest extends BaseTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private ProfilePage profilePage;
    private User user;
    private UserClient userClient;
    private Credentials credentials;
    private String accessToken;

    @Before
    public void setUp(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        userClient = new UserClient();
        user = UserGenerator.getRandomUser();
        ValidatableResponse response = userClient.createUser(user);
        accessToken = response.extract().path("accessToken");
        credentials = Credentials.from(user);
    }

    @After
    public void deleteUp(){
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Переход в личный кабинет ")
    @Description("Проверка успешного перехода в личный кабинет зарегистрированного пользовтеля")
    public void successfulTransitionToPersonalAccount(){
        mainPage.clickLoginButton();
        loginPage.enterLoginDetails(credentials.getEmail(), credentials.getPassword());
        mainPage.clickPersonalAccountButton();
        boolean expected = true;
        boolean actual = profilePage.checkProfileButton();
        Assert.assertEquals("Переход в личный кабинет не осуществлен", expected, actual);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор через кнопку «Конструктор»")
    @Description("Проверка успешного перехода из личного кабинета в конструктор через кнопку «Конструктор»")
    public void successfulTransitionToConstructorWithConstructorButton(){
        mainPage.clickLoginButton();
        loginPage.enterLoginDetails(credentials.getEmail(), credentials.getPassword());
        mainPage.clickPersonalAccountButton();
        profilePage.checkProfileButton();
        mainPage.clickConstructorButton();
        String expected = "Соберите бургер";
        String actual = mainPage.getTitleTextAssembleBurger();
        Assert.assertEquals("Переход из личного кабинета в конструктор не осуществлен", expected, actual);
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор через логотип Stellar Burgers")
    @Description("Проверка успешного перехода из личного кабинета в конструктор через логотип Stellar Burgers")
    public void successfulTransitionToConstructorWithLogoStellarBurgers(){
        mainPage.clickLoginButton();
        loginPage.enterLoginDetails(credentials.getEmail(), credentials.getPassword());
        mainPage.clickPersonalAccountButton();
        profilePage.checkProfileButton();
        mainPage.clickLogoStellarBurgers();
        String expected = "Соберите бургер";
        String actual = mainPage.getTitleTextAssembleBurger();
        Assert.assertEquals("Переход из личного кабинета в конструктор не осуществлен", expected, actual);
    }
}
