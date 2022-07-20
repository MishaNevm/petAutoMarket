import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        User user = new User(123);
        user.setName();
        user.setCity();
        user.setPhoneNumber();
        System.out.println(user.getCity());
        System.out.println(user.getName());
        System.out.println(user.getPhoneNumber());
    }
}
