package com.lumius.taskTracker;

import java.util.NoSuchElementException;

public class PersistenceWrapper extends TsWrapper {
	
//	TODO fix file handling
	public PersistenceWrapper(TaskSet t) {
		super(t);
	}
	
	public static void updateFile() {
		
	}
	
	@Override
	public void add(String t) {
		super.add(t);
		updateFile();
		
		

	}
	
	@Override
	public void remove(int id) throws NoSuchElementException {
		super.remove(id);
		updateFile();

	}
	
	@Override
	public void update(int id, String newDesc) throws NoSuchElementException {
		super.update(id, newDesc);
		updateFile();

	}
	
	@Override
	public void updateStatus(int id, Status newStat) throws NoSuchElementException {
		super.updateStatus(id, newStat);
		updateFile();

	}
}
