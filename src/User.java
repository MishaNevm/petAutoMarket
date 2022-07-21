import java.io.*;
import java.util.*;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1192947544117862512L;
    Scanner scan = new Scanner(System.in);
    private static int id = 1;
    private int userId;
    private String name;
    private String city;
    private long phoneNumber;
    File usersDir;
    File userFile;
    FileOutputStream fos;
    ObjectOutputStream oos;
    FileInputStream fis;
    ObjectInputStream ois;

    public User(int phoneNumer) {
        this.phoneNumber = phoneNumer;
    }

    public User() throws IOException {
        userId = id;
        id++;
        setName();
        setCity();
        setPhoneNumber();
        usersDir = new File("Users");
        usersDir.mkdir();
        userFile = new File(usersDir + "user" +userId + ".bin");
        if (userFile.exists()) {
            userFile.createNewFile();
        }
        oos = new ObjectOutputStream(new FileOutputStream(userFile));
        ois = new ObjectInputStream(new FileInputStream(userFile));
    }

    public void whiteUserObject (User user) throws IOException {
        oos.writeObject(user);
        oos.close();
    }

    public User readUserObject() throws IOException, ClassNotFoundException {
        User user = (User) ois.readObject();
        return user;
    }

    public void setName() {
        boolean a = true;
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
        String nl;
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
    
    public String toString () {
        return name + " " + id + " " + city + " " + phoneNumber; 
    }
}
