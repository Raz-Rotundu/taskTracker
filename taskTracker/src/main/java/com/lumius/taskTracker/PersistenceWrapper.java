package com.lumius.taskTracker;

import java.util.NoSuchElementException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;



public class PersistenceWrapper extends TsWrapper {
	
//	Custom JSON builder with LocalDateTime adaptation
	private static Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdaptor())
			.create();

//	Default path for updating
	private static Path path;
	

	public PersistenceWrapper(TaskSet t, Path p) {
		super(t);
		this.path = p;
	}
	
	private void updateFile() {
		try {
			Files.write(path, gson.toJson(wrappee).getBytes());
		}
		catch (IOException e){
			System.out.println("IO exception when writing to file");
			e.printStackTrace();
		}
	}
	
	@Override
	public String add(String t) {
		String  s = super.add(t);
		updateFile();
		return s;
		
		

	}
	
	@Override
	public void remove(String id) throws NoSuchElementException {
		super.remove(id);
		updateFile();

	}
	
	@Override
	public void update(String id, String newDesc) throws NoSuchElementException {
		super.update(id, newDesc);
		updateFile();

	}
	
	@Override
	public void updateStatus(String id, Status newStat) throws NoSuchElementException {
		super.updateStatus(id, newStat);
		updateFile();

	}
}
