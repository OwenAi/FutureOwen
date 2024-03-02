package taskScheduler;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		TaskManager taskManager = new TaskManager();
		Scanner scnr = new Scanner(System.in);
		boolean list = true;
		
		while(list == true) {
			// Display menu
			System.out.println("Task Management Application");
			System.out.println("1. Add a task");
			System.out.println("2. Edit a task");
			System.out.println("3. View all tasks");
			System.out.println("4. Delete a task");
			System.out.println("5. Mark a task as completed");
			System.out.println("0. Exit");
			
			System.out.println("Enter your choice: ");
			
			// get user input
			int choice = scnr.nextInt(); // consume the nextLine character
			
			switch (choice) {
			case 0:
				System.out.println("Exiting...");
				return;
			case 1:
				// Add a task
				System.out.print("Enter the task title: ");
				String title = scnr.nextLine();
				
				System.out.print("Enter the task description: ");
				String description = scnr.nextLine();
				
				LocalDate dueDate = null;
				while(dueDate == null) {
					System.out.print("Enter the task due date (YYYY-MM-DD); ");
					String dueDateString = scnr.nextLine();
					
					try {
						dueDate = LocalDate.parse(dueDateString);
					} catch (DateTimeParseException e) {
							System.out.println("Invalid date format. Please try again.");
					}
				}
				taskManager.addTask(title,  description,  dueDate);
				System.out.println("Task added successfully.");
				break;
			case 2:
				// Edit a task
				System.out.print("Engter the task number to edit: ");
				int editIndex = scnr.nextInt();
				scnr.nextLine();
				
				if (editIndex <= 0 || editIndex > taskManager.getTasks().size()) {
					System.out.println("Invalid task number. Please try again.");
					break;
				}
				
				System.out.print("Enter the new task title: ");
				String newTitle = scnr.nextLine();
				
				System.out.print("Enter the new task description: ");
				String newDescription = scnr.nextLine();
				LocalDate newDueDate = null;
				while (newDueDate == null) {
					System.out.print("Enter the new task due date (YYYY-MM-DD): ");
					String newDueDateString = scnr.nextLine();
					
					try {
						newDueDate = LocalDate.parse(newDueDateString);
					} catch (DateTimeParseException e) {
						System.out.println("Invalid date format. Please try again.");
					}
				}
				taskManager.editTask(editIndex, newTitle, newDescription, newDueDate);
				System.out.println("Task edited successfuly.");
				break;
			case 3:
				// View all tasks
				taskManager.viewTasks();
				break;
			case 4:
				// Delete a task
				System.out.print("Enter the task number to delete: ");
				int deleteIndex = scnr.nextInt();
				scnr.nextLine();
				
				if (deleteIndex <= 0 || deleteIndex > taskManager.getTasks().size()) {
					System.out.println("Invalid task number. Pleas try again.");
					break;
				}
				
				taskManager.deleteTask(deleteIndex -1);
				System.out.println("Task deleted successfuly.");
				break;
			case 5:
				// Mark a task as completed
				System.out.print("Enter the task number to mark as completed: ");
				int completeIndex = scnr.nextInt();
				scnr.nextLine();
				
				if (completeIndex <= 0 || completeIndex > taskManager.getTasks().size()) {
					System.out.print("Invalid tsk number. Please try again.");
					break;
				}
				taskManager.markTaskAsCompleted(completeIndex -1);
				System.out.println("Task marked as completed successfuly.");
				break;			
			default:
				System.out.println("Invalid choice. Pleas try again.");
			}
			
			System.out.println();
		}
	}
}
