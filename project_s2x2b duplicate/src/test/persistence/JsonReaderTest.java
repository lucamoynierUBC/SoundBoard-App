package persistence;

import model.Sound;
import model.SoundList;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            SoundList sl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptySoundList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyListSound.json");
        try {
            SoundList sl = reader.read();
            assertTrue(sl.soundsEmpty());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralSoundList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralSoundList.json");
        try {
            SoundList sl = reader.read();
            List<Sound>  soundList = sl.getList();
            assertEquals(2, soundList.size());
            checkSound("test", "test", 0, soundList.get(0));
            checkSound("test1", "test1", 0, soundList.get(1));
        } catch (IOException e) {
            fail("couldn't read from file");
        }
    }

}
