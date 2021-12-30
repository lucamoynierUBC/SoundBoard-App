package persistence;

import model.Sound;
import model.SoundList;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    @Test
    void testWriterInvalidFile() {
        try {
            SoundList sl = new SoundList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }

    }

    @Test
    void testWriterEmptySoundList() {
        try {
            SoundList sl = new SoundList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySoundList.json");
            writer.open();
            writer.write(sl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySoundList.json");
            sl = reader.read();
            assertEquals(0, sl.getList().size());
            assertTrue(sl.soundsEmpty());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralSoundList() {
        try {
            SoundList sl = new SoundList();
            Sound s = new Sound("test");
            sl.addSound(s);
            Sound b = new Sound("test1");
            sl.addSound(b);
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSoundList.json");

            writer.open();
            writer.write(sl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralSoundList.json");
            sl = reader.read();
            List<Sound> list = sl.getList();
            assertEquals(2, list.size());
            checkSound("test", "test", 0, list.get(0));
            checkSound("test1", "test1", 0, list.get(1));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }

    }
}
