import java.util.*;

public class Admin extends User {

    public Admin(String id, String name, String email, String pass) {
        super(id, name, email, pass);
    }

    @Override
    public void displayMenu() {
        while (true) {
            System.out.println("\n=====  ADMIN DASHBOARD =====");
            System.out.println("1. Manage Doctors");
            System.out.println("2. Manage Staff");
            System.out.println("3. View Patients");
            System.out.println("4. View Appointments");
            System.out.println("5. Logout");
            System.out.print("Enter choice: ");

            int c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1 -> FileHandler.manageDoctors();
                case 2 -> FileHandler.manageStaff();
                case 3 -> FileHandler.viewPatients();
                case 4 -> FileHandler.viewAppointments();
                case 5 -> { System.out.println("Logging out..."); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
