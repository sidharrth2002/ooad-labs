
/**
 *
 * @author Sidharrth
 * @version (10/12/2020)
 */

public abstract class Person {

    private String name;
    private String gender;

    public Person() {}

    public Person(String nm, String gen) {
        this.name = nm;
        this.gender = gen;
    }

    public String getName() {return name;}
    
    public String getGender() {return gender;}

    public abstract String toString();

}
