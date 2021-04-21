import java.util.ArrayList;
import java.util.Scanner;

public class ClinicManagement {
    //arraylists
    private static ArrayList<Entity> users = new ArrayList<>();
    private static ArrayList<Medicine> medicines = new ArrayList<>();
    private static ArrayList<MedicalRecord> records = new ArrayList<>();

    public static void main(String[] args) {
        loadInitialData();
        Scanner input = new Scanner(System.in);
        boolean repeat = false;
        do {
            //welcome message
            System.out.println("===================");
            System.out.println("Sidharrth's Hospital Management System");
            System.out.println("A custom solution to manage records");
            System.out.println("===================");

            System.out.println("Choose from one of the options below: ");
            System.out.println("1. View The Users in Your Hospital"); 
            System.out.println("2. View Medical Records");
            System.out.println("3. Add New Patient");
            System.out.println("4. Add New Record");
            System.out.println("5. Exit Program");
            
            String choice1 = input.nextLine();
            switch(choice1) {
                case "1":
                    //loop through users in system and polymorphically describe them
                    //I would have done this in a neater fashion had I not been forced to use polymorphism
                    for (Entity user : users) {
                        //use of polymorphism
                        // System.out.println("===================");
                        user.describe();
                        // System.out.println("===================");
                        System.out.println();
                    }
                    break;
                
                case "2":
                    //loop through and describe the various records
                    for(MedicalRecord record: records) {
                        // System.out.println("===================");
                        System.out.println();
                        record.describe();
                        System.out.println();
                        System.out.println();
                        // System.out.println("===================");
                    }
                    break;

                case "3":
                    System.out.println("Add a New Patient");
                    String patientName, patientPhone;
                    System.out.println("Enter Patient Name: ");
                    patientName = input.nextLine();
                    System.out.println("Enter Patient Phone: ");
                    patientPhone = input.nextLine();
                    Patient newPatient = new Patient(patientName, patientPhone);
                    users.add(newPatient);
                    break;

                case "4":
                    System.out.println("Let's add a new record");
                    String doctorID, nurseID, patientID, medicineID;
                    Entity doctor, nurse, patient;
                    doctor = nurse = patient = null;
                    //only print the doctors (either this or use instanceof)
                    for(Entity user : users) {
                        if(user.getId().charAt(0) == 'd') {
                            //use of polymorphism
                            user.describe();
                        }
                    }
                    boolean doctorCheck = false;
                    do {
                        System.out.println("Enter the ID that comes before the doctor: ");
                        doctorID = input.nextLine();
                        //make sure it's a valid ID entered
                        for(Entity user : users) {
                            if(user.getId().equals(doctorID) && (doctorID.charAt(0) == 'd')) {
                                doctorCheck = true;
                                doctor = user;
                                break;
                            } 
                        }   
                        if(!doctorCheck) {
                            System.out.println("Invalid ID. Try again");
                        } 
                    } while(!doctorCheck);
                    
                    for(Entity user : users) {
                        //only print the nurses
                        if(user.getId().charAt(0) == 'n') {
                            //use of polymorphism
                            user.describe();
                        }
                    }
                    boolean nurseCheck = false;
                    do {
                        System.out.println("Enter the ID that comes before the nurse: ");
                        nurseID = input.nextLine();
                        for(Entity user : users) {
                            //make sure only a valid nurse ID is entered
                            if(user.getId().equals(nurseID) && (nurseID.charAt(0) == 'n')) {
                                nurseCheck = true;
                                nurse = user;
                                break;
                            }
                        }    
                        if(!nurseCheck) {
                            System.out.println("Invalid ID. Try again");
                        }
                    } while(!nurseCheck);

                    for(Entity user : users) {
                        //Only print the patients in the system
                        if(user.getId().charAt(0) == 'p') {
                            //use of polymorphism
                            user.describe();
                        }
                    }
                    boolean patientCheck = false;
                    do {
                        System.out.println("Enter the ID that comes before the patient: ");
                        patientID = input.nextLine();
                        for(Entity user : users) {
                            //make sure chosen ID is a patient
                            if(user.getId().equals(patientID) && (patientID.charAt(0) == 'p')) {
                                patientCheck = true;
                                patient = user;
                                break;
                            }
                        }    
                        if(!patientCheck) {
                            System.out.println("Invalid ID. Try again");
                        }
                    } while(!patientCheck);

                    String recordDescription;
                    //doctor writes notes, input those notes
                    System.out.println("Enter doctor's notes: ");
                    recordDescription = input.nextLine();

                    //print medicines in stock
                    for(Medicine medicine : medicines) {
                        System.out.println(medicine);
                        System.out.println();
                    }

                    ArrayList<Medicine> prescribedMedicines = new ArrayList<>();

                    System.out.println("Choose medicine(can add more later): ");

                    String moreMedicine;
                    do {
                        boolean medicineCheck = false;
                        do {
                            System.out.println("Enter the ID that comes before the medicine: ");
                            medicineID = input.nextLine();
                            for (Medicine medicine: medicines) {
                                //ensure it's a valid ID
                                if(medicine.getID().equals(medicineID)) {
                                    medicineCheck = true;
                                    prescribedMedicines.add(medicine);
                                    break;
                                }
                            }
                            if(!medicineCheck) {
                                System.out.println("Invalid ID. Try again");
                            }
                        } while(!medicineCheck);
                        // allow option to add more medicine to the prescription
                        System.out.println("Do you want to add more medicine? Enter 1 for yes or anything else for no.");
                        moreMedicine = input.nextLine();
                    } while(moreMedicine.equals("1"));

                    //make the record and add it to the records in the system
                    MedicalRecord record = new MedicalRecord((Doctor) doctor, (Nurse) nurse, (Patient) patient, recordDescription, prescribedMedicines);
                    records.add(record);
                    //so the patient can view his history in his interface(this program doesn't go that far)
                    ((Patient) patient).addRecord(record);
                    break;

                    case "5":
                        System.exit(0);
                }

                //give option to go back to main menu or terminate
                System.out.println("Enter 1 to go back to main menu and anything else to terminate.");
                String exitInput;
                exitInput = input.nextLine();
                if(exitInput.equals("1")) {
                    repeat = true;
                } else {
                    repeat = false;
                }
        } while(repeat);
        input.close();
    }

