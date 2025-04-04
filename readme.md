# Task Tracker Application
A command line application to create and manage a to-do list

## Dependencies
<ul>
<li>Java: JRE and/or JDK 17 or later must be installed on the machine</li>
<li>Maven build tool</li>
</ul>

## Running the program
<ol>
<li>Navigate into the project directory (taskTracker) and run the following command: mvn package </li>

<li>There should now be a JAR file in the target directory named "taskTracker-1.0.0.jar" </li>
<li>Run the jar file with the following command: java -jar taskTracker-1.0.0.jar \<rest of args here\></li>
</ol>
For valid args, see Usage section

## Features
<ul>
	<li>Add, update, or delete tasks</li>
	<li>Mark a task as in-progress, or complete</li>
	<li>List all tasks</li>
	<li>List all incomplete tasks</li>
	<li>List tasks in progress</li>
	<li>List complete tasks</li>
</ul>

## Usage
The following commands are available:

**Adding a new task**
<ul>
	<li>java -jar taskTracker-1.0.0.jar add "Buy groceries"</li>
	
</ul>

**Updating and deleting tasks** 
<ul>
	<li>java -jar taskTracker-1.0.0.jar update 1 "Buy groceries and cook dinner"</li>
	<li>java -jar taskTracker-1.0.0.jar delete 1</li>
	
</ul>

**Marking a task as in progress or done**
<ul>
	<li>java -jar taskTracker-1.0.0.jar mark-in-progress 1</li>
	<li>java -jar taskTracker-1.0.0.jar mark-done 1</li>
	
</ul>


**Listing all tasks**
<ul>
	<li>java -jar taskTracker-1.0.0.jar list</li>
	
</ul>



**Listing tasks by status**
<ul>
	<li>java -jar taskTracker-1.0.0.jar list done</li>
	<li>java -jar taskTracker-1.0.0.jar list todo</li>
	<li>java -jar taskTracker-1.0.0.jar list in-progress</li>
	
</ul>
