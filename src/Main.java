
public class Main {
    public static void main(String[] args)  {
        User user1 = new User();
        User.writeUserObject(user1);
        User user2 = User.readUserObject(1);
        System.out.println(user2);
    }
}
