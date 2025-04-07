package com.lumius.taskTracker;

import java.util.NoSuchElementException;

public class TsWrapper implements TasksInterface {
	
	protected TaskSet wrappee;

	public TsWrapper(TaskSet t) {
		wrappee = t;
	}
	
	/**
	 * Checks if the task set contains the given element by id
	 * @param id The ID of the task searched for
	 * @return boolean, if the given ID is in the set
	 */
	@Override
	public boolean includes(String id) {
		return wrappee.includes(id);
	}

	/**
	 * Add a given task to the task set
	 * @param t A task object
	 * @return generated ID of the task
	 */
	@Override
	public String add(String t) {
		return wrappee.add(t);

	}

	/**
	 * Remove a given task from the task set
	 * @param id the Id of an existing task
	 * @exception NoSuchElementException if given id does not exist in task set
	 */
	@Override
	public void remove(String id) throws NoSuchElementException {
		wrappee.remove(id);

	}

	/**
	 * Change the description of an existing task
	 * @param id The id of an existing task
	 * @param newDesc The new description for the task
	 * @exception NoSuchElementException if given id does not exist in task set
	 */
	@Override
	public void update(String id, String newDesc) throws NoSuchElementException {
		wrappee.update(id, newDesc);

	}

	/**
	 * Updates the status of an existing task
	 * @param id
	 * @param newStat
	 * @exception NoSuchElementException if given id does not exist in task set
	 */
	@Override
	public void updateStatus(String id, Status newStat) throws NoSuchElementException {
		wrappee.updateStatus(id, newStat);

	}

	/**
	 * 
	 * @return the size of the task set
	 */
	@Override
	public int size() {
		return wrappee.size();
	}

	/**
	 * Prints out all tasks currently in the set
	 */
	@Override
	public void printAll() {
		wrappee.printAll();

	}

	/**
	 * Prints out all tasks marked "Complete"
	 */
	@Override
	public void printComplete() {
		wrappee.printComplete();

	}

	/**
	 * Prints out all tasks marked "NotStarted"
	 */
	@Override
	public void printNotStarted() {
		// TODO Auto-generated method stub
		wrappee.printNotStarted();

	}

	/**
	 * Prints out all tasks marked "InProgress"
	 */
	@Override
	public void printInProgress() {
		// TODO Auto-generated method stub
		wrappee.printInProgress();
	}
	
	/**
	 * Renders set to string
	 * @return string equivalent of printAll
	 */
	public String toString() {
		return wrappee.toString();
	}
}
