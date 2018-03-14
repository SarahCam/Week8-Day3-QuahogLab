package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instructors")
public class Instructor {

    private int id;
    private String name;
    private Set<Course> courses;

    public Instructor() {
    }

    public Instructor(String name) {
        this.name = name;
        this.courses = new HashSet<Course>();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "instructors", fetch = FetchType.EAGER)
    public Set<Course> getCourse() {
        return courses;
    }

    public void setCourse(Set<Course> course) {
        this.courses = course;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
}
