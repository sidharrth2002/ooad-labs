public class Entity {
    protected String name;
    protected String id;
    protected String phone;

    public Entity() {}

    public Entity(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //describes a user in general
    //with polymorphism(this method probably won't be called)
    public void describe() {
        System.out.println("==========================");
        System.out.println("ID: " + id);
        System.out.println("User's name is: " + name);
        System.out.println("User's phone is: " + phone);
        System.out.println("==========================");
    }
}