package beans;

public class User {
    private int id;
    private int age;
    private String sex;
    private String firstName;
    private String lastName;
    private String phone;
    private String regdate;

    public User(){}

    public User(int age, String firstName, String lastName, String sex, String phone){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    @Override
    public String toString(){
        return id + "." + firstName + " " + lastName + "\nВозраст: " + age + "\nПол: " + sex + "\nТелефон: " + phone + "\nДата регистрации: " + regdate + "\n";
    }
}
