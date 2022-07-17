import java.io.*;
import java.util.Scanner;

public class User {
    Scanner scan = new Scanner(System.in);
    private String name;
    private String city;
    private int phoneNumber;
    File usersDir;
    File userFile;
    FileOutputStream fos;
    ObjectOutputStream oos;
    FileInputStream fis;
    ObjectInputStream ois;
    public User () throws IOException {
        System.out.print("Введите ваше имя: ");
        name = scan.nextLine();
        System.out.print("Введите ваш город: ");
        city = scan.nextLine();
        System.out.print("Введите ваш номер телефона: +7");
        phoneNumber = scan.nextInt();
        usersDir = new File("Users");
        usersDir.mkdir();
        userFile = new File(usersDir + name + phoneNumber + ".bin");
        if (userFile.exists()){
            userFile.createNewFile();
        }
        oos = new ObjectOutputStream(new FileOutputStream(userFile));
        ois = new ObjectInputStream(new FileInputStream(userFile));
    }
    public ObjectInputStream getOis () {
        return ois;
    }
    public ObjectOutputStream getOos () {
        return oos;
    }
}
