package gameActivity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {
	Computer comp;
@BeforeEach
public void setUp() {
	comp=new Computer();
	resetScore();
	comp.generateChoice();
	
}

// Reset static score before each test
private void resetScore() {
    try {
        java.lang.reflect.Field field = Player.class.getDeclaredField("score");
        field.setAccessible(true);
        field.set(null, 0);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

@Test
public void testGenerateChoiceMultipleTimes() {
    for (int i = 0; i < 100; i++) {
        comp.generateChoice();
        String choice = comp.getChoice();

        assertTrue(
            choice.equals("Rock") ||
            choice.equals("Paper") ||
            choice.equals("Scissors"),
            "Invalid choice: " + choice
        );
    }
}
@Test
void testInitialScoreIsZero() {
    assertEquals(0, comp.getScore());
}
@Test
void testIncreaseScore() {
    comp.increaseScore();
    assertEquals(1, comp.getScore());

    comp.increaseScore();
    assertEquals(2, comp.getScore());
}

}
