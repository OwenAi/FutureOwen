package taskScheduler;

import java.time.LocalDate;

public class Task {
	
	private String title;
	private String description;
	private LocalDate dueDate;
	private boolean completed;
	
	// Constructor
	public Task(String title, String description, LocalDate dueDate) {
		this.setTitle(title);
		this.setDescription(description);
		this.setDueDate(dueDate);
		this.setCompleted(false); // by default, tasks are not completed
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	@Override
	public String toString() {
		return title + " (" + (completed ? "completed" : "not completed") + ")" +
				"\nDescription: " + description +
				"\nDue date: " + dueDate;
	}
}
