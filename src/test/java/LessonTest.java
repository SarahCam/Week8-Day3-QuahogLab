import db.DBHelper;
import models.Course;
import models.Lesson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertEquals;

public class LessonTest {

    Lesson lesson;
    Course course;

    @Before
    public void setUp() throws Exception {
        course = new Course("Engineering", "Bsc");
        lesson = new Lesson("Mechanics", 203, course);
        DBHelper.save(course);
        DBHelper.save(lesson);
    }

    @After
    public void tearDown() throws Exception {
        DBHelper.delete(lesson);
        DBHelper.delete(course);
    }

    @Test
    public void canSave() {
        List<Lesson> results = DBHelper.getAll(Lesson.class);
        assertEquals(1, results.size());
    }

    @Test
    public void canUpdate(){
        Lesson found = DBHelper.find(Lesson.class, lesson.getId());
        found.setClassroomNumber(202);
        DBHelper.save(found);
        found = DBHelper.find(Lesson.class, lesson.getId());
        assertEquals(202 , found.getClassroomNumber());
    }

    @Test
    public void canDelete() {
        Lesson found = DBHelper.find(Lesson.class, lesson.getId());
        DBHelper.delete(found);
        List<Lesson> results = DBHelper.getAll(Lesson.class);
        assertEquals(0, results.size());
    }
}
