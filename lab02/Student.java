import java.util.ArrayList;

public class Student extends Person {
    ArrayList<Subject> subjects = new ArrayList<>();

    public Student(String nm, String gen) {
        super(nm, gen);
    }

    void addSubject(String code, char grade) {
        Subject newSubject = new Subject(code, grade);
        subjects.add(newSubject);
    }

    boolean remSubject(String code) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getCode().equals(code)) {
                subjects.remove(i);
                return true;
            }
        }
        return false;
    }

    void printTranscript() {
        System.out.println("Student name: " + getName());
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println(subjects.get(i));
        }
    }

    public String toString() {
        return "Student's name is " + getName();
    }
}
