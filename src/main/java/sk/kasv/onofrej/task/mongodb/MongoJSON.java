package sk.kasv.onofrej.task.mongodb;

import org.json.simple.JSONObject;
import sk.kasv.onofrej.task.collection.Task;

import java.util.List;

public interface MongoJSON {
    public void insertTaskJSON(JSONObject task);

    public JSONObject getAllTasksJSON();
}
