import db.DBHelper;
import models.Course;
import models.Lesson;
import models.Student;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("English", "Masters");
        DBHelper.save(course1);
        Course course2 = new Course("Geography", "HNC");
        DBHelper.save(course2);

        Lesson lesson1 = new Lesson("Intro", 101, course2);
        DBHelper.save(lesson1);

        Student student1 = new Student("Peter", 18, 12345, course1);
        DBHelper.save(student1);
        Student student2 = new Student("Louis", 17, 79876, course2);
        DBHelper.save(student2);
        Student student3 = new Student("Chris", 15, 15482, course1);
        DBHelper.save(student3);
        Student student4 = new Student("Meg", 16, 34221, course2);
        DBHelper.save(student4);

        student4.setCourse(course1);
        DBHelper.save(student4);

        DBHelper.delete(student1);

        List<Student> allStudents = DBHelper.getAll(Student.class);
        List<Course> allCourses = DBHelper.getAll(Course.class);
        List<Lesson> allLessons = DBHelper.getAll(Lesson.class);

        DBHelper.addStudentToLesson(student2, lesson1);

    }
}
