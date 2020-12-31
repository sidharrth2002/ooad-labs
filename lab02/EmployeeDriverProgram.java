public class EmployeeDriverProgram {
    public static void main(String[] args) {
        //first constructor
        Employee e1 = new Employee("Sid", "Male", 1);
        //second constructor
        Employee e2 = new Employee("Jonathan", "Male");

        //calls e1 toString
        System.out.println("Employee 1's Information: ");
        System.out.println(e1);

        System.out.println();

        //calls e1 toString
        System.out.println("Employee 2's Information: ");
        System.out.println(e2);
    }
}
