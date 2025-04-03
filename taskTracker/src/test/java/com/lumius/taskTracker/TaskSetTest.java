package com.lumius.taskTracker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TaskSetTest {

	private static TaskSet referenceSet;
	
	@BeforeAll
	static void setup() {
		referenceSet = new TaskSet();	
		
		referenceSet.add("foo");
		referenceSet.add("bar");
		referenceSet.add("baz");
		referenceSet.add("raz");
		
		
	}
//	@Test
//	void testAdd() {
//		assertEquals(4, referenceSet.size());	
//	}
//	
//	@Test
//	void testRemove() {
//		referenceSet.remove(1);
//		assertEquals(3, referenceSet.size());
//	}
}
