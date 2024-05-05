import org.junit.Test;
import static org.junit.Assert.*;

// Test class for the User class
public class UserTest {
    // Test method for getEmail() in User class
    @Test
    public void testGetEmail() {
        // Arrange
        String email = "test@example.com";
        String password = "password123";
        User user = new User(email, password);

        // Act
        String userEmail = user.getEmail();

        // Assert
        assertEquals(email, userEmail);
    }

    // Test method for getPassword() in User class
    @Test
    public void testGetPassword() {
        // Arrange
        String email = "test@example.com";
        String password = "password123";
        User user = new User(email, password);

        // Act
        String userPassword = user.getPassword();

        // Assert
        assertEquals(password, userPassword);
    }
}
