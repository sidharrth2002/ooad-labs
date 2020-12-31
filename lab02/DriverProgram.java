import java.util.Scanner;

public class DriverProgram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String option;
        Student student = new Student("Sidharrth", "male");
        System.out.println("Choose an option to continue: ");
        System.out.println("[1] Enter new subject");
        System.out.println("[2] Remove subject");
        System.out.println("[3] Show results"); 
        System.out.println("[4] Quit");
        option = input.nextLine();
        while (!option.equals("4")) {
            switch(option) {
                case "1":
                    System.out.println("Enter subject code: ");
                    String code = input.nextLine();
                    System.out.println("Enter result obtained: ");
                    String result = input.nextLine();
                    student.addSubject(code, result.charAt(0));
                    break;
                case "2":
                    System.out.println("Enter subject code to remove: ");
                    String subjectCode = input.nextLine();
                    if(!student.remSubject(subjectCode)) {
                        System.out.println("Subject Does Not Exist.");
                    }
                    break;
                case "3":
                    System.out.println();
                    student.printTranscript();
                    System.out.println();
                    break;
                default: 
                    
            }
            System.out.println("Choose an option to continue: ");
            System.out.println("[1] Enter new subject");
            System.out.println("[2] Remove subject");
            System.out.println("[3] Show results"); 
            System.out.println("[4] Quit");            
            option = input.nextLine();
        }
    }
}
