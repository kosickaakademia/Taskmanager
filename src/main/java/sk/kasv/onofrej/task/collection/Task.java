package sk.kasv.onofrej.task.collection;

import org.bson.types.ObjectId;

import java.util.Date;

public class Task {
    private ObjectId id;
    private String name;
    private int priority;
    private boolean done;
    private Date date;
    private double price;
}
