import java.io.*;
import java.util.*;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1192947544117862512L;
    Scanner scan = new Scanner(System.in);
    private static int id = 1;
    private final int userId;
    private String name;
    private String city;
    private long phoneNumber;
    private static File usersDir = new File("Users");
    File userFile;
    public static String separator = File.separator;

    public User() throws IOException {
        userId = id;
        id++;
        setName();
        setCity();
        setPhoneNumber();
    }


    public void setName() {
        System.out.print("Введите ваше имя: ");
        name = scan.nextLine();
        if (name == null || name.isEmpty()) {
            setName();
        }
    }

    public void setCity() throws IOException {
        ArrayList<String> cityArray = new ArrayList<>();
        File cityFile = new File("City.txt");
        BufferedReader bf = new BufferedReader(new FileReader(cityFile));
        for (int i = 0; i < cityFile.length(); i++) {
            cityArray.add(bf.readLine());
        }
        cityArray.removeAll(Arrays.asList("", null));
        boolean a = true;
        while (a) {
            System.out.print("Введите Ваш город: ");
            city = scan.nextLine().toLowerCase(Locale.ROOT);
            for (String i : cityArray) {
                if (city.equals(i.toLowerCase(Locale.ROOT))) {
                    a = false;
                    break;
                }
            }
            if (a) {
                System.out.println("Такого города нет в России: ");
            }
        }
    }

    public void setPhoneNumber() {
        try {
            System.out.print("Введите Ваш номер телефона: +7");
            phoneNumber = scan.nextLong();
            if (String.valueOf(phoneNumber).length() != 10) {
                System.out.println("Некорректный ввод");
                setPhoneNumber();
            }
        } catch (InputMismatchException e) {
            System.out.println("Error 101");
        }
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public int getId() {
        return userId;
    }

    public String toString() {
        return name + " " + id + " " + city + " " + phoneNumber;
    }

    public static void whiteUserObject(User user) throws IOException {
        usersDir.mkdir();
        File userFile = new File(usersDir + separator + "user" + user.getId() + ".bin");
        if (userFile.exists()){
            userFile.createNewFile();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(userFile));
        oos.writeObject(user);
        oos.close();
    }

    public static User readUserObject(int id) {
        usersDir.mkdir();
        User user = null;
        String userFileName = usersDir + separator + "user" + id + ".bin";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(userFileName))) {
            user = (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return user;
    }
}
