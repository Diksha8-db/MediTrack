public class Doctor extends User {

    public Doctor(String id, String name, String email, String pass) {
        super(id, name, email, pass);
    }

    @Override
    public void displayMenu() {
        while (true) {
            System.out.println("\n===== DOCTOR PORTAL =====");
            System.out.println("1. View My Patients");
            System.out.println("2. View My Appointments");
            System.out.println("3. Logout");
            System.out.print("Enter choice: ");

            int c = sc.nextInt(); sc.nextLine();

            switch (c) {
                case 1 -> FileHandler.viewDoctorPatients(id);
                case 2 -> FileHandler.viewDoctorAppointments(id);
                case 3 -> { System.out.println("Logging out..."); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
