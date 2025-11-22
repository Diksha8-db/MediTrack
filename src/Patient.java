public class Patient extends User {

    public Patient(String id, String name, String email, String pass) {
        super(id, name, email, pass);
    }

    @Override
    public void displayMenu() {
        while (true) {
            System.out.println("\n===== PATIENT PORTAL =====");
            System.out.println("1. View My Doctor");
            System.out.println("2. View My Appointments");
            System.out.println("3. Logout");

            int c = sc.nextInt(); sc.nextLine();

            switch (c) {
                case 1 -> FileHandler.viewPatientDoctor(id);
                case 2 -> FileHandler.viewPatientAppointments(id);
                case 3 -> { System.out.println("Logging out..."); return; }
            }
        }
    }
}
