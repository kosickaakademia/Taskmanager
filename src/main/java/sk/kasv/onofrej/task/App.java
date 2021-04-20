package sk.kasv.onofrej.task;

import sk.kasv.onofrej.task.collection.Task;
import sk.kasv.onofrej.task.mongodb.MongoImpl;

import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //testAddNewTask();
        //printAllTasks();
        printAllTasksByPriority();
    }

    private static void printAllTasksByPriority() {
        MongoImpl mongo = new MongoImpl();
        List<Task> list = mongo.getAllTasksByPriority(4);
        for(Task t: list){
            System.out.println(t.toString());
        }
    }

    private static void printAllTasks() {
        MongoImpl mongo = new MongoImpl();
        List<Task> list = mongo.getAllTasks(false);
        for(Task t: list){
            System.out.println(t.toString());
        }
    }

    public static void testAddNewTask(){
        Task task;
        task = new Task("Presadit muskaty",2,false, new Date());
        MongoImpl mongo = new MongoImpl();
        mongo.insertTask(task);
    }
}
