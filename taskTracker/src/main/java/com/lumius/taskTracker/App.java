package com.lumius.taskTracker;

/**
 * Task Tracker -- A command line tool to keep track of tasks
 *@author Razvan Rotundu
 */
public class App
{
    public static void main( String[] args )
    {
        Task test = new Task("testing");
        System.out.println(test);
    }
}
