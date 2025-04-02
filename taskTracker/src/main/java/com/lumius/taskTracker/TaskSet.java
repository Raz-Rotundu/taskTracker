package com.lumius.taskTracker;

import java.util.Set;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
/**
 * Taskset -- A singleton set of task objects, serializable to JSON
 * @author Razvan Rotundu
 */
public class TaskSet {
	private Set<Task> tasks;
	
	
//	Constructors
	public TaskSet() {
		tasks = new HashSet<Task>();
	}

	/**
	 * Checks if the task set contains the given element by id
	 * @param id The ID of the task searched for
	 * @return true or false, if the given ID is in the set
	 */
	private boolean includes(int id) {
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
	 */
	public void remove(int id) {
		this.tasks = tasks.stream()
		.filter(task -> task.getId() != id)
		.collect(Collectors.toCollection(HashSet::new));
	}
	
	/**
	 * Change the description of an existing task
	 * @param id The id of an existing task
	 * @param newDesc The new description for the task
	 */
	public void update(int id, String newDesc) {
		tasks.stream()
		.forEach(task -> {
			if (task.getId() == id){
				task.setDescription(newDesc);
			}
		});
	}
	/**
	 * Updates the status of an existing task
	 * @param id
	 * @param newStat
	 */
	public void updateStatus(int id, Status newStat) {
		tasks.stream()
		.forEach(task -> {
			if (task.getId() == id){
				task.setStatus(newStat);
			}
		});
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
