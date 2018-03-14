import db.DBHelper;
import models.Course;
import models.Student;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("English", "Masters");
        DBHelper.save(course1);

        Student student1 = new Student("Peter", 18, 12345, course1);
        DBHelper.save(student1);
    }
}
