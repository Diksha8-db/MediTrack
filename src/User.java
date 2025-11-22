import java.util.Scanner;

public abstract class User {
    protected String id;
    protected String name;
    protected String email;
    protected String password;

    Scanner sc = new Scanner(System.in);

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }

    public abstract void displayMenu(); 
}
