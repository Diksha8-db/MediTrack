import java.util.*;

public class AuthService {
    private Admin loadAdmin(String email, String pass) {
        return new Admin("A100", "System Administrator", email, pass);
    }    
    
    private Staff loadStaff(String email, String pass) {
        List<String> list = FileHandler.readFile("data/staff.txt");
    
        for (String s : list) {
            String[] p = s.split(",");
            if (p.length < 3) continue;
    
            if (p[2].equals(email)) {
                String id = p[0];
                String name = p[1];
                return new Staff(id, name, email, pass);
            }
        }
    
        return null;
    }

    
    private Patient loadPatient(String email, String pass) {
        List<String> list = FileHandler.readFile("data/patients.txt");
    
        for (int i = 1; i < list.size(); i++) {  
            String[] p = list.get(i).split(",");
    
            if (p[2].equals(email)) {
                String id = p[0];
                String name = p[1];
    
                return new Patient(id, name, email, pass);
            }
        }
    
        System.out.println("Patient record not found in patients.txt");
        return null;
    }

    private Doctor loadDoctor(String email, String pass) {
        List<String> list = FileHandler.readFile("data/doctors.txt");
    
        for (String line : list) {
            String[] p = line.split(",");
    
            if (p.length < 4) continue;
    
            if (p[2].equals(email)) {
                String id = p[0];
                String name = p[1];
    
                return new Doctor(id, name, email, pass);
            }
        }
    
        System.out.println("Doctor record not found in doctors.txt");
        return null;
    }    
    

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
                        case "Admin"   -> loadAdmin(email, pass);
                        case "Staff"   -> loadStaff(email, pass);
                        case "Doctor"  -> loadDoctor(email, pass);
                        case "Patient" -> loadPatient(email, pass);
    
                        default -> null;
                    };
                }
            }
            
        sc.close();
        
        return null;
    }
}
