package pl.pollub.task;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Task {
    public Task()
    {}
    public Task(int id, String content, Employee author, Date date, List<Employee> workers) {
        this.id = id;
        this.content = content;
        this.author = author;
        this.deadline = date;
        this.workers=workers;
    }



    private int id;
    private String content;
    private Employee author;
    private Date deadline;
    private List<Employee> workers = new ArrayList<>();
    private boolean done = false;


    public void setId(int id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }

    public Employee getAuthor() {
        return author;
    }

    public Date getDeadline() {
        return deadline;
    }

    public int getId() {return id;
    }
    public void removeWorker(Employee worker){
        workers.remove(worker);
    }
    public void addWorker(Employee employee){
        workers.add(employee);
    }
    public void moveWorker(Employee worker, Task task){
        task.addWorker(worker);
        this.removeWorker(worker);
    }

    public void setDone(boolean done) {
        this.done = done;
    }
    public void finish(){
        for(int i=0 ; i<workers.size() ; i++){
            workers.get(i).getSolvedTasks().incrementAndGet();
        }
        setDone(true);
    }

    public boolean isDone() {
        return done;
    }

    public List<Employee> getWorkers() {
        return workers;
    }
}
