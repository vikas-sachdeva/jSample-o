package jsample.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import jsample.concurrency.Task.TaskStatus;
import jsample.concurrency.Task.TaskType;

public class TaskExecutor {

	public static void execute(Task task) {
		System.out.println("[1] " + task + ", thread=" + Thread.currentThread());
		/**
		 * Execute task asynchronously using CompletableFuture.supplyAsync()
		 * method.
		 */
		ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
		CompletableFuture<TaskStatus> completableFuture = CompletableFuture
				.supplyAsync(new Supplier<Task.TaskStatus>() {

					@Override
					public TaskStatus get() {
						task.setStatus(TaskStatus.INPROGRESS);
						System.out.println("[2] " + task + ", thread=" + Thread.currentThread());

						try {
							/**
							 * Perform some long running operation here.
							 */
							Thread.sleep(1000 * 2);
							System.out.println("[3] " + task + ", thread=" + Thread.currentThread());
							if (task.getType().equals(TaskType.ABNORMAL)) {
								throw new RuntimeException();
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
							return Task.TaskStatus.FAILED;
						}
						return Task.TaskStatus.COMPLETED;
					}
				}, singleThreadExecutor);
		/**
		 * whenComplete() method of CompletableFuture is called when the task
		 * execution is completed. It is called in both cases whether the
		 * execution is successful or failed.
		 */
		completableFuture.whenComplete(new BiConsumer<TaskStatus, Throwable>() {

			@Override
			public void accept(TaskStatus taskStatus, Throwable throwable) {
				if (throwable != null) {

					task.setStatus(TaskStatus.FAILED);
					System.out.println("[4] " + task + ", thread=" + Thread.currentThread());
				} else {
					task.setStatus(taskStatus);
					System.out.println("[5] " + task + ", thread=" + Thread.currentThread());
				}
			}
		});
		singleThreadExecutor.shutdown();
	}
}