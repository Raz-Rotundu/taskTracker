package com.lumius.taskTracker;

import java.util.Set;
import java.util.HashSet;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import com.google.gson.Gson;

//public class TaskSet implements JsonSerializable<TaskSet> {
public class TaskSet {
	private Set<Task> tasks;
	
//	Constructors
	public TaskSet() {
		tasks = new HashSet<Task>();
	}
//	Adding/Removing/Updating
	public void add(Task t) {
		this.tasks.add(t);
	}
	
	public void remove(int id) {
		this.tasks = tasks.stream()
		.filter(task -> task.getId() != id)
		.collect(Collectors.toCollection(HashSet::new));
	}
	
	public void update(int id, String newDesc) {
		tasks.stream()
		.forEach(task -> {
			if (task.getId() == id){
				task.setDescription(newDesc);
			}
		});
	}
	
	public void updateStatus(int id, Status newStat) {
		tasks.stream()
		.forEach(task -> {
			if (task.getId() == id){
				task.setStatus(newStat);
			}
		});
	}
	
	public int size() {
		return tasks.size();
	}
//	Printers
	public void printAll() {
		this.tasks.stream()
		.forEach(task -> System.out.println(task));
	}
	
	public void printComplete() {
		this.tasks.stream()
		.filter(task -> task.getStatus() == Status.Complete)
		.forEach(task -> System.out.println(task));
	}
	
	public void printNotStarted() {
		this.tasks.stream()
		.filter(task -> task.getStatus() == Status.NotStarted)
		.forEach(task -> System.out.println(task));
	}
	
	public void printInProgress() {
		this.tasks.stream()
		.filter(task -> task.getStatus() == Status.InProgress)
		.forEach(task -> System.out.println(task));
	}
	
//	Json stuff
//	public String toJson() {
//		return "t";
//	}
//	
//	public TaskSet fromJson(String s) {
//		return new TaskSet();
//	}
}
