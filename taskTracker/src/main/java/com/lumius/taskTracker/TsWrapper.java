package com.lumius.taskTracker;

import java.util.NoSuchElementException;

public class TsWrapper implements TasksInterface {
	
	protected TaskSet wrappee;

	public TsWrapper(TaskSet t) {
		wrappee = t;
	}
	
	@Override
	public boolean includes(String id) {
		return wrappee.includes(id);
	}

	@Override
	public String add(String t) {
		return wrappee.add(t);

	}

	@Override
	public void remove(String id) throws NoSuchElementException {
		wrappee.remove(id);

	}

	@Override
	public void update(String id, String newDesc) throws NoSuchElementException {
		wrappee.update(id, newDesc);

	}

	@Override
	public void updateStatus(String id, Status newStat) throws NoSuchElementException {
		wrappee.updateStatus(id, newStat);

	}

	@Override
	public int size() {
		return wrappee.size();
	}

	@Override
	public void printAll() {
		wrappee.printAll();

	}

	@Override
	public void printComplete() {
		wrappee.printComplete();

	}

	@Override
	public void printNotStarted() {
		// TODO Auto-generated method stub
		wrappee.printNotStarted();

	}

	@Override
	public void printInProgress() {
		// TODO Auto-generated method stub
		wrappee.printInProgress();
	}
	
	public String toString() {
		return wrappee.toString();
	}
}
