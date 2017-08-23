package pl.pollub.task2;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;

public class TaskService {

    private final UserService userService;

    private final EmailNotifier emailNotifier;

    private final Map<Integer, Task> tasks = new HashMap<>();

    private final AtomicInteger counter = new AtomicInteger();

    private final TaskSummariser taskSummariser;

    public TaskService(UserService userService, EmailNotifier emailNotifier, TaskSummariser taskSummariser) {
        this.userService = userService;
        this.emailNotifier = emailNotifier;
        this.taskSummariser = taskSummariser;
    }

    public Task createTaskForUser(int userId, Integer... contributors){
        Task task = new Task(counter.incrementAndGet(), userId,
                             contributors != null ? Arrays.asList(contributors) : Collections.emptyList());
        tasks.put(task.getId(), task);
        return task;
    }

    public void completeTask(int taskId){
        Task task = tasks.get(taskId);
        taskSummariser.addFinishedTask(task);
    }

}
