public class Appointment {
    String id;
    String doctorID;
    String patientID;
    String date;
    String time;
    String status;

    public Appointment(String id, String doc, String pat, String d, String t, String s) {
        this.id = id;
        this.doctorID = doc;
        this.patientID = pat;
        this.date = d;
        this.time = t;
        this.status = s;
    }
}
