package com.lumius.taskTracker;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Task Tracker -- A command line tool to keep track of tasks
 *@author Razvan Rotundu
 */

public class App
{
//	The task set containing all the tasks
	private static PersistenceWrapper tasks;
	
//	Custom JSON builder with LocalDateTime adaptation
	private static Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdaptor())
			.create();
	
//	Path to save file
	private static final Path savePath = Path.of("savedTasks.txt");
	
	
//	Error message for incorrect first parameter
	private static final String errorMsgFirst = "Usage: First parameter should be one of:"
			+ "%n%t add%n%tupdate %n%t delete %n%tlist %n%tmark-done %n%tmark-in-progress";
//  Error message for incorrect list usage
	private static final String errorMsgList = "Usage: list (done|todo|in-progress)";
//	Error message for incorrect status update
	private static final String errorMsgStatus = "Usage: (mark-done|mark-in-progress) taskId";
//	Error message for incorrect CRUD operations
	private static final String errorMsgCrud = "Usage:%n%t add descriptionString"
			+ "%n%t update ID newDescription"
			+ "%n%t delete ID";
	
	
	
    public static void main(String[] args )
    {	
//    	Look for file first, then if not found, create a new task list
    	try {
    		Files.createFile(savePath);
    		tasks = new PersistenceWrapper(new TaskSet(), savePath);
    	}
    	catch (FileAlreadyExistsException x){
    		System.out.println("Save File Found!");
    		try {
    			String json = Files.readAllLines(savePath).getFirst();
        		tasks = new PersistenceWrapper(gson.fromJson(json, TaskSet.class), savePath);
    		}
    		catch (NoSuchElementException n) {
    			tasks = new PersistenceWrapper(new TaskSet(), savePath);
    		}
    		catch (IOException e) {
    			System.out.println("IO error when reading save file");
    			e.printStackTrace();
    		}
    	}
    	catch (IOException e) {
    		System.out.println("IO error when attempting to access save file");
    		e.printStackTrace();
    	}
    	finally {
    		if (args.length == 0 || args.length > 3) {
        		System.out.println(errorMsgFirst);
        	}
        	try {
            	switch(args[0].toLowerCase()) {
            	case("add"):
            		if(args.length == 2) {
            			String id = tasks.add(args[1]);
            			System.out.printf("Task added successfully (ID:%s)", id);
            			
            		} else {
            			System.out.println(errorMsgCrud);
            		}
            		break;
            	case("update"):
            		if(args.length == 3) {
            			String id = args[1];
            			tasks.update(id, args[2]);
            			System.out.printf("%s -> %s", id, args[2]);
            		} else {
            			System.out.println(errorMsgCrud);
            		}
            		break;
            	case("delete"):
            		if(args.length == 2) {
            			String id = args[1];
            			tasks.remove(id);
            			System.out.printf("Task %s removed successfully", id);
            		} else {
            			System.out.println(errorMsgCrud);
            		}
            		break;
            	case("list"):
            		if(args.length == 2) {
            			String mode = args[1].toLowerCase();
            			switch(mode) {
            			case("done"):
            				tasks.printComplete();
            				break;
            			case("todo"):
            				tasks.printNotStarted();
            				break;
            			case("in-progress"):
            				tasks.printInProgress();
            				break;
            			}
            		} else if (args.length == 1) {
            			tasks.printAll();
            		} else {
            			System.out.println(errorMsgList);
            		}
            		break;
            	case("mark-done"):
            		if(args.length == 2 && args[0].toLowerCase().equals("mark-done")) {
            			String id = args[1];
            			tasks.updateStatus(id, Status.Complete);
            			System.out.printf("(%s) -> Status: Complete", id);
            		} else {
            			System.out.println(errorMsgStatus);
            		}
            		break;
            	case("mark-in-progress"):
            		if(args.length == 2 && args[0].toLowerCase().equals("mark-in-progress")) {
            			String id = args[1];
            			tasks.updateStatus(id, Status.InProgress);
            			System.out.printf("(%s) -> Status: InProgress", id);
            			
            		} else {
            			System.out.println(errorMsgStatus);
            		}
            		break;
            	default: 
            		System.out.println(errorMsgFirst);
            		break;
            	}
        	}
        	catch(NoSuchElementException e) {
        		System.out.println("Index does not exist in set");
        	}
    	}
  
		
    }
}
