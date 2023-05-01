import api.user.Credentials;
import api.user.User;
import api.user.UserClient;
import api.user.UserGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.RegistrationPage;

public class RegistrationTest extends BaseTest {
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private User user;
    private UserClient userClient;
    private Credentials credentials;
    private String accessToken;

    @Before
    public void setUp(){
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        userClient = new UserClient();
        user = UserGenerator.getRandomUser();
        credentials = Credentials.from(user);
    }

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка что уникальный пользователь может быть создан")
    public void userCanBeSuccessfullyCreated(){
        mainPage.clickLoginButton();
        loginPage.clickRegisterButton();
        registrationPage.enterRegistrationDetails(user.getName(), user.getEmail(),user.getPassword());
        String expected = "Вход";
        String actual = loginPage.getTitleTextInput();
        Assert.assertEquals("Регистрация клиента не прошла", expected, actual);
        ValidatableResponse response = userClient.loginUser(credentials);
        accessToken = response.extract().path("accessToken");
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Регистрация пользователя с некорректным паролем")
    @Description("Проверка что пользовтель не может быть создан с паролем менее 6 символов")
    public void errorCreatingUserWithInvalidPassword(){
        mainPage.clickLoginButton();
        loginPage.clickRegisterButton();
        user.setPassword("1q2w");
        registrationPage.enterRegistrationDetails(user.getName(), user.getEmail(),user.getPassword());
        String expected = "Некорректный пароль";
        String actual = registrationPage.getErrorPasswordText();
        Assert.assertEquals("Не отображается ошибка/неверный текст ошибки", expected, actual);

    }




}

