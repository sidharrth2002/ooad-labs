public class Doctor extends Entity {
    private static int count = 0;
    //special medical license from KKM
    private String medicalLicense;

    public Doctor(String name, String phone, String license) {
        //append the title to the name
        super("Dr. " + name, phone);
        this.id = "d" + ++count;
        this.medicalLicense = license;
    }

    @Override
    public void setName(String name) {
        this.name = "Dr." + name;
    }

    public String getLicense() {
        return medicalLicense;
    }

    public void setLicense(String license) {
        this.medicalLicense = license;
    }

    //describes the doctor
    public void describe() {
        System.out.println("==========================");
        System.out.println("Doctor ID: " + getId());
        System.out.println("Doctor's name is: " + getName());
        System.out.println("Doctor's phone is: " + getPhone());
        System.out.println("Doctor's license from KKM " + getLicense()); 
        System.out.println("==========================");
    }
}