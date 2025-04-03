package com.lumius.taskTracker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

	private final String d1 = "Pass the getter test";
	private final String d2 = "Pass the setter test";
	private  final Task myTask = new Task(d1);
	
	@Test
	void getterTest() {
		assertEquals(Status.NotStarted, myTask.getStatus());
		assertEquals(d1, myTask.getDescription());
	}
	
	@Test
	void setterTest() {
		myTask.setDescription(d2);
		myTask.setStatus(Status.InProgress);
		
		assertEquals(d2, myTask.getDescription());
		assertEquals(Status.InProgress, myTask.getStatus());
	}
}
