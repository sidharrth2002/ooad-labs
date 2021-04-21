import java.util.ArrayList;
import java.util.Date;

public class Patient extends Entity {
    //counts patients in the system
    private static int count = 0;
    private ArrayList<MedicalRecord> records = new ArrayList<>();
    private Date dateRegistered;

    //default constructor
    public Patient() {
        super("Unknown", "Unknown");
        this.id = "p" + ++count;
        this.dateRegistered = new Date();
    }

    //constructor with parameters
    public Patient(String name, String phone) {
        super(name, phone);
        this.id = "p" + ++count;
        this.dateRegistered = new Date();
    }

    public void addRecord(MedicalRecord record) {
        records.add(record);
    }

    @Override
    public String toString() {
        return "Patient Name: " + getName() + "\nPhone: " + getPhone();
    }

    //gives the details of the patient
    //graphically prints the details of the patient
    @Override
    public void describe() {
        System.out.println("==========================");
        System.out.println("Patient ID: " + id);
        System.out.println("Patient's name is: " + name);
        System.out.println("Patient's phone is: " + phone);
        System.out.println("Patient registered on: " + dateRegistered); 
        System.out.println("==========================");
    }
}