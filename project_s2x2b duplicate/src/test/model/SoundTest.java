package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SoundTest {
    private Sound s;

    @BeforeEach
    void setup() {
        s = new Sound("./data/Turbo.wav");
    }

    @Test
    void getTitleTest() {
        String title = s.getTitle();
        assertEquals("./data/Turbo.wav", title);
    }

    @Test
    void testConstructor() {
        assertEquals("./data/Turbo.wav", s.getTitle());
        assertEquals(0, s.getNumPlays());

    }

    @Test
    void testGetNumPlays1() {
        s.playMusic();
        assertEquals(1, s.getNumPlays());
    }

    @Test
    void testGetNumPlays() {
        for (int i = 0; i < 3; i++) {
            s.playMusic();

        }
        assertEquals(3, s.getNumPlays());
    }

    @Test
    void testPlayMusicNonExistent() {
        Sound fufu = new Sound("yo mamma");
        fufu.playMusic();
        assertEquals(0, fufu.getNumPlays());
        assertEquals(0, fufu.playMusic());

    }

    @Test
    void testPlayMusic() {
        Sound works = new Sound("./data/Yo_Pierre.wav");
        assertEquals(0, works.getNumPlays());
        works.playMusic();
        assertEquals(1, works.getNumPlays());
        assertEquals(1, works.playMusic());
        assertEquals(2, works.getNumPlays());


    }


    @Test
    void testGetFile() {
        File test = s.getFile();
        assertTrue(test.exists());

    }

}