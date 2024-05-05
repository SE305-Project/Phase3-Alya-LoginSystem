import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

// Test class for the LoginSystem class
public class LoginSystemTest {
    // Test method for signUpUser() in LoginSystem class
    @Test
    public void testSignUpUser() {
        // Arrange
        String input = "test@example.com\npassword123\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        LoginSystem.signUpUser();

        // Assert
        assertTrue(outputStream.toString().contains("Account created successfully!"));
    }

    // Test method for loginUser() in LoginSystem class
    @Test
    public void testLoginUser() {
        // Arrange
        String email = "test@example.com";
        String password = "password123";
        User user = new User(email, password);

        // Using reflection to access the private users field
        String input = "test@example.com\npassword123\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        LoginSystem.loginUser();

        // Assert
        assertTrue(outputStream.toString().contains("Login successful!"));
    }
}
