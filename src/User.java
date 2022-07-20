import java.io.*;
import java.util.*;

public class User {
    Scanner scan = new Scanner(System.in);
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
        setName();
        System.out.print("Введите ваш город: ");
        city = scan.nextLine();
        System.out.print("Введите ваш номер телефона: +7");
        phoneNumber = scan.nextInt();
        usersDir = new File("Users");
        usersDir.mkdir();
        userFile = new File(usersDir + name + phoneNumber + ".bin");
        if (userFile.exists()) {
            userFile.createNewFile();
        }
        oos = new ObjectOutputStream(new FileOutputStream(userFile));
        ois = new ObjectInputStream(new FileInputStream(userFile));
    }

    public ObjectInputStream getOis() {
        return ois;
    }

    public ObjectOutputStream getOos() {
        return oos;
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
        System.out.print("Введите Ваш номер телефона : +7");
        phoneNumber = scan.nextLong();
        if (10 != String.valueOf(phoneNumber).length()) {
            setPhoneNumber();
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
}
