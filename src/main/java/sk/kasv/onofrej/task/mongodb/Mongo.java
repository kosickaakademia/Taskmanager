package sk.kasv.onofrej.task.mongodb;

import org.bson.types.ObjectId;
import sk.kasv.onofrej.task.collection.Task;

import java.util.List;

public interface Mongo {
    /**
     * description
     * @param task
     * @author Roland
     * @version 1.0
     */
    public void insertTask(Task task);

    public void setTaskToDone(ObjectId id);

    public List<Task> getAllTasks();

    public List<Task> getAllTasks(boolean done);

    public List<Task> getAllTasksByPriority(int priority);

    public List<Task> getAllTasksByName(String name);

    public void DeleteDoneTasks();
}
