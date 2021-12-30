package persistence;

import model.Sound;

import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    protected void checkSound(String file, String title, int numPlays, Sound sound) {
        assertEquals(file, sound.getTitle());
        assertEquals(title, sound.getTitle());
        assertEquals(numPlays, sound.getNumPlays());

    }
}
