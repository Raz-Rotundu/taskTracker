package com.lumius.taskTracker;

import java.util.NoSuchElementException;

public class TsWrapper implements TasksInterface {
	
	protected TaskSet wrappee;

	public TsWrapper(TaskSet t) {
		wrappee = t;
	}
	
	@Override
	public boolean includes(int id) {
		return wrappee.includes(id);
	}

	@Override
	public void add(String t) {
		wrappee.add(t);

	}

	@Override
	public void remove(int id) throws NoSuchElementException {
		wrappee.remove(id);

	}

	@Override
	public void update(int id, String newDesc) throws NoSuchElementException {
		wrappee.update(id, newDesc);

	}

	@Override
	public void updateStatus(int id, Status newStat) throws NoSuchElementException {
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
