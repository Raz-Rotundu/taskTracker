package com.lumius.taskTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Task -- Represents an individual task in the task tracker
 * @author Razvan Rotundu
 */
public class Task {
//	Formatting date/time to readable string
	public static DateTimeFormatter taskDateFormat= DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
	
	private static int numTasks = 0;
	
	private int id;
	private String description;
	private Status status;
	private LocalDateTime timeCreated;
	private LocalDateTime timeModified;
	

	/**
	 * Create a task object with current date and time. Default set to notStarted
	 * @param description -- A description of the task
	 */
	public Task(String description) {
		this.description = description;
		this.status = Status.NotStarted;
		
		this.timeCreated = LocalDateTime.now();
		this.timeModified = LocalDateTime.now();
		
		this.id = numTasks;
		numTasks++;
	}


	/**
	 * Returns the unique identifier for the task
	 * @return unique integer
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Returns the task status
	 * @return either 'Complete', 'NotStarted', or 'InProgress enum values
	 */
	public Status getStatus() {
		return this.status;
	}
	
	/**
	 * Returns a description of the task
	 * @return a string describing the task to be done
	 */
	public String getDescription() {
		return this.description;
	}
	
	/**
	 * Returns the time the task was created
	 * @return LocalDateTime object indicating when task was created
	 */
	public LocalDateTime getTimeCreated() {
		return this.timeCreated;
	}
	
	/**
	 * Returns the last time the task was modified
	 * @return LocalDateTime object representing the last time the task was modified
	 */
	public LocalDateTime getTimeModified() {
		return this.timeModified;
	}
	
//	User can only change the description or the status
	/**
	 * Sets the description of the task 
	 * @param desc - A string describing the task to be done
	 */
	public void setDescription(String desc) {
		this.description = desc;
		this.timeModified = LocalDateTime.now();
	}
	/**
	 * Sets the status of the task
	 * @param one of 'Complete', 'NotStarted', or 'InProgress' Status enum values
	 */
	public void setStatus(Status stat) {
		this.status = stat;
		this.timeModified = LocalDateTime.now();
	}
	
	/**
	 * Returns string format ID, Status, Times created + modified, NEWLINE, Description
	 * @return string representation of object
	 */
	public String toString(){
		String bar = "-------------------------------------------------";
		String outString = String.format("Id: %d%nStatus: %s%nTime Created: %s%nTime Modified: %s%nDescription: %s%n" + bar, id, status, timeCreated.format(taskDateFormat), timeModified.format(taskDateFormat), description);
		return outString;
	}
}
