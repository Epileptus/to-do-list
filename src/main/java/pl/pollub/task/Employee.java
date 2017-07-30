package pl.pollub.task;

import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    public Employee() {
        id=numberOfEmployees.incrementAndGet();
    }
    private static AtomicInteger numberOfEmployees = new AtomicInteger();
    private final  int id;
    private final AtomicInteger solvedTasks = new AtomicInteger();

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "dzień dobry\n" +
                "mam na imię Patryk i będę państwa obsługiwał\n" +
                "bardzo mi miło, to dla mnie zaszczyt\n" +
                "nazywam się Patryk, mam swój numer identyfikacyjny\n" +
                "bardzo długi numer ale znam go na pamięć\n" +
                id +" mam na imię Patryk\n" +
                "czasami wydaje mi się, że żyję";
    }

    public AtomicInteger getSolvedTasks() {
        return solvedTasks;
    }
}
