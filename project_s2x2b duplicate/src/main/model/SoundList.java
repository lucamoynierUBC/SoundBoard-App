package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// Represents an arbitrary list of Sounds
public class SoundList implements Writable {
    private List<Sound> list;

    // EFFECTS: sets list to a new ArrayList
    public SoundList() {
        list = new ArrayList<Sound>();
    }

    // MODIFIES: This
    // EFFECTS: Adds a Sound to the list
    public void addSound(Sound s) {
        list.add(s);
        EventLog.getInstance().logEvent(new Event("     Added:" + s.getTitle() + " to the compilation"));

    }

    //EFFECTS: returns list
    public List<Sound> getList() {
        return list;
    }

    //EFFECTS: returns true if list is empty
    public boolean soundsEmpty() {
        return list.isEmpty();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("SoundList", soundListToJson());
        return json;
    }

    private JSONArray soundListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Sound s : list) {
            jsonArray.put(s.toJson());
        }
        return jsonArray;
    }


}
