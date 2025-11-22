import java.util.*;

public class AuthService {

    public User login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Password: ");
        String pass = sc.nextLine();

        List<String> users = FileHandler.readFile("data/users.txt");

        for (String u : users) {
            String[] p = u.split(",");

            if (p[0].equals(email) && p[1].equals(pass)) {

                return switch (p[2]) {
                    case "Admin" -> new Admin("A1", "Admin", email, pass);
                    case "Staff" -> new Staff("S1", "Staff", email, pass);
                    case "Doctor" -> new Doctor("D1", "Doctor", email, pass);
                    case "Patient" -> new Patient("P1", "Patient", email, pass);
                    default -> null;
                };
            }
        }
        return null;
    }
}
