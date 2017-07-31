package pl.pollub.task;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.mockito.Mockito;

public class TaskListTest {
    TaskList taskList = new TaskList();
    @Test
    public void whenICreateNewTaskThenThisTaskIsOnTheTaskList() throws Exception {
        Task created=new Task();
        taskList.add(created);
        taskList.add(new Task());

        assertEquals(2, taskList.getAllTasks().size());
        assertTrue(taskList.getAllTasks().contains(created));
    }
    @Test
    public void theCounterIncrementsWithEachTask() throws Exception {
        for(int i=1 ; i<10 ; i++){
            taskList.add(new Task());
            assertEquals(i,taskList.getAllTasks().get(i-1).getId());
        }
    }
    @Test
    public void ICanRemoveExistingTask() throws Exception{
        Task created = new Task();
        taskList.add(created);
        taskList.remove(created);
        assertFalse(taskList.getAllTasks().contains(created));
        assertEquals(0,taskList.getAllTasks().size());
        created = new Task();
        taskList.add(created);
        taskList.remove(0);
        assertFalse(taskList.getAllTasks().contains(created));
        assertEquals(0,taskList.getAllTasks().size());
    }
    @Test
    public void ICanAddAndRemoveEmployeesFromATask() throws Exception{
        Task task = new Task();
        Employee Marek = new Employee();
        Employee Kuba = new Employee();
        task.addWorker(Marek);
        task.addWorker(Kuba);
        assertEquals(0,Kuba.getSolvedTasks().get());
        assertTrue(task.getWorkers().contains(Marek));
        assertTrue(task.getWorkers().get(1)==Kuba);
        task.removeWorker(Marek);
        assertEquals(1,task.getWorkers().size());
        task.removeWorker(Kuba);
        assertEquals(0,task.getWorkers().size());
    }
    @Test
    public void ICanMoveEmployeesBetweenTasks() throws Exception{
        Task task1 = new Task();
        Task task2 = new Task();
        Employee Kuba = new Employee();
        task1.addWorker(Kuba);
        task1.moveWorker(Kuba,task2);
        assertFalse(task1.getWorkers().contains(Kuba));
        assertTrue(task2.getWorkers().contains(Kuba));
    }
    @Test
    public void ICanFinishATask() throws Exception{
        Task task = new Task();
        Employee Kuba = new Employee();
        System.out.println(Kuba);
        task.addWorker(Kuba);
        task.finish();
        assertTrue(task.isDone());
        assertEquals(1,Kuba.getSolvedTasks().get());
    }
}