package com.lumius.taskTracker;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;      

/**
 * Task Tracker -- A command line tool to keep track of tasks
 *@author Razvan Rotundu
 */

public class App
{
//	The task set containing all the tasks
	private static TaskSet tasks = new TaskSet();
//	Custom JSON builder with LocalDateTime adaptation
	private static Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdaptor())
			.create();
	
	
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
	
	
	
    public static void main( String[] args )
    {	
    	if (args.length == 0 || args.length > 3) {
    		System.out.println(errorMsgFirst);
    	}
    	try {
        	switch(args[0].toLowerCase()) {
        	case("add"):
        		if(args.length == 2) {
        			tasks.add(args[1]);
        		} else {
        			System.out.println(errorMsgCrud);
        		}
        		break;
        	case("update"):
        		if(args.length == 3) {
        			int id = Integer.valueOf(args[1]).intValue();
        			tasks.update(id, args[2]);
        		} else {
        			System.out.println(errorMsgCrud);
        		}
        		break;
        	case("delete"):
        		if(args.length == 2) {
        			int id = Integer.valueOf(args[1]).intValue();
        			tasks.remove(id);
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
        		} else {
        			System.out.println(errorMsgList);
        		}
        		break;
        	case("mark-done"):
        		if(args.length == 2 && args[0].toLowerCase() == "mark-done") {
        			int id = Integer.valueOf(args[1]).intValue();
        			tasks.updateStatus(id, Status.Complete);
        		} else {
        			System.out.println(errorMsgStatus);
        		}
        		break;
        	case("mark-in-progress"):
        		if(args.length == 2 && args[0].toLowerCase() == "marks-in-progress") {
        			int id = Integer.valueOf(args[1]).intValue();
        			tasks.updateStatus(id, Status.InProgress);
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
