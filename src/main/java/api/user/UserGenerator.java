package api.user;

import java.util.Random;

public class UserGenerator {
    public static User getRandomUser(){
        return new User("UserEmail" + new Random().nextInt(500) + "@yandex.ru",
                "1q2w3e$R"+ new Random(500),
                "UserName"+ new Random(500));
    }
}
