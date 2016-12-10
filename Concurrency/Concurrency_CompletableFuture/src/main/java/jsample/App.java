package jsample;

import jsample.concurrency.Task;
import jsample.concurrency.Task.TaskStatus;
import jsample.concurrency.Task.TaskType;
import jsample.concurrency.TaskExecutor;

public class App {
	public static void main(String[] args) {

		Task task1 = new Task("ID_1", TaskStatus.NOT_STARTED, TaskType.NORMAL);
		Task task2 = new Task("ID_2", TaskStatus.NOT_STARTED, TaskType.ABNORMAL);
		Task task3 = new Task("ID_3", TaskStatus.NOT_STARTED, TaskType.NORMAL);

		System.out.println("Executing all tasks asynchronously.");
		TaskExecutor.execute(task1);
		TaskExecutor.execute(task2);
		TaskExecutor.execute(task3);

		System.out.println("Tasks are getting executed asynchronously");
	}
}
