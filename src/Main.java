import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User(123);
        user.setPhoneNumber();
        System.out.println(user.getPhoneNumber());
    }
}
