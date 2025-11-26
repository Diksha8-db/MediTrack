public class HospitalSystem {

    public static void main(String[] args) {

        System.out.println("\n==================================================");
        System.out.println("          WELCOME TO MEDI-TRACK HMS PORTAL ");
        System.out.println("==================================================");
        System.out.println(" A Complete Console-Based Hospital Management System");
        System.out.println(" Manage Doctors | Staff | Patients | Appointments");
        System.out.println("==================================================\n");

        // About HMS
        System.out.println("About MediTrack HMS:");
        System.out.println("This Hospital Management System (HMS) is designed to manage");
        System.out.println("all critical operations of a hospital in a digital way. It");
        System.out.println("supports role-based access for Admins, Doctors, Staff, and Patients,");
        System.out.println("and allows management of patient records, appointments, medical reports,");
        System.out.println("and hospital staff efficiently.\n");

        System.out.println("Instructions:");
        System.out.println("1. Enter your registered email and password to login.");
        System.out.println("2. After login, follow the menu options for your role.");
        System.out.println("3. Use numbers to navigate menus.");
        System.out.println("4. Logout to save data and exit safely.\n");

        // Authentication 
        AuthService auth = new AuthService();
        User loggedInUser = auth.login(); 

        //  Post-login Handling 
        if (loggedInUser != null) {
            System.out.println("\nLogin Successful! Welcome, " + loggedInUser.getName() + "!");
            System.out.println("You are logged in as: " + loggedInUser.getClass().getSimpleName() + "\n");

            // Launch role-based menu
            loggedInUser.displayMenu();

        } else {
            System.out.println("\nInvalid credentials. Exiting system...");
        }

        System.out.println("\nThank you for using MediTrack HMS!");
        System.out.println("==================================================\n");
    }
}
