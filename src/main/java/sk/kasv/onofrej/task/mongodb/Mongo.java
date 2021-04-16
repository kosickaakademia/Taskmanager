package sk.kasv.onofrej.task.mongodb;

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

    public void setTaskToDone(int id);

    public List<Task> getAllTasks();

    public List<Task> getAllTasks(boolean done);

    public List<Task> getAllTasksByPriority();

    public List<Task> getAllTasksByName(String name);

    public void DeleteDoneTasks();
}
