package jsample.concurrency;

public class Task {

	private String taskId;

	private TaskStatus status = TaskStatus.NOT_STARTED;

	private TaskType type;

	public Task(String taskId, TaskStatus status, TaskType type) {
		this.taskId = taskId;
		this.status = status;
		this.type = type;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public TaskType getType() {
		return type;
	}

	public void setType(TaskType type) {
		this.type = type;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Task [taskId=").append(taskId).append(", taskStatus=").append(status).append(", taskType=")
				.append(type).append("]");
		return builder.toString();
	}

	public enum TaskStatus {
		COMPLETED, FAILED, INPROGRESS, NOT_STARTED
	}

	public enum TaskType {
		NORMAL, ABNORMAL
	}
}