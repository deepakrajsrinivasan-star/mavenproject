import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

public class AppTest {
    
    @Test
    public void testStudentCreation() {
        Student student = new Student("John Doe", "STU001");
        assertEquals("John Doe", student.name);
        assertEquals("STU001", student.studentID);
        assertEquals(0, student.registeredSubjects.size());
    }
    
    @Test
    public void testRegisterSubject() {
        Student student = new Student("Jane Smith", "STU002");
        student.registerSubject("Mathematics", 4);
        student.registerSubject("Physics", 3);
        assertEquals(2, student.registeredSubjects.size());
    }
    
    @Test
    public void testCalculateTotalCredits() {
        Student student = new Student("Bob Wilson", "STU003");
        student.registerSubject("Java", 4);
        student.registerSubject("Database", 3);
        student.registerSubject("Web Dev", 3);
        assertEquals(10, student.calculateTotalCredits());
    }
    
    @Test
    public void testEligibilityWithEnoughCredits() {
        Student student = new Student("Alice Brown", "STU004");
        student.registerSubject("Subject A", 8);
        student.registerSubject("Subject B", 7);
        assertTrue(student.isEligible());
    }
    
    @Test
    public void testEligibilityWithInsufficientCredits() {
        Student student = new Student("Charlie Davis", "STU005");
        student.registerSubject("Subject A", 10);
        assertFalse(student.isEligible());
    }
}
