package com.lumius.taskTracker;

import java.util.NoSuchElementException;

/**
 * TasksInterface -- Interface for using a collection of tasks
 * @author Razvan
 */
public interface TasksInterface {
	
	public boolean includes(String id);
	
	public String add(String t);
	
	public void remove(String id) throws NoSuchElementException;
	
	public void update(String id, String newDesc) throws NoSuchElementException;
	
	public void updateStatus(String id, Status newStat) throws NoSuchElementException;
	
	public int size();
	
	public void printAll();
	
	public void printComplete();
	
	public void printNotStarted();
	
	public void printInProgress();
}
