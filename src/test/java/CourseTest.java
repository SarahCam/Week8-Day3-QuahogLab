import db.DBHelper;
import models.Course;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CourseTest {

    Course course;

    @Before
    public void setUp() {
        course = new Course("Computing Science", "Masters");
        DBHelper.save(course);
    }

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(course);
    }

    @Test
    public void canSave() {
        List<Course> results = DBHelper.getAll(Course.class);
        assertEquals(1, results.size());
    }

    @Test
    public void canUpdate() {
        Course found = DBHelper.find(Course.class, course.getId());
        found.setLevel("PHD");
        DBHelper.save(found);
        found = DBHelper.find(Course.class, course.getId());
        assertEquals("PHD", found.getLevel());
    }

    @Test
    public void canDelete() {
        Course found = DBHelper.find(Course.class, course.getId());
        DBHelper.delete(found);
        List<Course> results = DBHelper.getAll(Course.class);
        assertEquals(0, results.size());
    }
}
