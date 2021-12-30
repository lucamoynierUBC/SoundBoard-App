package persistence;

import model.Sound;
import model.SoundList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public SoundList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkRoom(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }
        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private SoundList parseWorkRoom(JSONObject jsonObject) {
        SoundList sl = new SoundList();
        addSoundList(sl, jsonObject);
        return sl;
    }

    // MODIFIES: Sound List
    // EFFECTS: parses Sounds from JSON object and adds them to SoundList
    private void addSoundList(SoundList sl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("SoundList");
        for (Object json : jsonArray) {
            JSONObject nextSound = (JSONObject) json;
            addSound(sl, nextSound);
        }
    }

    // MODIFIES: Sound List
    // EFFECTS: parses sound from JSON object and adds it to soundlist
    private void addSound(SoundList sl, JSONObject jsonObject) {
        String title = jsonObject.getString("title");
        Sound sound = new Sound(title);
        sl.addSound(sound);

    }


}