    //load the initial data to make sure system is not blank on startup
    private static void loadInitialData() {
        users.add(new Doctor("Jonathan Walker", "0123456789", "DXYZ123"));
        users.add(new Doctor("Noor Hisham", "013456789", "DXYZ124"));
        users.add(new Doctor("Ben Carson", "013456789", "DXYZ125"));
        users.add(new Doctor("Edward Jenner", "013456789", "DXYZ126"));

        users.add(new Nurse("Jane Doe", "013456789", "NXY1234"));
        users.add(new Nurse("Farah Doe", "013456789", "NXY1235"));
        users.add(new Nurse("John Doe", "013456789", "NXY1236"));
        users.add(new Nurse("Sarah Doe", "013456789", "NXY1237"));

        users.add(new Patient("Yolanda Lyon", "013456789"));
        users.add(new Patient("Jerry Devine", "013456789"));
        users.add(new Patient("Asher Stephenson", "013456789"));
        users.add(new Patient("Lilian Rowley", "013456789"));

        medicines.add(new Medicine("Paracetamol", 25));
        medicines.add(new Medicine("Cetrizine", 20));

        ArrayList<Medicine> tempPrescription = new ArrayList<>();
        tempPrescription.add(medicines.get(0));
        tempPrescription.add(medicines.get(1));

        records.add(new MedicalRecord((Doctor)users.get(0), (Nurse)users.get(4), (Patient)users.get(9), "Description 1", tempPrescription));
        records.add(new MedicalRecord((Doctor)users.get(1), (Nurse)users.get(5), (Patient)users.get(10), "Description 2", tempPrescription));
        records.add(new MedicalRecord((Doctor)users.get(2), (Nurse)users.get(6), (Patient)users.get(11), "Description 3", tempPrescription));
    }
}