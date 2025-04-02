package com.lumius.taskTracker;

import java.util.NoSuchElementException;

/**
 * TasksInterface -- Interface for using a collection of tasks
 * @author Razvan
 */
public interface TasksInterface {
	
	public boolean includes(int id);
	
	public void add(String t);
	
	public void remove(int id) throws NoSuchElementException;
	
	public void update(int id, String newDesc) throws NoSuchElementException;
	
	public void updateStatus(int id, Status newStat) throws NoSuchElementException;
	
	public int size();
	
	public void printAll();
	
	public void printComplete();
	
	public void printNotStarted();
	
	public void printInProgress();
}
