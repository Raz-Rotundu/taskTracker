package com.lumius.taskTracker;

import java.time.LocalDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    		
    	switch(args[0].toLowerCase()) {
    	case("add"):
    		if(args.length == 2) {
    			tasks.add(args[1]);
    		} else {
    			System.out.println(errorMsgCrud);
    		}
    		break;
    	case("update"):
    		break;
    	case("delete"):
    		break;
    	case("list"):
    		break;
    	case("mark-done"):
    		break;
    	case("mark-in-progress"):
    		break;
    	default: 
    		System.out.println(errorMsgFirst);
    		break;
    	}
		
    }
}
