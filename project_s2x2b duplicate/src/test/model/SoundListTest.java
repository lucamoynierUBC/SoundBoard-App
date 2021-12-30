package model;

import model.Sound;
import model.SoundList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SoundListTest {
    private SoundList sl;

    @BeforeEach
    void setup(){
        sl = new SoundList();
    }
    @Test
    void testAddSound(){
        Sound s = new Sound("test");
        sl.addSound(s);
        assertEquals(1, sl.getList().size());
        assertFalse(sl.getList().isEmpty());
    }
    @Test
    void testGetSoundListEmpty(){
        assertTrue(sl.getList().isEmpty());
    }
    @Test
    void testGetSoundList(){
        Sound s = new Sound("test");
        sl.addSound(s);
        assertEquals(1, sl.getList().size());
    }
    @Test
    void testSoundsEmpty(){
        assertTrue(sl.soundsEmpty());
        Sound s = new Sound("title");
        sl.addSound(s);
        assertFalse(sl.soundsEmpty());
    }


}
