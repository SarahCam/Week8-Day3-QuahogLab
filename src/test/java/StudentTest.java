import db.DBHelper;
import models.Course;
import models.Student;
import models.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class StudentTest {

    Student student;
    Course course;

    @Before
    public void setUp() throws Exception {
        GregorianCalendar startDate = new GregorianCalendar(2018, 1, 12);
        GregorianCalendar endDate = new GregorianCalendar(2022, 1, 12);
        course = new Course("Engineering", "Bsc", startDate, endDate);
        student = new Student("Stewie", 2, 23475, course);
        DBHelper.save(course);
        DBHelper.save(student);
    }

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(student);
        DBHelper.delete(course);
    }

    @Test
    public void canSave() {
        List<Student> results = DBHelper.getAll(Student.class);
        assertEquals(1, results.size());
    }

    @Test
    public void canUpdate(){
        Student found = DBHelper.find(Student.class, student.getId());
        found.setAge(3);
        DBHelper.save(found);
        found = DBHelper.find(Student.class, student.getId());
        assertEquals(3 , found.getAge());
    }

    @Test
    public void canDelete() {
        Student found = DBHelper.find(Student.class, student.getId());
        DBHelper.delete(found);
        List<Student> results = DBHelper.getAll(Student.class);
        assertEquals(0, results.size());
    }
}
