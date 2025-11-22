public class Staff extends User {

    public Staff(String id, String name, String email, String pass) {
        super(id, name, email, pass);
    }

    @Override
    public void displayMenu() {
        while (true) {
            System.out.println("\n===== STAFF PORTAL =====");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Appointments");
            System.out.println("3. Logout");

            int c = sc.nextInt(); sc.nextLine();

            switch (c) {
                case 1 -> FileHandler.managePatients();
                case 2 -> FileHandler.manageAppointments();
                case 3 -> { System.out.println("Logging out..."); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
