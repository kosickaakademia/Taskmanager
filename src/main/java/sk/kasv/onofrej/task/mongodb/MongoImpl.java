package sk.kasv.onofrej.task.mongodb;


import sk.kasv.onofrej.task.collection.Task;

import java.util.List;

public class MongoImpl implements Mongo {
    // dbname: taksmanager
    // collection: tasks
    @Override
    public void insertTask(Task task) {

    }

    @Override
    public void setTaskToDone(int id) {

    }

    @Override
    public List<Task> getAllTasks() {
        return null;
    }

    @Override
    public List<Task> getAllTasks(boolean done) {
        return null;
    }

    @Override
    public List<Task> getAllTasksByPriority(int priority) {
        return null;
    }

    @Override
    public List<Task> getAllTasksByName(String name) {
        return null;
    }

    @Override
    public void DeleteDoneTasks() {

    }
}
