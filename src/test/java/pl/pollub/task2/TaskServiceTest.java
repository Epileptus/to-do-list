//package pl.pollub.task2;
//
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.List;
//
//import org.junit.*;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.*;
//import org.mockito.runners.MockitoJUnitRunner;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TaskServiceTest {
//
//    @Mock
//    UserService userService;
//
//    @Mock
//    EmailNotifier emailNotifier;
//
//    @Mock
//    TaskSummariser taskSummariser;
//
//    @InjectMocks
//    TaskService taskService;
//
//    @Captor
//    private ArgumentCaptor<List<String>> emailsCaptor;
//
//    @Test
//    public void sendEmailToOwnerAndContributors() throws Exception{
//        Task task = taskService.createTaskForUser(1, 2, 3);
//
//        Mockito.when(userService.getUserById(Mockito.anyInt())).then(invocationOnMock -> {
//            Integer id = invocationOnMock.getArgumentAt(0, int.class);
//            return new User(id, "user" + id + "@wp.pl");
//        });
//
//        taskService.completeTask(task.getId());
//        //check if email sent to users: [1,2,3]
//
//        Mockito.verify(emailNotifier).notify(Mockito.eq(task.getId()), emailsCaptor.capture());
//
//        HashSet<String> notified = new HashSet<>(emailsCaptor.getValue());
//        HashSet<String> expected = new HashSet<>(Arrays.asList("user1@wp.pl", "user2@wp.pl", "user3@wp.pl"));
//
//        assertEquals(expected, notified);
//    }
//
////    @Test
////    public void taskSummariserReceivesFinishedTasks() throws Exception{
////        TaskSummariser tasksummariser = TaskSummariser.getInstance();
////        Mockito.when(userService.getUserById(Mockito.anyInt())).then(invocationOnMock -> {
////            Integer id = invocationOnMock.getArgumentAt(0, int.class);
////            return new User(id, "user" + id + "@wp.pl");
////        });
////
////        Task task = taskService.createTaskForUser(1,2,3);
////
////        assertEquals(0,tasksummariser.getFinishedTasks().size());
////        assertEquals(0,tasksummariser.getDates().size());
////        assertTrue(!tasksummariser.getFinishedTasks().contains(task));
////
////        taskService.completeTask(task.getId());
////
////        assertEquals(1,tasksummariser.getFinishedTasks().size());
////        assertEquals(1,tasksummariser.getDates().size());
////        assertTrue(tasksummariser.getFinishedTasks().contains(task));
////    }
//
//    @Test
//    public void taskSummariserReceivesFinishedTasks2() throws Exception{
//        Mockito.when(userService.getUserById(Mockito.anyInt())).then(invocationOnMock -> {
//            Integer id = invocationOnMock.getArgumentAt(0, int.class);
//            return new User(id, "user" + id + "@wp.pl");
//        });
//
//        Task task = taskService.createTaskForUser(1,2,3);
//
//        taskService.completeTask(task.getId());
//
////        Mockito.verify(taskSummariser).addFinishedTask(task);
//
//
//
//    }
//
//}