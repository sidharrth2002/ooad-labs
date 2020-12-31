/**
 *
 * @author Sidharrth
 * @version (10/12/2020)
 */

public class Employee extends Person {
    int employeeID;

    public Employee() {}

    public Employee(String nm, String gen, int employeeID) {
        super(nm, gen);
        this.employeeID = employeeID;
    }

    public Employee(String nm, String gen) {
        super(nm, gen);
        this.employeeID = 0;
    }

    @Override
    public String toString() {
        return "Employee ID is: " + employeeID + "\n" + "Employee Name is: " + getName() + "\n" + "Employee Gender Is: " + getGender();
    }
}

