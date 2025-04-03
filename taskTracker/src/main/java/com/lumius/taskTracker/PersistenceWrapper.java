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
			Files.createFile(path);
		}
		catch (FileAlreadyExistsException x) {
			System.out.println("File found!");
		}
		catch (IOException e) {
			System.out.println("IO error when looking for file");
			e.printStackTrace();
		}
		finally {
			try {
				Files.write(path, gson.toJson(wrappee).getBytes());
			}
			catch (IOException e){
				System.out.println("IO exception when writing to file");
				e.printStackTrace();
			}

		}
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
