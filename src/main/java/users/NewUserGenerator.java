package users;

public class NewUserGenerator {
    public static NewUser generateNewUser() {
        return NewUser.builder()
                .username("Vasya")
                .email("test@test.ru")
                .password("pass12345")
                .build();
    }

    public static NewUser generateNewUserWithoutUserName() {
        return NewUser.builder()
                .email("test@test.ru")
                .password("pass12345")
                .build();
    }

    public static NewUser generateNewUserWithoutEmail() {
        return NewUser.builder()
                .username("Vasya")
                .password("pass12345")
                .build();
    }

    public static NewUser generateNewUserWithoutPassword() {
        return NewUser.builder()
                .username("Vasya")
                .email("test@test.ru")
                .build();
    }


}
