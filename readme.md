# Task Tracker Application
A command line application to create and manage a to-do list
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
	<li>task-cli add "Buy groceries"</li>
	
</ul>

**Updating and deleting tasks** 
<ul>
	<li>task-cli update 1 "Buy groceries and cook dinner"</li>
	<li>task-cli delete 1</li>
	
</ul>

**Marking a task as in progress or done**
<ul>
	<li>task-cli mark-in-progress 1</li>
	<li>task-cli mark-done 1</li>
	
</ul>


**Listing all tasks**
<ul>
	<li>task-cli list</li>
	
</ul>



**Listing tasks by status**
<ul>
	<li>task-cli list done</li>
	<li>task-cli list todo</li>
	<li>task-cli list in-progress</li>
	
</ul>
