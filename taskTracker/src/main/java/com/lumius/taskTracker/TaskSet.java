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
	public boolean includes(int id) {
		return tasks.stream()
				.anyMatch(task -> task.getId() == id);
	}
	/**
	 * Add a given task to the task set
	 * @param t A task object
	 */
	public void add(String t) {
		this.tasks.add(new Task(t));
	}
	
	/**
	 * Remove a given task from the task set
	 * @param id the Id of an existing task
	 * @exception NoSuchElementException if given id does not exist in task set
	 */
	public void remove(int id) throws NoSuchElementException {
		if(this.includes(id)) {
			this.tasks = tasks.stream()
					.filter(task -> task.getId() != id)
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
	public void update(int id, String newDesc) throws NoSuchElementException {
		if(this.includes(id)) {
			tasks.stream()
			.forEach(task -> {
				if (task.getId() == id){
					task.setDescription(newDesc);
				}
			});
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
	public void updateStatus(int id, Status newStat) throws NoSuchElementException {
		if(this.includes(id)) {
			tasks.stream()
			.forEach(task -> {
				if (task.getId() == id){
					task.setStatus(newStat);
				}
			});
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
		this.tasks.stream()
		.forEach(task -> System.out.println(task));
	}
	
	/**
	 * Prints out all tasks marked "Complete"
	 */
	public void printComplete() {
		this.tasks.stream()
		.filter(task -> task.getStatus() == Status.Complete)
		.forEach(task -> System.out.println(task));
	}
	
	/**
	 * Prints out all tasks marked "NotStarted"
	 */
	public void printNotStarted() {
		this.tasks.stream()
		.filter(task -> task.getStatus() == Status.NotStarted)
		.forEach(task -> System.out.println(task));
	}
	
	/**
	 * Prints out all tasks marked "InProgress"
	 */
	public void printInProgress() {
		this.tasks.stream()
		.filter(task -> task.getStatus() == Status.InProgress)
		.forEach(task -> System.out.println(task));
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
