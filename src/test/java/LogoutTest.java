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

public class LogoutTest extends BaseTest{
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
    @DisplayName("Выход из акканута пользователя")
    @Description("Проверка возможности выхода из аккаунта по кнопке «Выйти» в личном кабинете")
    public void successfulLogoutUserAccount(){
        mainPage.clickLoginButton();
        loginPage.enterLoginDetails(credentials.getEmail(), credentials.getPassword());
        mainPage.clickPersonalAccountButton();
        profilePage.clickExitButton();
        String expected = "Вход";
        String actual = loginPage.getTitleTextInput();
        Assert.assertEquals("Не совершен выход из аккаунта пользователя", expected, actual);
    }
}