import java.io.*;
import java.util.*;

public class FileHandler {

    static String USER_FILE = "data/users.txt";
    static String DOCTOR_FILE = "data/doctors.txt";
    static String STAFF_FILE = "data/staff.txt";
    static String PATIENT_FILE = "data/patients.txt";
    static String APPOINTMENT_FILE = "data/appointments.txt";

    // Utility 
    static List<String> readFile(String file) {
        try { return new ArrayList<>(java.nio.file.Files.readAllLines(new File(file).toPath())); }
        catch (Exception e) { return new ArrayList<>(); }
    }

    static void writeFile(String file, List<String> data) {
        try { java.nio.file.Files.write(new File(file).toPath(), data); }
        catch (Exception e) { System.out.println("Error writing file: " + file); }
    }

    // ADMIN CRUD 
    public static void manageDoctors() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Manage Doctors ---");
        List<String> docs = readFile(DOCTOR_FILE);

        System.out.println("1. View All");
        System.out.println("2. Add");
        System.out.println("3. Delete");
        System.out.print("Choice: ");
        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> docs.forEach(System.out::println);

            case 2 -> {
                System.out.println("Enter Doctor Details:");
                System.out.print("Doctor ID: "); String id = sc.nextLine();
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Specialization: "); String spec = sc.nextLine();

                String record = id + "," + name + "," + email + "," + spec;
                docs.add(record);
                writeFile(DOCTOR_FILE, docs);
                System.out.println("Doctor added successfully!");
            }

            case 3 -> {
                System.out.print("Enter line number to delete: ");
                int line = sc.nextInt();
                if(line > 0 && line <= docs.size()) {
                    docs.remove(line - 1);
                    writeFile(DOCTOR_FILE, docs);
                    System.out.println("Doctor deleted successfully!");
                } else {
                    System.out.println("Invalid line number.");
                }
            }
        }
    }

    public static void manageStaff() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Manage Staff ---");
        List<String> staffList = readFile(STAFF_FILE);

        System.out.println("1. View All");
        System.out.println("2. Add");
        System.out.println("3. Delete");
        System.out.print("Choice: ");
        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> staffList.forEach(System.out::println);

            case 2 -> {
                System.out.println("Enter Staff Details:");
                System.out.print("Staff ID: "); String id = sc.nextLine();
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Department: "); String dept = sc.nextLine();

                String record = id + "," + name + "," + email + "," + dept;
                staffList.add(record);
                writeFile(STAFF_FILE, staffList);
                System.out.println("Staff added successfully!");
            }

            case 3 -> {
                System.out.print("Enter line number to delete: ");
                int line = sc.nextInt();
                if(line > 0 && line <= staffList.size()) {
                    staffList.remove(line - 1);
                    writeFile(STAFF_FILE, staffList);
                    System.out.println("Staff deleted successfully!");
                } else {
                    System.out.println("Invalid line number.");
                }
            }
        }
    }

    // STAFF Patients 
    public static void managePatients() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Manage Patients ---");
        List<String> patients = readFile(PATIENT_FILE);

        System.out.println("1. View All");
        System.out.println("2. Add");
        System.out.println("3. Delete");
        System.out.print("Choice: ");
        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> patients.forEach(System.out::println);

            case 2 -> {
                System.out.println("Enter Patient Details:");
                System.out.print("Patient ID: "); String id = sc.nextLine();
                System.out.print("Name: "); String name = sc.nextLine();
                System.out.print("Email: "); String email = sc.nextLine();
                System.out.print("Disease: "); String disease = sc.nextLine();
                System.out.print("Assigned Doctor ID: "); String docID = sc.nextLine();

                String record = id + "," + name + "," + email + "," + disease + "," + docID;
                patients.add(record);
                writeFile(PATIENT_FILE, patients);
                System.out.println("Patient added successfully!");
            }

            case 3 -> {
                System.out.print("Enter line number to delete: ");
                int line = sc.nextInt();
                if(line > 0 && line <= patients.size()) {
                    patients.remove(line - 1);
                    writeFile(PATIENT_FILE, patients);
                    System.out.println("Patient deleted successfully!");
                } else {
                    System.out.println("Invalid line number.");
                }
            }
        }
    }

    // Appointments
    public static void manageAppointments() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Manage Appointments ---");
        List<String> appointments = readFile(APPOINTMENT_FILE);

        System.out.println("1. View All");
        System.out.println("2. Add");
        System.out.println("3. Delete");
        System.out.print("Choice: ");
        int c = sc.nextInt(); sc.nextLine();

        switch (c) {
            case 1 -> appointments.forEach(System.out::println);

            case 2 -> {
                System.out.println("Enter Appointment Details:");
                System.out.print("Appointment ID: "); String id = sc.nextLine();
                System.out.print("Doctor ID: "); String docID = sc.nextLine();
                System.out.print("Patient ID: "); String patID = sc.nextLine();
                System.out.print("Date (YYYY-MM-DD): "); String date = sc.nextLine();
                System.out.print("Time (HH:MM AM/PM): "); String time = sc.nextLine();
                System.out.print("Status (Pending/Completed): "); String status = sc.nextLine();

                String record = id + "," + docID + "," + patID + "," + date + "," + time + "," + status;
                appointments.add(record);
                writeFile(APPOINTMENT_FILE, appointments);
                System.out.println("Appointment added successfully!");
            }

            case 3 -> {
                System.out.print("Enter line number to delete: ");
                int line = sc.nextInt();
                if(line > 0 && line <= appointments.size()) {
                    appointments.remove(line - 1);
                    writeFile(APPOINTMENT_FILE, appointments);
                    System.out.println("Appointment deleted successfully!");
                } else {
                    System.out.println("Invalid line number.");
                }
            }
        }
    }

    // DOCTOR VIEW 
    public static void viewDoctorPatients(String docID) {
        readFile(PATIENT_FILE).stream()
                .filter(l -> l.contains("," + docID))
                .forEach(System.out::println);
    }

    public static void viewDoctorAppointments(String docID) {
        readFile(APPOINTMENT_FILE).stream()
                .filter(l -> l.contains("," + docID + ","))
                .forEach(System.out::println);
    }

    // PATIENT VIEW 
    public static void viewPatientDoctor(String patID) {
        readFile(PATIENT_FILE).stream()
                .filter(l -> l.contains(patID + ","))
                .forEach(System.out::println);
    }

    public static void viewPatientAppointments(String patID) {
        readFile(APPOINTMENT_FILE).stream()
                .filter(l -> l.contains("," + patID + ","))
                .forEach(System.out::println);
    }

    // ADMIN VIEW
    public static void viewPatients() {
        readFile(PATIENT_FILE).forEach(System.out::println);
    }

    public static void viewAppointments() {
        readFile(APPOINTMENT_FILE).forEach(System.out::println);
    }
}
