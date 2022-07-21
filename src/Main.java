import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args)  throws IOException, ClassNotFoundException {
        User user1 = new User();
        user1.whiteUserObject(user1);
        User user2 = user1.readUserObject();
        System.out.println(user2);
    }
}
