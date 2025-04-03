package com.lumius.taskTracker;

import java.util.Set;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.NoSuchElementException;
/**
 * Taskset -- A set of task objects, serializable to JSON
 * @author Razvan Rotundu
 */
public class TaskSet implements TasksInterface {
	private Set<Task> tasks;


	public TaskSet() {
		tasks = new HashSet<Task>();
	}

	/**
	 * Checks if the task set contains the given element by id
	 * @param id The ID of the task searched for
	 * @return boolean, if the given ID is in the set
	 */
	public boolean includes(String id) {
		return tasks.stream()
				.anyMatch(task -> task.getId() == id);
	}
	/**
	 * Add a given task to the task set
	 * @param t A task object
	 * @return generated ID of the task
	 */
	public String add(String t) {
		Task task = new Task(t);
		this.tasks.add(task);
		return task.getId();
	}
	
	/**
	 * Remove a given task from the task set
	 * @param id the Id of an existing task
	 * @exception NoSuchElementException if given id does not exist in task set
	 */
	public void remove(String id) throws NoSuchElementException {
		if(this.taskPresent(id)) {
			this.tasks = tasks.stream()
					.filter(task -> !task.getId().equals(id))
					.collect(Collectors.toCollection(HashSet::new));
		} else {
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Change the description of an existing task
	 * @param id The id of an existing task
	 * @param newDesc The new description for the task
	 * @exception NoSuchElementException if given id does not exist in task set
	 */
	public void update(String id, String newDesc) throws NoSuchElementException {
		if(this.taskPresent(id)) {
			this.tasks = tasks.stream()
					.map(task -> {
						if (task.getId().equals(id)) {
							task.setDescription(newDesc);
						}
						return task;
					})
					.collect(Collectors.toCollection(HashSet::new));
		} else {
			throw new NoSuchElementException();
		}

	}
	/**
	 * Updates the status of an existing task
	 * @param id
	 * @param newStat
	 * @exception NoSuchElementException if given id does not exist in task set
	 */
	public void updateStatus(String id, Status newStat) throws NoSuchElementException {	
		if(this.taskPresent(id)) {
			this.tasks = tasks.stream()
					.map(task -> {
						if (task.getId().equals(id)) {
							task.setStatus(newStat);
						}
						return task;
					})
					.collect(Collectors.toCollection(HashSet::new));
		} else {
			throw new NoSuchElementException();
		}

	}
	
	/**
	 * 
	 * @return the size of the task set
	 */
	public int size() {
		return (int)tasks.stream()
				.count();
	}

	
	/**
	 * Prints out all tasks currently in the set
	 */
	public void printAll() {
		if (this.size() != 0) {
			this.tasks.stream()
			.forEach(task -> System.out.println(task));
		} else {
			System.out.println("No tasks in list");
		}
	}
	
	/**
	 * Prints out all tasks marked "Complete"
	 */
	public void printComplete() {
		int c = (int)this.tasks.stream()
				.filter(task -> task.getStatus() == Status.Complete)
				.count();
		if(c != 0) {
			this.tasks.stream()
			.filter(task -> task.getStatus() == Status.Complete)
			.forEach(task -> System.out.println(task));
		} else {
			System.out.println("No tasks complete");
		}
	}
	
	/**
	 * Prints out all tasks marked "NotStarted"
	 */
	public void printNotStarted() {
		int c = (int)this.tasks.stream()
				.filter(task -> task.getStatus() == Status.NotStarted)
				.count();
		if (c != 0) {
			this.tasks.stream()
			.filter(task -> task.getStatus() == Status.NotStarted)
			.forEach(task -> System.out.println(task));
		} else {
			System.out.println("No tasks to do");
		}

	}
	
	/**
	 * Prints out all tasks marked "InProgress"
	 */
	public void printInProgress() {
		int c = (int)this.tasks.stream()
				.filter(task -> task.getStatus() == Status.InProgress)
				.count();
		 
		if (c != 0) {
			this.tasks.stream()
			.filter(task -> task.getStatus() == Status.InProgress)
			.forEach(task -> System.out.println(task));

		} else {
			System.out.println("No tasks in progress");
		}

	}
	
	/**
	 * Checks if task is present in the set of the instance object
	 * @param id
	 * @return boolean if the given id is a task present in the set
	 */

	private boolean taskPresent(String id) {
		boolean present =  tasks.stream()
				.map(t -> t.getId())
				.anyMatch(t -> t.equals(id));
		return present;
	}
	/**
	 * Renders set to string
	 * @return string equivalent of printAll
	 */
	@Override
	public String toString() {
		String outString = tasks.stream()
				.map(t -> t.toString())
				.reduce("", (a, t) -> a + t);
		return outString;
	}
}
