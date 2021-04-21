public class Nurse extends Entity {
    private static int count = 0;
    private String nursingLicense;

    public Nurse() {
        super("Unknown", "Unknown");
        this.id = "n" + ++count;
        this.nursingLicense = "Unknown";
    }
    public Nurse(String name, String phone, String license) {
        super(name, phone);
        this.id = "n" + ++count;
        this.nursingLicense = license;
    }

    public String getLicense() {
        return nursingLicense;
    }

    public void setLicense(String license) {
        this.nursingLicense = license;
    }

    //describes the nurse
    public void describe() {
        System.out.println("==========================");
        System.out.println("Nurse ID: " + getId());
        System.out.println("Nurse's name is: " + getName());
        System.out.println("Nurse's phone is: " + getPhone());
        System.out.println("Nurse's license from KKM " + getLicense()); 
        System.out.println("==========================");
    }
}
