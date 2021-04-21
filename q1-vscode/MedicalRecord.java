import java.util.ArrayList;
import java.util.Date;

public class MedicalRecord {
    private Doctor doctor;
    private Nurse nurse;
    private Patient patient;
    private ArrayList<Medicine> prescribedMedicine = new ArrayList<>();
    private Date date;
    private String description;
    private String ID;
    private static int count = 0;

    public MedicalRecord() {};
    
    public MedicalRecord(Doctor doctor, Nurse nurse, Patient patient, String description,
            ArrayList<Medicine> medicines) {
        this.doctor = doctor;
        this.nurse = nurse;
        this.patient = patient;
        this.setDescription(description);
        this.ID = "MR" + ++count;
        this.prescribedMedicine = medicines;
        this.setDate(new Date());
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addMedicine(Medicine medicine) {
        prescribedMedicine.add(medicine);
    }

    public void describe() {
        System.out.println("===========================");
        System.out.println("MEDICAL RECORD #" + getID());
        System.out.println();
        System.out.println("DATE CREATED: " + getDate());
        System.out.println();
        System.out.println("ATTENDING DOCTOR IS: ");
        doctor.describe();
        System.out.println();
        System.out.println("ATTENDING NURSE IS: ");
        nurse.describe();
        System.out.println();
        System.out.println("PATIENT: ");
        patient.describe();
        System.out.println();
        System.out.println("MEDICINE PRESCRIBED: ");
        //loop through medicine in this prescription
        for(Medicine medicine: prescribedMedicine) {
            System.out.println("====================");
            System.out.println(medicine);
            System.out.println("====================");
            System.out.println();
        }
        System.out.println("============================");
    }
}