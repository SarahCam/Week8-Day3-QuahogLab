package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    private int id;
    private String title;
    private String level;
    private Set<Student> students;
    private Set<Lesson> lessons;
    private Set<Instructor> instructors;

    public Course() {
    }

    public Course(String title, String level) {
        this.title = title;
        this.level = level;
        this.instructors = new HashSet<Instructor>();
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

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @OneToMany(mappedBy = "course")
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy = "course")
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    @ManyToMany
    @JoinTable(name = "course_instructor",
            joinColumns = {@JoinColumn(name = "course_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "instructor_id", nullable = false, updatable = false)}
    )
    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public void addInstructor(Instructor instructor){
        this.instructors.add(instructor);
    }
}
