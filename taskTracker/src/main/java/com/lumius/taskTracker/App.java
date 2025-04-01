package com.lumius.taskTracker;

/**
 * Task Tracker -- A command line tool to keep track of tasks
 *@author Razvan Rotundu
 */
public class App
{
    public static void main( String[] args )
    {
        TaskSet s = new TaskSet();
		s.add(new Task("foo"));
		s.add(new Task("bar"));
		s.add(new Task("baz"));
		s.add(new Task("raz"));
		
		s.updateStatus(0, Status.Complete);
		s.updateStatus(1, Status.InProgress);
		s.updateStatus(2, Status.InProgress);
		
		s.update(0, "Complete the test");
		System.out.println("COMPLETE");
		s.printComplete();
		System.out.println("IN PROGRESS");
		s.printInProgress();
		System.out.println("INCOMPLETE");
		s.printNotStarted();
		
		
    }
}
