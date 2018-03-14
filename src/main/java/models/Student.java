package models;

public class Student {

    private int id;
    private String name;
    private int age;
    private int enrolmentNumber;

    public Student() {
    }

    public Student(String name, int age, int enrolmentNumber) {
        this.name = name;
        this.age = age;
        this.enrolmentNumber = enrolmentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getEnrolmentNumber() {
        return enrolmentNumber;
    }

    public void setEnrolmentNumber(int enrolmentNumber) {
        this.enrolmentNumber = enrolmentNumber;
    }
}
