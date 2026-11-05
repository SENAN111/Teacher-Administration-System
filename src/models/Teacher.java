package models;

public class Teacher {
    private  static Long count = 0L;
    private final Long id;
    private String name;
    private String surName;
    private String fin;
    private int age;
    private String email;
    private String number;
    private double salary;


    public Teacher(String name, String surName, String fin, int age, String email, String number, double salary) {
        setName(name);
        setSurName(surName);
        setFin(fin);
        setAge(age);
        setEmail(email);
        setNumber(number);
        setSalary(salary);
        this.id=++count;

    }

    public static long getCount() {
        return count;
    }


    public Long getId() {
        return id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "models.Teacher:{" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", fin='" + fin + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", salary=" + salary +
                '}';
    }
}
