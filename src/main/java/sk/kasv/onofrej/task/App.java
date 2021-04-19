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
        printAllTasks();
    }

    private static void printAllTasks() {
        MongoImpl mongo = new MongoImpl();
        List<Task> list = mongo.getAllTasks();
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
