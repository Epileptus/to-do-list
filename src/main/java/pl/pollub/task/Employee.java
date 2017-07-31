package pl.pollub.task;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    public Employee(){
        id=numberOfEmployees.incrementAndGet();
        this.name="Pracownik nr "+id;
    }
    public Employee(String name) {
        id=numberOfEmployees.incrementAndGet();
        this.name=name;
    }
    private static AtomicInteger numberOfEmployees = new AtomicInteger();
    private final  int id;
    private final AtomicInteger solvedTasks = new AtomicInteger();
    private final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "#"+id+": "+name;
    }

    public AtomicInteger getSolvedTasks() {
        return solvedTasks;
    }
}
