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
import pageObject.PasswordRecoveryPage;
import pageObject.RegistrationPage;

public class LoginTest extends BaseTest{
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private PasswordRecoveryPage passwordRecoveryPage;
    private User user;
    private UserClient userClient;
    private Credentials credentials;
    private String accessToken;

    @Before
    public void setUp(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        passwordRecoveryPage = new PasswordRecoveryPage(driver);
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
    @DisplayName("Вход пользовтеля по кнопке «Войти в аккаунт»")
    @Description("Проверка успешного входа пользователя через кнопку «Войти в аккаунт» на главной форме")
    public void successfulUserLoginThroughTheLoginButton(){
        mainPage.clickLoginButton();
        loginPage.enterLoginDetails(credentials.getEmail(), credentials.getPassword());
        boolean expected = true;
        boolean actual = mainPage.checkoutButtonIsDisplayed();
        Assert.assertEquals("Пользовтель не смог авторизоваться", expected, actual);
    }

    @Test
    @DisplayName("Вход пользовтеля через «Личный кабинет»")
    @Description("Проверка успешного входа пользователя через «Личный кабинет»")
    public void successfulUserLoginThroughThePersonalArea(){
        mainPage.clickPersonalAccountButton();
        loginPage.enterLoginDetails(credentials.getEmail(), credentials.getPassword());
        boolean expected = true;
        boolean actual = mainPage.checkoutButtonIsDisplayed();
        Assert.assertEquals("Пользовтель не смог авторизоваться", expected, actual);
    }

    @Test
    @DisplayName("Вход пользовтеля через кнопку на форме регистрации")
    @Description("Проверка успешного входа пользователя через кнопку на форме регистрации")
    public void successfulUserLoginThroughTheButtonRegistrationForm(){
        mainPage.clickPersonalAccountButton();
        loginPage.clickRegisterButton();
        registrationPage.clickInputButton();
        loginPage.enterLoginDetails(credentials.getEmail(), credentials.getPassword());
        boolean expected = true;
        boolean actual = mainPage.checkoutButtonIsDisplayed();
        Assert.assertEquals("Пользовтель не смог авторизоваться", expected, actual);
    }

    @Test
    @DisplayName("Вход пользовтеля через кнопку на форме восстановления пароля")
    @Description("Проверка успешного входа пользователя через кнопку на форме восстановления пароля")
    public void successfulUserLoginThroughTheButtonPasswordRecoveryForm(){
        mainPage.clickPersonalAccountButton();
        loginPage.clickResetPasswordButton();
        passwordRecoveryPage.clickInputButton();
        loginPage.enterLoginDetails(credentials.getEmail(), credentials.getPassword());
        boolean expected = true;
        boolean actual = mainPage.checkoutButtonIsDisplayed();
        Assert.assertEquals("Пользовтель не смог авторизоваться", expected, actual);
    }


}
