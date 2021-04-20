package sk.kasv.onofrej.task.mongodb;



import com.mongodb.client.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.json.simple.JSONObject;
import sk.kasv.onofrej.task.collection.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class MongoImpl implements Mongo, MongoJSON {

    // dbname: taksmanager
    // collection: tasks
    @Override
    public void insertTask(Task task) {
        if(task==null){
            return;
        }
        Document newTaskDoc = new Document("name",task.getName()).
                append("priority",task.getPriority()).
                append("done",task.isDone()).
                append("date",task.getDate());
        if(task.getPrice()>=0.0) // overenie ci task ma zadanu price
            newTaskDoc.append("price",task.getPrice());
        if(task.getId()!=null)  // ak uz existuje id, tak ho pouzijeme
            newTaskDoc.append("_id",task.getId());

        MongoCollection<Document> col = getDocumentMongoCollection();
        col.insertOne(newTaskDoc);

    }

    private MongoCollection<Document> getDocumentMongoCollection() {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase db = mongoClient.getDatabase("taskmanager");
        MongoCollection<Document> col = db.getCollection("tasks");
        return col;
    }

    @Override
    public void setTaskToDone(ObjectId id) {

    }

    @Override
    public List<Task> getAllTasks() {
        try{
            MongoCollection<Document> col = getDocumentMongoCollection();
            FindIterable<Document> cursor = col.find();
            List<Task> list = new ArrayList<>();
            for (Document document : cursor) {
                //System.out.println(document.toString());
                String name = document.getString("name");
                int priority = document.getInteger("priority");
                boolean done = document.getBoolean("done");
                Date date = document.getDate("date");
                ObjectId id = document.getObjectId("_id");
                Task task;
                if( document.containsKey("price") ) {
                    double price = document.getDouble("price");
                    task= new Task(name,priority,done, date, price);
                }else{
                    task = new Task(name,priority,done, date);
                }
                task.setId(id);
                list.add(task);
            }
            return list;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Task> getAllTasks(boolean value) {

        try{
            MongoCollection<Document> col = getDocumentMongoCollection();
            FindIterable<Document> cursor = col.find(eq("done",value));
            List<Task> list = new ArrayList<>();
            for (Document document : cursor) {
                //System.out.println(document.toString());
                String name = document.getString("name");
                int priority = document.getInteger("priority");
                boolean done = document.getBoolean("done");
                Date date = document.getDate("date");
                ObjectId id = document.getObjectId("_id");
                Task task;
                if( document.containsKey("price") ) {
                    double price = document.getDouble("price");
                    task= new Task(name,priority,done, date, price);
                }else{
                    task = new Task(name,priority,done, date);
                }
                task.setId(id);
                list.add(task);
            }
            return list;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Task> getAllTasksByPriority(int value) {
        try{
            MongoCollection<Document> col = getDocumentMongoCollection();
            FindIterable<Document> cursor = col.find(eq("priority",value));
            List<Task> list = new ArrayList<>();
            for (Document document : cursor) {
                //System.out.println(document.toString());
                String name = document.getString("name");
                int priority = document.getInteger("priority");
                boolean done = document.getBoolean("done");
                Date date = document.getDate("date");
                ObjectId id = document.getObjectId("_id");
                Task task;
                if( document.containsKey("price") ) {
                    double price = document.getDouble("price");
                    task= new Task(name,priority,done, date, price);
                }else{
                    task = new Task(name,priority,done, date);
                }
                task.setId(id);
                list.add(task);
            }
            return list;
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Task> getAllTasksByName(String name) {
        return null;
    }

    @Override
    public void DeleteDoneTasks() {

    }

    @Override
    public void insertTaskJSON(JSONObject task) {

    }

    @Override
    public JSONObject getAllTasksJSON() {
        return null;
    }
}
