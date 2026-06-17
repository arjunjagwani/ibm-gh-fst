package gameActivity;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;

public class PlayGameTest {

    @Test
    void testUserChoosesRock() {

        String input =
                "\n" +   // Press Enter to start
                "1\n" +  // Rock
                "2\n";   // Exit game

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> PlayGame.main(new String[]{}));
    }

    @Test
    void testUserChoosesPaper() {

        String input =
                "\n" +
                "2\n" +  // Paper
                "2\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> PlayGame.main(new String[]{}));
    }

    @Test
    void testUserChoosesScissors() {

        String input =
                "\n" +
                "3\n" +  // Scissors
                "2\n";

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> PlayGame.main(new String[]{}));
    }
    @Test
    void testInvalidTextInput() throws InterruptedException, IOException {

        String input =
                "\n" +
                "abc\n" +   // invalid input
                "1\n" +     // valid input after recovery
                "2\n";      // exit

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(output));

        PlayGame.main(new String[]{});

        String console = output.toString();

        assertTrue(console.contains(
                "Invalid input! Please enter only numbers (1, 2, or 3)."
        ));
    }

}