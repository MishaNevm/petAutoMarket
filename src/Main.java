import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args)  throws IOException, ClassNotFoundException {
        User user1 = new User();
        User.whiteUserObject(user1);
    }
}
